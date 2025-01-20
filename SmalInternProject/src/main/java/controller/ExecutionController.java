package controller;

import Singleton.ExpressionValidatorHandler;
import factory.FileReaderFactory;
import factory.FileReaderFactoryProvider;
import objects.ExpressionEvaluationResult;
import Singleton.ExpressionProcessorHandler;
import filewriter.ResultWriter;
import writerfactory.ResultWriterFactory;
import java.util.ArrayList;

public class ExecutionController {
    public static ArrayList<ExpressionEvaluationResult> executeEvaluation(String fileExtension, String filePath) {
        FileReaderFactory factory = FileReaderFactoryProvider.getFactory(fileExtension);

        ArrayList<String> expressions = factory.createFileReader().readFile(filePath);
        ArrayList<ExpressionEvaluationResult> answers = new ArrayList<>();

        for (String expression : expressions) {
            if (ExpressionValidatorHandler.getInstance().isValidExpression(expression)) {
                answers.add(ExpressionProcessorHandler.getInstance().evaluate(expression));
            } else {
                ExpressionEvaluationResult wrongEvaluationResult = new ExpressionEvaluationResult();
                String wrongAnswer = "Expression - " + expression + " is not valid";
                wrongEvaluationResult.setResult(wrongAnswer);
                answers.add(wrongEvaluationResult);
            }
        }

        ResultWriter writer = ResultWriterFactory.getWriter(fileExtension);
        writer.writeToFile(answers, "results." + fileExtension);

        return answers;
    }
}