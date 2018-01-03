package ru.compscience.excelreader;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reader {

    private Workbook workbook;

    Logger log;

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

        log.log(Level.FINE,"Reader successfully created");

    }

    public String getValue(String sheetName, String line, int column){
        Sheet sheet = workbook.getSheet(sheetName);

        String cellAdress = line +
                            column;

        CellReference cellReference = new CellReference(cellAdress);
        Row row = sheet.getRow(cellReference.getRow());
        Cell cell = row.getCell(cellReference.getCol());

        String res = "";
        if (cell != null) {
            switch (cell.getCellTypeEnum()) {
                case _NONE:
                    log.log(Level.WARNING, "No such cell: " + cellAdress);
                    break;
                case NUMERIC:
                    res += cell.getNumericCellValue() + "";
                    break;
                case STRING:
                    res += cell.getStringCellValue();
                    break;
                case FORMULA:
                    log.log(Level.WARNING, "Formula in cell: " + cellAdress);
                    break;
                case BLANK:
                    log.log(Level.FINE, cellAdress + " is empty");
                    break;
                case BOOLEAN:
                    res += cell.getBooleanCellValue() + "";
                    break;
                case ERROR:
                    log.log(Level.WARNING, "Error in cell: " + cellAdress);
                    break;
            }
        }

        return res;
    }

    public String getValue(int sheetIndex, String line, int column){
        Sheet sheet = workbook.getSheetAt(sheetIndex);

        String cellAdress = line +
                            column;

        CellReference cellReference = new CellReference(cellAdress);
        Row row = sheet.getRow(cellReference.getRow());
        Cell cell = row.getCell(cellReference.getCol());

        String res = "";
        if (cell != null) {
            switch (cell.getCellTypeEnum()) {
                case _NONE:
                    log.log(Level.WARNING, "No such cell: " + cellAdress);
                    break;
                case NUMERIC:
                    res += cell.getNumericCellValue() + "";
                    break;
                case STRING:
                    res += cell.getStringCellValue();
                    break;
                case FORMULA:
                    log.log(Level.WARNING, "Formula in cell: " + cellAdress);
                    break;
                case BLANK:
                    log.log(Level.FINE, cellAdress + " is empty");
                    break;
                case BOOLEAN:
                    res += cell.getBooleanCellValue() + "";
                    break;
                case ERROR:
                    log.log(Level.WARNING, "Error in cell: " + cellAdress);
                    break;
            }
        }

        return res;
    }

}
