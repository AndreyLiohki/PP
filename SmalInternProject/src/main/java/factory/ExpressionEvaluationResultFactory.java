package factory;

import objects.ExpressionEvaluationResult;

public class ExpressionEvaluationResultFactory {
    public static ExpressionEvaluationResult getExpressionEvaluationResult(){
        return new ExpressionEvaluationResult();
    }
}
