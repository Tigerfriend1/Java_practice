import java.util.Scanner;

public class ReverseStringMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        String a="";
        for (int i = s.length()-1; i>=0; i--){
            a+=s.charAt(i);
        }
        System.out.println(a);

    }
}