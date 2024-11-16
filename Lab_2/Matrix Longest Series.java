//Лёгкий Андрей 2 курс, 5 группа
//Необходимо найти номер строки матрицы, в которой находится самая длинная серия(последовательность одинаковых элементов)
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int counter = 1;
        int maximum = Integer.MIN_VALUE;
        int index = -1;

        System.out.println("Введите количество строк и стобцов в матрице:");

        int n = in.nextInt();
        int m = in.nextInt();

        int matrix[][] = new int[n][m];

        System.out.println("Введите матрицу");
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                matrix[i][j] = in.nextInt();
            }
        }

        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                if(j == 0){
                    counter = 1;
                }else{
                    if(matrix[i][j] == matrix[i][j-1]){
                        counter++;
                    }else{
                        if(counter >= maximum){
                            maximum = counter;
                            counter = 1;
                            index = i;
                        }
                    }
                }
            }
            if(counter >= maximum){
                maximum = counter;
                counter = 1;
                index = i;
            }
            counter = 1;
        }
        System.out.print("Строка с максимальной серией: ");
        System.out.println(index);
        System.out.println("Матрица");

        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}