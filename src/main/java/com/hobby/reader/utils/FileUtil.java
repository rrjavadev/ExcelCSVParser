package com.hobby.reader.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class FileUtil {

    private final String fileName;

    public FileUtil(String fileName){
    this.fileName = fileName;
    }

    public Reader getFileInputStream(){
        InputStream inputStream =  getClass().getClassLoader().getResourceAsStream(fileName);
        return new BufferedReader(new InputStreamReader(inputStream));
    }
}
