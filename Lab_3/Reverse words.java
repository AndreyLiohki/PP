import java.util.StringTokenizer;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String line = scan.nextLine();

        StringTokenizer tokenizer = new StringTokenizer(line, "., !^&/?><:;|\\{[}]#$%!*)(%;№");

        Vector<String> arr = new Vector<>();

        while (tokenizer.hasMoreElements()) {
            String token = tokenizer.nextToken();
            arr.add(token);
        }

        String answer = "";
        for(int i = 0; i < arr.size(); ++i){
            if(arr.get(i).length() >4 && arr.get(i).matches("[a-zA-Z]+")){
                String reversed = new StringBuilder(arr.get(i)).reverse().toString();
                answer +=reversed;
            }else{
                answer+= arr.get(i);
            }
            answer+=" ";

        }
        System.out.println("Все слова: " + answer);
    }
}