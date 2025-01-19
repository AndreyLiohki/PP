package org.example;

import java.util.Scanner;

public class EnterData {
    public static int readData(){
        Scanner myScanner = new Scanner(System.in);
        int number;
        number = myScanner.nextInt();
        while(number >=104 || number <0){
            System.out.println("Введите номер числа, факториал которого нужно вычислить. Номер должен быть меньше 23 и больше или равное 0");
            number = myScanner.nextInt();
        }
        return number;
    }
}
