package ru.compscience.excelreader;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reader {

    private static final int PRINT_MODE_LINE = 0;
    private static final int PRINT_MODE_COLUMN = 1;

    private Workbook workbook;

    private List< Pair < Map <String , Integer> , Map <String , Integer > > > indPull;

    private Logger log;

    public Reader(String nonDefPath , String fileName , String extension) throws IOException, InvalidFormatException {
        log = Logger.getLogger(Reader.class.getName());

        StringBuilder sb = new StringBuilder();
        if(nonDefPath != null) {
            sb.append(nonDefPath);
        }else {
            sb.append("excel.source");
        }
        sb.append("\\");
        sb.append(fileName);
        sb.append(".");
        sb.append(extension);

        String path = sb.toString();

        FileInputStream file = new FileInputStream(new File(path));

        workbook = WorkbookFactory.create(file);

        log.log(Level.INFO,"Indexing...");

        indPull = new ArrayList<>();

        for(int i = 0; i < workbook.getNumberOfSheets(); ++i){

            Map<String, Integer> columns = new HashMap<>();
            Map<String, Integer> lines = new HashMap<>();

            Sheet sheet = workbook.getSheetAt(i);
            if(sheet == null)
                return;

            Row row = sheet.getRow(0);

            short minColIx = row.getFirstCellNum();
            short maxColIx = row.getLastCellNum();
            for(short colIx = minColIx; colIx < maxColIx; ++colIx) {
                Cell cell = row.getCell(colIx);
                columns.put(cell.getStringCellValue() , cell.getColumnIndex());
            }

            int minLineIx = sheet.getFirstRowNum();
            int maxLineIx = sheet.getLastRowNum();
            for(int lineIx = minLineIx; lineIx < maxLineIx; ++lineIx){
                Row r = sheet.getRow(lineIx);
                Cell cell = null;
                if(r != null)
                    cell = r.getCell(0);

                if(cell != null) {
                    switch (cell.getCellTypeEnum()) {
                        case STRING:
                            lines.put(cell.getStringCellValue(), cell.getRowIndex());
                            break;
                        case NUMERIC:
                            lines.put(cell.getNumericCellValue() + "", cell.getRowIndex());
                            break;
                    }

                }
            }

            Pair pair = new Pair< Map <String , Integer> , Map <String , Integer > >(lines, columns);

            indPull.add(pair);
        }

        log.log(Level.INFO,"Reader successfully created");
    }

    public void printTableArgs(){
        for(int i = 0; i < workbook.getNumberOfSheets(); ++i) {

            System.out.println("--------------------------- " + i + " SHEET -----------------------------");

            Iterator it = indPull.get(i).second.entrySet().iterator();
            printCollection(it, PRINT_MODE_LINE);

            System.out.println();

            it = indPull.get(i).first.entrySet().iterator();
            printCollection(it, PRINT_MODE_COLUMN);

            System.out.println("--------------------------- " + i + " SHEET -----------------------------");

        }
    }
    private void printCollection(Iterator it, int mode){
        if(mode == PRINT_MODE_LINE)
            System.out.print("| ");
        else
            System.out.println(" - ");
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();

            if(mode == PRINT_MODE_LINE){
                System.out.print(entry.getKey() + " : " + entry.getValue() + " | ");
            }else {
                System.out.println(entry.getKey() + " : " + entry.getValue() + "\n - ");
            }
        }
    }

    public String getValue(String sheetName, String line, int column){
        Sheet sheet = workbook.getSheet(sheetName);

        String cellAdress = line +
                            column;

        CellReference cellReference = new CellReference(cellAdress);
        Row row = sheet.getRow(cellReference.getRow());
        Cell cell = row.getCell(cellReference.getCol());

        return getCellValue(cell);
    }

    public String getValue(int sheetIndex, String line, int column){
        Sheet sheet = workbook.getSheetAt(sheetIndex);

        return getValue(sheet.getSheetName(), line, column);
    }

    private String getCellValue(Cell cell){

        String res = "";
        if (cell != null) {
            switch (cell.getCellTypeEnum()) {
                case _NONE:
                    log.log(Level.WARNING, "No such cell: " + cell.getAddress().toString());
                    break;
                case NUMERIC:
                    res += cell.getNumericCellValue() + "";
                    break;
                case STRING:
                    res += cell.getStringCellValue();
                    break;
                case FORMULA:
                    log.log(Level.WARNING, "Formula in cell: " + cell.getAddress().toString());
                    break;
                case BLANK:
                    log.log(Level.INFO, cell.getAddress().toString() + " is empty");
                    break;
                case BOOLEAN:
                    res += cell.getBooleanCellValue() + "";
                    break;
                case ERROR:
                    log.log(Level.WARNING, "Error in cell: " + cell.getAddress().toString());
                    break;
            }
        }

        return res;
    }

    public String getValueByTableArgs(int sheetIndex, String line, String column){
        Cell cell = getCellByTableArgs(sheetIndex, line, column);

        return getCellValue(cell);
    }

    public String getValueByTableArgs(String sheetName, String line, String column){
        Cell cell = getCellByTableArgs(sheetName, line, column);

        return getCellValue(cell);
    }

    private Cell getCellByTableArgs(int sheetIx, String line, String column){

        int rowIndex = indPull.get(sheetIx).first.get(line);
        int columnIx = indPull.get(sheetIx).second.get(column);

        return workbook.getSheetAt(sheetIx).getRow(rowIndex).getCell(columnIx);
    }

    private Cell getCellByTableArgs(String sheetName, String line, String column){
        int sheetIx = 0;

        for(int i = 0; i < workbook.getNumberOfSheets(); ++i){
            if(workbook.getSheetAt(i).getSheetName().equals(sheetName)){
                sheetIx = i;
                break;
            }
        }

        return getCellByTableArgs(sheetIx, line, column);
    }

}
