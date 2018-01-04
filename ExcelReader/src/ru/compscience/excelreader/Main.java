package ru.compscience.excelreader;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;

public class Main {

    public static void main(String[] arg){
        try {
            new Reader(null, "source", "xlsm");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
    }
}
