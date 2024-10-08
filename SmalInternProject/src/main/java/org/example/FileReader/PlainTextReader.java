package org.example.FileReader;

import org.example.ExpressionClass.Expression;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class PlainTextReader implements FileReader{
    @Override
    public void read(String filePath, Expression exp){
        try{
            exp.expression = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            System.err.println("Error reading palin text file: " + e.getMessage());
        }

    }
}
