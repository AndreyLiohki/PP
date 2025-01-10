package filehandler;

import java.io.*;
import java.util.ArrayList;

public class PlainTextReader implements FileHandler {
    @Override
    public ArrayList<String> readFile(String filePath) {
        ArrayList<String> expressions = new ArrayList<>();

        try {
            FileProcessor fileProcessor = new FileProcessor();
            byte[] fileData = fileProcessor.processFile(filePath);

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(fileData)))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    expressions.add(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return expressions;
    }
}
