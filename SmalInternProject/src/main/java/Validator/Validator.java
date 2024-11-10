package Validator;

import java.util.Stack;
import java.util.regex.Pattern;

public class Validator {

    public static boolean isValidExpression(String expression){
        expression = expression.replaceAll("\\s+", "");
        expression = expression.replaceAll("[^\\d\\+\\-\\*/\\^()]", "");

        String pattern = "^[\\d()/*+\\-]+$";
        if(!Pattern.matches(pattern, expression)){
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for(char ch: expression.toCharArray()){
            if(ch == '('){
                stack.push(ch);
            }else{
                if(ch == ')'){
                    if(stack.isEmpty()){
                        return false;
                    }
                    stack.pop();
                }
            }
        }

        if(!stack.isEmpty()){
            return false;
        }

        if (expression.matches(".*[+\\-*/]{2,}.*")) {
            return false;
        }
        if (expression.startsWith("+") || expression.startsWith("-") || expression.startsWith("*") || expression.startsWith("/")
                || expression.endsWith("+") || expression.endsWith("-") || expression.endsWith("*") || expression.endsWith("/")) {
            return false;
        }

        return true;
    }

}
