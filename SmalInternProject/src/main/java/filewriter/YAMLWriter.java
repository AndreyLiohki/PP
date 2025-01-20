package filewriter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import objects.ExpressionEvaluationResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class YAMLWriter implements ResultWriter{
    @Override
    public void writeToFile(ArrayList<ExpressionEvaluationResult> results, String filePath) {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        try {
            objectMapper.writeValue(new File(filePath), results);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
