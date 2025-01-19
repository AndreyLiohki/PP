package org.example;

public class Controller {
    public void runProgramm(){
        Factorial countFactorial = new Factorial();
        int factNumber = EnterData.readData();
        countFactorial.setFactorNumber(factNumber);
        printResult.print(countFactorial.countFibonacciNumbers(), factNumber);
    }
}
