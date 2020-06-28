package com.hobby.reader;

import com.hobby.reader.utils.FileUtil;
import com.monitorjbl.xlsx.StreamingReader;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;

public class ExcelXStreamReader implements XLSXReader{

    public List<String> getRecords(String fileName) {

        FileUtil fileUtil = new FileUtil(fileName);

        Workbook workbook = StreamingReader.builder()
                .rowCacheSize(100)    // number of rows to keep in memory (defaults to 10)
                .bufferSize(4096)     // buffer size to use when reading InputStream to file (defaults to 1024)
                .open(getClass().getClassLoader().getResourceAsStream(fileName)); // InputStream or File for XLSX file (required)

        Sheet sheet = workbook.getSheetAt(0); //get first sheet

        for (Row r : sheet) {
//            for (Row c : r) {
                System.out.println(r.iterator().next().getRow());
//            }
        }

        return null;
    }
}
