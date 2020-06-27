package com.hobby.reader;

import java.util.List;

public class MainClass {

    private static final String FILE_LOCATION = "csv/sample.csv";

    public static void main(String[] args) {

        //4.1MB file
        //ApacheCommons - 376ms
        //OpenCSV - 1399ms

        CSVReader reader = new ApacheCommonsCSVReader();
        Long start = System.currentTimeMillis();
        List<String> csvRecords = reader.getRecords(FILE_LOCATION);
        Long end = System.currentTimeMillis();
        System.out.println("Difference" + (end - start) + "ms");

        System.out.println("\n\n");
        Long start2 = System.currentTimeMillis();
        reader = new OpenCsvReader();
        List<String> openCsv = reader.getRecords(FILE_LOCATION);
        Long end2 = System.currentTimeMillis();
        System.out.println("Difference openCsv" + (end2 - start2) + "ms");
    }
}
