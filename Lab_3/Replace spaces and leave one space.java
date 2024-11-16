import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class Main {
    public static void main(String[] args) {
        String line;

        Scanner scan = new Scanner(System.in);
        System.out.println("Введите строку для обработки");

        line = scan.nextLine();

        System.out.println("Текущая строка до изменений: " + line);

        String changedSpaces = line.replace(' ', '+');

        String onlyOneSpace = "";

        String regex = "\\b[A-Za-z0-9]+\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);

        while(matcher.find()){
            onlyOneSpace += matcher.group() + " ";
        }

        onlyOneSpace.trim();

        System.out.println("Измененная исходная строка, в которой все пробеы заменены на "+": " + changedSpaces);
        System.out.println("исходная строка, в которой между словами ровно один пробел: " + onlyOneSpace);

    }
}