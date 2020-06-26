package com.hobby.reader.utils;

import java.io.InputStream;

public class FileUtil {

    private final String fileName;

    public FileUtil(String fileName){
    this.fileName = fileName;
    }

    public  InputStream getFileInputStream(){
        return getClass().getClassLoader().getResourceAsStream(fileName);
    }
}
