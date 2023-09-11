import java.util.Scanner;

public class OperatorMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        float fN = (float)N;
        float fM = (float)M;
        //System.out.println(N+" / "+M+" = "+fN/fM);
        System.out.printf("%d / %d = %.3f \n",N,M,fN/fM);
        System.out.println(N+" = "+N/M+" x "+M+" + "+N%M);
    }
}