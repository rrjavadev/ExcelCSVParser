package com.hobby.reader;

import com.hobby.reader.utils.FileUtil;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;

public class OpenCsvReader implements CSVReader {

    @Override
    public List<String> getRecords(String fileName) {

        FileUtil fileUtil = new FileUtil(fileName);
        try (com.opencsv.CSVReader reader = new com.opencsv.CSVReader(fileUtil.getFileInputStream())) {
            String[] line = null;
            while ((line = reader.readNext()) != null) {
                Arrays.stream(line).forEach(System.out::print);
                System.out.println("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
