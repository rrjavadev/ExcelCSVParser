package com.hobby.reader;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;
import java.util.List;

public class MainClass {

    private static final String CSV_SAMPLE = "csv/sample.csv";
    private static final String XLSX_SAMPLE = "/Users/roshinivr/hobby/ExcelCSVParser/src/main/resources/xlsx/sample_xlsx.xlsx";

    public static void main(String[] args) throws IOException, InvalidFormatException {

        //4.1MB file
        //ApacheCommons - 376ms
        //OpenCSV - 1399ms

//        CSVReader reader = new ApacheCommonsCSVReader();
//        Long start = System.currentTimeMillis();
//        List<String> csvRecords = reader.getRecords(CSV_SAMPLE);
//        Long end = System.currentTimeMillis();
//        System.out.println("Difference" + (end - start) + "ms");
//
//        System.out.println("\n\n");
//        Long start2 = System.currentTimeMillis();
//        reader = new OpenCsvReader();
//        List<String> openCsv = reader.getRecords(CSV_SAMPLE);
//        Long end2 = System.currentTimeMillis();
//        System.out.println("Difference openCsv" + (end2 - start2) + "ms");

        System.out.println("\n\n");
        Long start3 = System.currentTimeMillis();
        XLSXReader xlsxReader = new ExcelXStreamReader();
        List<String> xlsxRecords = xlsxReader.getRecords(XLSX_SAMPLE);
        Long end3 = System.currentTimeMillis();
        System.out.println("Difference xlsx" + (end3 - start3) + "ms");
    }
}
