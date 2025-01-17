package Singleton;

import processor.ExpressionProcessor;

public class ExpressionProcessorHandler {
    private static ExpressionProcessor instance;

    public static ExpressionProcessor getInstance(){
        if(instance == null){
            synchronized (ExpressionProcessorHandler.class){
                if(instance == null){
                    instance = new ExpressionProcessor();
                }
            }
        }
        return instance;
    }
}
