package filewriter;

import objects.ExpressionEvaluationResult;
import java.util.ArrayList;

public interface ResultWriter {
    void writeToFile(ArrayList<ExpressionEvaluationResult> results, String filePath);
}
