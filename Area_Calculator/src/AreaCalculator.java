import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AreaCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
//        List<String> list = new ArrayList<>();
//        list.add(string.split(" "));
        //String[] str1 = string.split(" ");
        while (!string.equals("Quit")) {
            String[] str1 = string.split(" ");
            if (str1[0].equalsIgnoreCase("Triangle")) {

                double base = Float.parseFloat(str1[1]);
                double height = Float.parseFloat(str1[2]);
                System.out.printf("Area of Triangle: %.2f\n",base*height*0.5);
            }
            else if(str1[0].equalsIgnoreCase("Rectangle")){
                double width = Float.parseFloat(str1[1]);
                double height = Float.parseFloat(str1[2]);
                System.out.printf("Area of Rectangle: %.2f\n",width*height);
            }
            else if(str1[0].equalsIgnoreCase("Circle")){
                double radius = Float.parseFloat(str1[1]);
                System.out.printf("Area of Circle: %.2f\n",radius*radius*Math.PI);
            }
            else {
                System.out.println("Invalid\n");
            }
            string = scanner.nextLine();
        }
        System.out.println("Bye\n");
        scanner.close();

    }
}