package com.hobby.reader;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;
import java.util.List;

public interface XLSXReader {
    public List<String> getRecords(String fileName) throws IOException, InvalidFormatException;
}
