package filewriter;

import com.fasterxml.jackson.databind.ObjectMapper;
import objects.ExpressionEvaluationResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class JSONWriter implements ResultWriter{
    @Override
    public void writeToFile(ArrayList<ExpressionEvaluationResult> results, String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(filePath), results);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
