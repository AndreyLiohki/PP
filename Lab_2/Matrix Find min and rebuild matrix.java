//Лёгкий Андрей 2 курс 5 группа
// Необходимо  в данной квадратной матрице найти минимальный элемент,
// затем получить новую мтарицу из исходной путём добавления к исходной строки и столбца,
// в которых находится минимальный элемент.

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Введите размрность матрицы: ");
        int n = scan.nextInt();

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>(n);

        System.out.println("Введите матрицу: ");
        for(int i = 0; i < n; ++i){
            ArrayList<Integer> arr = new ArrayList<>(n);
            for(int j = 0; j < n; ++j){
                int a = scan.nextInt();;
                arr.add(a);
            }

            matrix.add(arr);
        }
        int a = Integer.MAX_VALUE;
        int rowindex = -1;
        int columnindex = -1;
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                if(matrix.get(i).get(j) < a){
                    a = matrix.get(i).get(j);
                    rowindex = i;
                    columnindex = j;
                }
            }
        }
        ArrayList<ArrayList<Integer>> newmatrix = new ArrayList<>(n+1);
        for(int i = 0; i < n+1; ++i){
            ArrayList<Integer> arr = new ArrayList<>(n+1);
            if(i < n){
                for(int j = 0; j < n+1; ++j){
                    if(j <n){
                        arr.add(matrix.get(i).get(j));
                    }else{
                        arr.add(matrix.get(i).get(columnindex));
                    }
                }
            }else{
                for(int j = 0; j < n+1; ++j){
                    if(j<n)
                        arr.add(matrix.get(rowindex).get(j));
                    else
                        arr.add(a);


                }
            }
            newmatrix.add(arr);

        }
        for(int i = 0; i < n+1; ++i){
            for(int j = 0; j < n+1; ++j){
                System.out.print(newmatrix.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}