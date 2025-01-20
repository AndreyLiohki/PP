package filehandler;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Map;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONFileHandler implements FileHandler{
    @Override
    public ArrayList<String> readFile(String filePath) {
        ArrayList<String> expressions = new ArrayList<>();

        try {
            FileProcessor fileProcessor = new FileProcessor();
            byte[] fileData = fileProcessor.processFile(filePath);

            ObjectMapper objectMapper = new ObjectMapper();

            Map<String, Object> jsonData = objectMapper.readValue(new ByteArrayInputStream(fileData), Map.class);
            if (jsonData.containsKey("expressions")) {
                Object expressionsObj = jsonData.get("expressions");

                if (expressionsObj instanceof ArrayList) {
                    expressions = objectMapper.convertValue(expressionsObj, new TypeReference<ArrayList<String>>() {});
                } else {
                    throw new IllegalArgumentException("Invalid structure: 'expressions' is not an array.");
                }
            } else {
                throw new IllegalArgumentException("Key 'expressions' not found in JSON.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return expressions;
    }
}
