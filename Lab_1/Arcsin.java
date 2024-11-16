//Лёгки Андрей 2 курс 5 группа

package lab1;
import java.text.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(isr);
        double x = -2;
        int k = -2;
        String line;
        int amountOfDots = -1;

        try {
            while (x <= -1 || x >= 1) {
                System.out.println("Введите число, arcsin которого необходимо вычислить. Число X должно находиться на интервале (-1;1)");
                line = bf.readLine();
                x = Double.parseDouble(line);
            }

            while (k <= -1) {
                System.out.println("Введите степень числа 10. Это точность вычисления arcsin(x)");
                line = bf.readLine();
                k = Integer.parseInt(line);
            }

            while (amountOfDots <= 0) {
                System.out.println("Введите количество точек после запятой");
                line = bf.readLine();
                amountOfDots = Integer.parseInt(line);
            }

            double sum = 0.0;
            double slag = x;
            int n = 2;

            while (Math.abs(slag) > Math.pow(10, -k)) {
                sum += slag;
                slag = slag * (x * (n - 1) * x) / (n * (n + 1));
                n += 2;
            }

            String format = "%." + amountOfDots + "f";
            System.out.println("Вычисленный arcsin(x): "  + " "+ sum);
            System.out.println("Стандартный arcsin(x): " + Math.asin(x));
        } catch (NumberFormatException e) {
            System.out.println("Error: неверный формат числа.");
        } catch (IOException e) {
            System.out.println("Error: ошибка ввода-вывода.");
        }
    }
}