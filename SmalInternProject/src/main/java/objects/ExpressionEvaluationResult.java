package objects;

public class ExpressionEvaluationResult {
    private String result;
    public ExpressionEvaluationResult() {
    }
    public ExpressionEvaluationResult(String result) {
        this.result = result;

    }
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString(){
        return result;
    }
}
