//Лёгкий Адрейм 2 курс 5 группа
//Задание
//Задан текстовый файл input.txt. Требуется определить строки этого файла, содержащие максимальную по длине подстроку, состоящую из одинаковых символов русского алфавита.
//Заглавные и строчные буквы не различаются. Если таких строк несколько, найти первые 10. Результат вывести на консоль в форме, удобной для чтения.
//
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Vector;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class Main {

    static class Pair{
        String first;
        String second;

        Pair(String first, String second){
            this.first = first;
            this.second = second;
        }
    }
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Andrey\\IdeaProjects\\Lab3Task4\\src\\Input.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            String regex = "([а-я])\\1+";
            int patternSize = 0;
            int maxSize = 0;
            Pattern substring = Pattern.compile(regex);
            Vector<Pair> words = new Vector<>();

            while ((line = br.readLine()) != null) {
                line = line.toLowerCase();
                Matcher matcher = substring.matcher(line);

                String substr = "";
                boolean flag = false;
                while(matcher.find()){

                    String currentLine = matcher.group();
                    int currentSize = currentLine.length();

                    if(currentSize >= patternSize){
                        patternSize = currentSize;
                        substr = currentLine;
                        flag = true;
                    }
                }
                if(flag){
                    Pair pair = new Pair(line, substr);
                    words.add(pair);
                    flag = !flag;
                }

            }

            words.sort(Comparator.comparingInt(pair->pair.second.length()));

            int index = words.size()-1;
            int maximumSize = words.get(index).second.length();
            while(words.get(index).second.length() == maximumSize){
                System.out.println(words.get(index).first);
                index--;
            }

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}