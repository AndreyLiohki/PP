package lab1;
import java.text.*;
import java.io.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Solution {
    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(isr);
        NumberFormat formatter = NumberFormat.getNumberInstance();
        try {
            BigDecimal x = new BigDecimal(-2);
            int k = -2;
            String line;
            int amountofdots= -1;
            while (x.compareTo(BigDecimal.valueOf(-1)) <= 0 || x.compareTo(BigDecimal.valueOf(1)) >= 0) {
                System.out.println("Введите число, arcsin которого необходимо вычислить. Число X должно находиться на интервале (-1;1)");
                line = bf.readLine();
                x = new BigDecimal(line);
            }

            while (k <= -1) {
                System.out.println("Введите степень числа 10. Это точность вычисления arcsin(x)");
                line = bf.readLine();
                k = Integer.parseInt(line);
            }
            	while(amountofdots <=0) {
            		System.out.println(" введите количество точек после запятой ");
                    line = bf.readLine();
                    amountofdots = Integer.parseInt(line);
            	}
            BigDecimal sum = BigDecimal.ZERO;
            BigDecimal slag = x;
            int n = 2;

            while (slag.abs().compareTo(BigDecimal.valueOf(Math.pow(10, -k))) > 0) {
                sum = sum.add(slag);
                slag = slag.multiply(x.multiply(BigDecimal.valueOf(n - 1)).multiply(x)).divide(BigDecimal.valueOf(n), MathContext.DECIMAL128).divide(BigDecimal.valueOf(n + 1), MathContext.DECIMAL128);
                n += 2;
            }
            formatter.setMaximumFractionDigits(amountofdots);
            System.out.print("Вычисленный arcsin(x): ");
            System.out.println(formatter.format(sum));
            System.out.println("Стандартный arcsin(x): " + BigDecimal.valueOf(Math.asin(x.doubleValue())));
        } catch (NumberFormatException e) {
            System.out.println("Error: неверный формат числа.");
        } catch (IOException e) {
            System.out.println("Error: ошибка ввода-вывода.");
        }
    }
}


