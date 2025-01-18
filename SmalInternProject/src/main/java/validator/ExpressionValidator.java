package validator;

import java.util.Stack;

public class ExpressionValidator {
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }
    private boolean isDivisionByZero(String expression) {
        String[] tokens = expression.split(" "); // Разделяем выражение на токены
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("/")) {
                if (i + 1 < tokens.length && tokens[i + 1].equals("0")) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isValidExpression(String expression) {
        Stack<Character> stack = new Stack<>();
        boolean lastWasOperator = true;
        int numOperators = 0;

        if(isDivisionByZero(expression)){
            return false;
        }
        for (int i = 0; i < expression.length(); i++) {
            char current = expression.charAt(i);
            if (current == '/' && (i + 1 < expression.length() && expression.charAt(i + 1) == '0')) {
                return false;
            }
            if (Character.isDigit(current) || current == '.') {
                lastWasOperator = false;
            } else if (current == '(') {
                stack.push(current);
                lastWasOperator = true;
            } else if (current == ')') {
                if (stack.isEmpty() || lastWasOperator) {
                    return false;
                }
                stack.pop();
                lastWasOperator = false;
            } else if (isOperator(current)) {
                if (lastWasOperator) {
                    return false;
                }
                lastWasOperator = true;
                numOperators++;
            } else if (!Character.isWhitespace(current)) {
                return false;
            }
        }

        return stack.isEmpty() && !lastWasOperator;
    }
}