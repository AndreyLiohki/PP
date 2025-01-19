package org.example;

public class Factorial {
    private int factorialNumber;
    private long[] arrayOfFactorials;

    public void setFactorNumber(int number){
        this.factorialNumber = number;
    }

    public int getFactorNumber() {
        return factorialNumber;
    }

    public long countFibonacciNumbers(){
        if(factorialNumber == 0){
            return 1;
        }
        arrayOfFactorials = new long[factorialNumber+1];
        arrayOfFactorials[0] = 1;
        for(int i = 1; i <= factorialNumber; ++i){
            arrayOfFactorials[i] = arrayOfFactorials[i-1] *i;
        }
        return arrayOfFactorials[factorialNumber];
    }
}
