import java.util.Scanner;

import static java.lang.Math.*;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
       //scanner.nextLine();
        for (int i =0;i<num;i++){
            double d1;
            try{
                d1 = scanner.nextInt();
            } catch (Exception e){
                System.out.println("Invalid number format.\n");
                scanner.nextLine();
                continue;
            }
            String s2 = scanner.next();
            if (s2 .equals("sqrt")){
                System.out.printf("Result: %.2f\n",Math.sqrt(d1));
                scanner.nextLine();
                continue;
            }
            double d2;
            try {
                d2=Double.parseDouble(s2);
            }catch (Exception e){
                System.out.println("Invalid number format.\n");
                scanner.nextLine();
                continue;
            }
            String s3 = scanner.next();
            switch (s3){
                case "+":{
                    System.out.printf("Result: %.2f\n",d1+d2);
                    break;
                }
                case "-":{
                    System.out.printf("Result: %.2f\n",d1-d2);
                    break;
                }
                case "*":{
                    System.out.printf("Result: %.2f\n",d1*d2); break;}
                case "^":{
                    System.out.printf("Result: %.2f\n",Math.pow(d1,d2)); break;}
                case "%":{
                    System.out.printf("Result: %.2f\n",d1%d2); break;}
                case "/":{
                    if (d2==0f) {System.out.printf("Division by zero.\n");}
                    else {System.out.printf("Result: %.2f\n",d1/d2);}
                    break;
                }
                default:{
                    System.out.printf("Invalid operator.\n");break;}
            }

        }

//        Scanner scanner = new Scanner(System.in);
//
//        int num = scanner.nextInt();
//        scanner.nextLine();
//
//        for (int i=0; i<num; i++){
//            double n=0;
//            try{
//                n = Double.parseDouble(scanner.next());
//            }catch (Exception e){
//                System.out.println("Invalid number format.");
//                scanner.nextLine();
//                continue;
//            }
//            String M = scanner.next();
////            try{
////                float m = scanner.nextInt();
////            }catch (Exception e){
////
////            }
//            double m=0;
//            if(M.equals("sqrt")){
//                System.out.printf("Result: %.2f\n",sqrt(n));
//                scanner.nextLine();
//                continue;
//            }
//            try{
//                m=Double.parseDouble(M);
//            }catch (Exception e){
//                System.out.println("Invalid number format.");
//                scanner.nextLine();
//                continue;
//            }
//
//
//            String cal = scanner.next();
//            //float output;
//
//            if (cal.equals("+")){
//                System.out.println("Result: "+String.format("%.2f",n+m));
//            } else if (cal.equals("-")) {
//                System.out.println("Result: "+String.format("%.2f",n-m));
//            } else if (cal.equals("*")) {
//                System.out.println("Result: "+String.format("%.2f",n*m));
//            } else if (cal.equals("/")) {
//                if (m==0f){
//                    System.out.println("Division by zero.");
//                }else
//                System.out.println("Result: "+String.format("%.2f",n/m));
//            } else if (cal.equals("^")) {
//                System.out.println("Result: "+String.format("%.2f",pow(n,m)));
//            } else if (cal.equals("%")) {
//                System.out.println("Result: "+String.format("%.2f",n%m));
//            } else{
//                System.out.println("Invalid operator.");
//            }
//
//        }

    }
}