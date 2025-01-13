package filehandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class YAMLFileHandler implements FileHandler{
    @Override
    public ArrayList<String> readFile(String filePath) {
        ArrayList<String> expressions = new ArrayList<>();

        try {
            FileProcessor fileProcessor = new FileProcessor();
            byte[] fileData = fileProcessor.processFile(filePath);

            ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
            Map<String, Object> yamlData = objectMapper.readValue(new ByteArrayInputStream(fileData), Map.class);

            if (yamlData.containsKey("expressions")) {
                Object expressionsObj = yamlData.get("expressions");

                if (expressionsObj instanceof ArrayList) {
                    for (Object expression : (ArrayList<?>) expressionsObj) {
                        if (expression instanceof String) {
                            expressions.add((String) expression);
                        }
                    }
                } else {
                    throw new IllegalArgumentException("YAML file has incorrect structure.");
                }
            } else {
                throw new IllegalArgumentException("Key 'expressions' not found in YAML.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return expressions;
    }

}
