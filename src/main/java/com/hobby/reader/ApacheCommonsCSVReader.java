package com.hobby.reader;

import com.hobby.reader.utils.FileUtil;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class ApacheCommonsCSVReader implements CSVReader {

    @Override
    public List<String> getRecords(String fileName) {

        FileUtil fileUtil = new FileUtil(fileName);
        try (Reader reader = fileUtil.getFileInputStream()) {
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(reader);
           while(records.iterator() .hasNext()) {
                System.out.println(records.iterator().next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
