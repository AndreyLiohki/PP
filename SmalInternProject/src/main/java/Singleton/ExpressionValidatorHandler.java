package Singleton;

import validator.ExpressionValidator;

public class ExpressionValidatorHandler {
    private static ExpressionValidator instance;

    public static ExpressionValidator getInstance(){
        if(instance == null){
            synchronized (ExpressionProcessorHandler.class){
                if(instance == null){
                    instance = new ExpressionValidator();
                }
            }
        }
        return instance;
    }
}
