package org.example.FileReader;

import java.io.BufferedReader;
import java.io.IOException;

public class FileReader {
    private String line;

    public String ReadFile(String filePath){
        try(BufferedReader reader = new BufferedReader(new java.io.FileReader(filePath))){
            line = reader.readLine();
        }catch(IOException e){
            e.printStackTrace();
        }
        return line;
    }

}
