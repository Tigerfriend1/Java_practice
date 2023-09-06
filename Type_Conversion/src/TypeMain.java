import java.util.Scanner;
public class TypeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        printType(name);
        int intname=Integer.parseInt(name);
        System.out.println("Type Conversion to int...");
        printType(intname);
        float floatname= (float) intname;
        System.out.println("Type Conversion to float...");
        printType(floatname);
        scanner.close();


    }
    private static void printType(String x) {
        System.out.println(x + " is a string");
    }
    private static void printType(int x) {
        System.out.println(x + " is an int");
    }
    private static void printType(float x) {
        System.out.println(x + " is a float");
    }
}
