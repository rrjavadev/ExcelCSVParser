package com.hobby.reader;

import com.hobby.reader.utils.FileUtil;
import com.monitorjbl.xlsx.StreamingReader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

public class ExcelXStreamReader implements XLSXReader {

    public List<String> getRecords2(String fileName) {

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

    public List<String> getRecords3(String fileName) throws IOException {

        Workbook wb = WorkbookFactory.create(new File(fileName));

        InputStream file = new FileInputStream(
                new File(fileName));
        Workbook workbook = StreamingReader.builder().rowCacheSize(100) // number of rows to keep in memory
                .bufferSize(4096) // index of sheet to use (defaults to 0)
                .open(file); // InputStream or File for XLSX file (required)

        Iterator<Row> rowIterator = workbook.getSheetAt(0).rowIterator();
        int count = 0;
        while (rowIterator.hasNext() && count < 50) {
            Row row = rowIterator.next();
            DataFormatter dataFormatter = new DataFormatter();
            System.out.println(dataFormatter.formatCellValue(row.cellIterator().next()));
//            while (rowIterator.next().cellIterator().hasNext()) {
//                Cell cell = rowIterator.next().cellIterator().next();
//                DataFormatter dataFormatter = new DataFormatter();
//                String cellValue = dataFormatter.formatCellValue(cell);
//                System.out.println(cellValue);
//            }
        }
        return null;
    }


    @Override
    public List<String> getRecords(String fileName) throws IOException, InvalidFormatException {

        try (InputStream inp = new FileInputStream(fileName)) {
            XSSFWorkbook wb = new XSSFWorkbook(new File(fileName));

            DataFormatter formatter = new DataFormatter();
            XSSFSheet mySheet = wb.getSheetAt(0);

            Iterator<Row> rowIterator = mySheet.iterator();
            int count = 0;

            while (rowIterator.hasNext() && count < 50) {
                Row row = rowIterator.next();
                count++;

                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t");
                            break;
                        case BOOLEAN:
                            System.out.print(cell.getBooleanCellValue() + "\t");
                            break;
                        default:
                    }
                }
                System.out.println("");
            }
        }
        return null;
    }
}
