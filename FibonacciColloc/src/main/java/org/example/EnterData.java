package org.example;

import java.util.Scanner;

public class EnterData {
    public static int readData(){
        Scanner myScanner = new Scanner(System.in);
        int number;
        number = myScanner.nextInt();
        while(number >=104 || number <0){
            System.out.println("Введите номер числа Фиббоначи. Номер должен быть меньше 104 и больше 0");
            number = myScanner.nextInt();
        }
        return number;
    }
}
