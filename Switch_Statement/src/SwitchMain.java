import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SwitchMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        List<String> array = new ArrayList<>();
        while (!a.equals("quit")){
            switch (a){
                case "add 1":
                    array.add("January"); break;
                case "add 2":
                    array.add("February"); break;
                case "add 3":
                    array.add("March"); break;
                case "add 4":
                    array.add("April"); break;
                case "add 5":
                    array.add("May"); break;
                case "add 6":
                    array.add("June"); break;
                case "add 7":
                    array.add("July"); break;
                case "add 8":
                    array.add("August"); break;
                case "add 9":
                    array.add("September"); break;
                case "add 10":
                    array.add("October");
                    break;
                case "add 11":
                    array.add("November");
                    break;
                case "add 12":
                    array.add("December");
                    break;
                case "print":
                    System.out.println(array);
                    break;
                default:
                    System.out.println("Invalid Command");
                    break;



            }
            a = scanner.nextLine();
        }
        System.out.println("bye");
        scanner.close();
    }
}