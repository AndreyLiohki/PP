package org.example;

public class FibonacciNumbers {
    private int numOfFibonacciNumbers;
    private long[] arrayOfFibonacci;

    public void setNumOfFibonacciNumbers(int number){
        this.numOfFibonacciNumbers = number;
    }

    public int getNumOfFibonacciNumbers() {
        return numOfFibonacciNumbers;
    }

    public long countFibonacciNumbers(){
        if(numOfFibonacciNumbers == 0){
            return 0;
        }
        arrayOfFibonacci = new long[numOfFibonacciNumbers+1];
        arrayOfFibonacci[0] = 0;
        arrayOfFibonacci[1] = 1;
        for(int i = 2; i <= numOfFibonacciNumbers; ++i){
            arrayOfFibonacci[i] = arrayOfFibonacci[i-1] + arrayOfFibonacci[i-2];
        }
        return arrayOfFibonacci[numOfFibonacciNumbers];
    }
}
