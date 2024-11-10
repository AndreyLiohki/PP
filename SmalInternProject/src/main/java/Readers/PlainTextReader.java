package Readers;

import Validator.Validator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PlainTextReader implements ReadFile {
    private Validator validator;

    @Override
    public String[] readFile(String filePath){
        ArrayList<String> correctLines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 0;

            while ((line = br.readLine()) != null) {
                lineNumber++;
                if (validator.isValidExpression(line)) {
                    correctLines.add(line);
                } else {
                    System.out.printf("Line %d: expression is incorrect%n", lineNumber);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return correctLines.toArray(new String[0]);
    }
}
