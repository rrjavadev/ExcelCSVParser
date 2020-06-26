package com.hobby.reader;

import java.util.List;

public class CSVReader implements BaseReader{

    private static final String FILE_LOCATION = "classpath:";
    private final ApacheCommonsCSVReader csvReader;

    public CSVReader(){
        this.csvReader = new ApacheCommonsCSVReader();
    }

    public List<String> getRecords(String fileName) {
        return null;
    }
}
