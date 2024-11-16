
import java.util.Scanner;
public class Main {
    static boolean isValidSymbol(char x){
        if((x>='a' && x<='z')||
                (x>='A' && x<='Z')||
                (x>='0' && x<='9')){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String line = scan.nextLine();
        StringBuffer stringBuffer = new StringBuffer(line.toLowerCase());
        StringBuffer a = new StringBuffer();
        for(int i = 0; i < stringBuffer.length(); ++i){
            int k = i;

            while(isValidSymbol(stringBuffer.charAt(k))){
                a.append(stringBuffer.charAt(k));
                k++;
                if(k >= stringBuffer.length()){
                    break;
                }
            }
            if(k>i)
                a.append(" ");
            i = k;
        }
        System.out.println("Измененная строка: " + a);
    }
}