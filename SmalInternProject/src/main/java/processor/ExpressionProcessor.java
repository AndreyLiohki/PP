package processor;

import factory.ExpressionEvaluationResultFactory;
import objects.ExpressionEvaluationResult;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionProcessor {
    private  int precedence(String operator){
        switch(operator){
            case "+":
            case "-": return 1;
            case "*":
            case "/": return 2;
            case "^": return 3;
            default: return -1;
        }
    }
    private  boolean isNumber(String token){
        try{
            Double.parseDouble(token);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
    private  boolean isOperator(String token){
        return token.matches("[+\\-*/^]");
    }
    private  double applyOperator(double a, double b, String operator){
        switch(operator){
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
            case "^": return Math.pow(a,b);
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);

        }
    }
    private  String infixTiPostfix(String infix){
        Stack<String> operators = new Stack<>();
        StringBuilder result = new StringBuilder();

        Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?|[()+\\-*/^]");
        Matcher matcher = pattern.matcher(infix);

        while(matcher.find()){
            String token = matcher.group();

            if(isNumber(token)){
                result.append(token).append(" ");
            }else if(token.equals("(")){
                operators.push(token);
            }else if(token.equals(")")){
                while(!operators.isEmpty() && ! operators.peek().equals("(")){
                    result.append(operators.pop()).append(" ");
                }
                operators.pop();
            }else if(isOperator(token)){
                while(!operators.isEmpty() && precedence(operators.peek()) >= precedence(token)){
                    result.append(operators.pop()).append(" ");
                }
                operators.push(token);
            }
        }
        while(!operators.isEmpty()){
            result.append(operators.pop()).append(" ");
        }
        return result.toString().trim();
    }
    private  String evaluateUsingStack(String postfix){
        Stack<Double> stack = new Stack<>();
        String[] tokens = postfix.split("\\s+");

        for(String token : tokens){
            if(isNumber(token)){
                stack.push(Double.parseDouble(token));
            }else if(isOperator(token)){
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid expression: insufficient operands for operator " + token);
                }
                double b = stack.pop();
                double a = stack.pop();
                double result = applyOperator(a, b, token);
                stack.push(result);
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid expression: stack imbalance after processing.");
        }

        return Double.toString(stack.pop());
    }
    private  String evaluateUsingRegularExpressions(String expression){
        Stack<Double> stack = new Stack<>();
        String[] tokens = expression.split("\\s+");

        for(String token:tokens){
            if(token.matches("-?\\d+(\\.\\d+)?")){
                stack.push(Double.parseDouble(token));
            }else if(isOperator(token)){
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid expression: insufficient operands for operator " + token);
                }
                double b = stack.pop();
                double a = stack.pop();
                double result = applyOperator(a, b, token);
                stack.push(result);
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid expression: stack imbalance after processing.");
        }

        return Double.toString(stack.pop());
    }
    private  String evaluateUsingInnerLibrary(String expression) {
        try {
            Expression e = new ExpressionBuilder(expression).build();

            double result = e.evaluate();

            return Double.toString(result);
        } catch (Exception e) {
            return "Error evaluating expression: " + e.getMessage();
        }
    }
    public  ExpressionEvaluationResult evaluate(String expression){
        ExpressionEvaluationResult answer = ExpressionEvaluationResultFactory.getExpressionEvaluationResult();
        String postfix = infixTiPostfix(expression);
        String toSet = "Result of evaluating arithmetic expression using Stack " + evaluateUsingStack(postfix) + "\n"
                +"Result of evaluating arithmetic expression using Regular Expression " + evaluateUsingRegularExpressions(postfix) + "\n"
                +"Result of evaluating arithmetic expression using Inner Library " + evaluateUsingInnerLibrary(expression) + "\n\n";
        answer.setResult(toSet);
        return answer;
    }
}
