import java.util.Scanner;

import static java.lang.Math.*;

public class BasicCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        scanner.nextLine();

        for (int i=0; i<num; i++){
            float n=0;
            try{
                n = scanner.nextInt();
            }catch (Exception e){
                System.out.println("Invalid number format.");
                continue;
            }
            String M = scanner.next();
//            try{
//                float m = scanner.nextInt();
//            }catch (Exception e){
//
//            }
            float m=0;
            if(M.equals("sqrt")){
                System.out.println("Result: "+sqrt(n));
                continue;
            }
            try{
                m=Float.valueOf(M);
            }catch (Exception e){
                System.out.println("Invalid number format.");
                continue;
            }


            String cal = scanner.next();
            //float output;

            if (cal.equals("+")){
                System.out.println("Result: "+String.format("%.2f",n+m));
            } else if (cal.equals("-")) {
                System.out.println("Result: "+String.format("%.2f",n-m));
            } else if (cal.equals("*")) {
                System.out.println("Result: "+String.format("%.2f",n*m));
            } else if (cal.equals("/")) {
                if (m==0f){
                    System.out.println("Division by zero.");
                }else
                System.out.println("Result: "+String.format("%.2f",n/m));
            } else if (cal.equals("^")) {
                System.out.println("Result: "+String.format("%.2f",pow(n,m)));
            } else if (cal.equals("%")) {
                System.out.println("Result: "+String.format("%.2f",n%m));
            }

        }

    }
}