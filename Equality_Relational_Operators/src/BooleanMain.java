import java.util.Scanner;

public class BooleanMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N=scanner.nextInt();
        int M=scanner.nextInt();
        System.out.println("Number1 : "+N+", Number2 : "+M);
        if (N>M){
            System.out.println("Number1 > Number2 ? true");
        }
        else{
            System.out.println("Number1 > Number2 ? false");
        }
        if (N<M){
            System.out.println("Number1 < Number2 ? true");
        }
        else{
            System.out.println("Number1 < Number2 ? false");
        }
        if (N==M) {
            System.out.println("Number1 == Number2 ? true");
        }
        else{
            System.out.println("Number1 == Number2 ? false");
        }


    }
}