import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int rows, columns;

        System.out.println("Введите количество строк в матрице");
        rows = in.nextInt();

        System.out.println("Введите количество колонок в матрице");
        columns = in.nextInt();

        Vector<Vector<Integer>> matrix = new Vector<>();

        // Заполнение матрицы
        for (int i = 0; i < rows; ++i) {
            Vector<Integer> row = new Vector<>(columns);
            for (int j = 0; j < columns; ++j) {
                int a = in.nextInt();
                row.add(a);
            }
            matrix.add(row);
        }

        Vector<Integer> localMinimums = new Vector<>();

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                boolean isLocalMin = true;

                if (i > 0 && matrix.get(i).get(j) >= matrix.get(i - 1).get(j)) {
                    isLocalMin = false;
                }
                if (i < rows - 1 && matrix.get(i).get(j) >= matrix.get(i + 1).get(j)) {
                    isLocalMin = false;
                }
                if (j > 0 && matrix.get(i).get(j) >= matrix.get(i).get(j - 1)) {
                    isLocalMin = false;
                }
                if (j < columns - 1 && matrix.get(i).get(j) >= matrix.get(i).get(j + 1)) {
                    isLocalMin = false;
                }

                if (isLocalMin) {
                    localMinimums.add(matrix.get(i).get(j));
                }
            }
        }

        int maximum = Integer.MIN_VALUE;
        for (int value : localMinimums) {
            if (value > maximum) {
                maximum = value;
            }
        }

        if (!localMinimums.isEmpty()) {
            System.out.println("Максимальный среди всех локальных минимумов: " + maximum);
        } else {
            System.out.println("Локальные минимумы не найдены.");
        }
    }
}