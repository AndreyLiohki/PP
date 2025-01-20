package filewriter;

import objects.ExpressionEvaluationResult;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PlainTextWriter implements ResultWriter{
    @Override
    public void writeToFile(ArrayList<ExpressionEvaluationResult> results, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (ExpressionEvaluationResult result : results) {
                writer.write(result.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
