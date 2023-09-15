import java.util.Scanner;

import static java.lang.Math.*;

public class BasicCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        scanner.nextLine();

        for (int i=0; i<num; i++){
            double n=0;
            try{
                n = Double.parseDouble(scanner.next());
            }catch (Exception e){
                System.out.println("Invalid number format.");
                scanner.nextLine();
                continue;
            }
            String M = scanner.next();
//            try{
//                float m = scanner.nextInt();
//            }catch (Exception e){
//
//            }
            double m=0;
            if(M.equals("sqrt")){
                System.out.printf("Result: %.2f\n",sqrt(n));
                scanner.nextLine();
                continue;
            }
            try{
                m=Double.parseDouble(M);
            }catch (Exception e){
                System.out.println("Invalid number format.");
                scanner.nextLine();
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
            } else{
                System.out.println("Invalid operator.");
            }

        }

    }
}