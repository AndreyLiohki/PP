package org.example;

public class Controller {
    public void runProgramm(){
        FibonacciNumbers countFibonacci = new FibonacciNumbers();
        int numberOfFibonacci = EnterData.readData();
        countFibonacci.setNumOfFibonacciNumbers(numberOfFibonacci);
        printResult.print(countFibonacci.countFibonacciNumbers(), numberOfFibonacci);
    }
}
