import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DateTimeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        while(true){
            System.out.println("1. Diff\n" +
                    "2. Add/Sub\n" +
                    "3. Week\n" +
                    "4. Exit");
            int order = scanner.nextInt();
            switch (order){
                case 1: {
                    System.out.print("Menu: first date (YYYY-MM-DD): ");
                    String str_date1 = scanner.next();
                    System.out.print("second date (YYYY-MM-DD): ");
                    String str_date2 = scanner.next();
                    try {
                        LocalDate date1 = LocalDate.parse(str_date1, formatter);
                        LocalDate date2 = LocalDate.parse(str_date2, formatter);
                        long diffInDays = Math.abs(date1.toEpochDay() - date2.toEpochDay());

                        System.out.println("Diff: "+diffInDays+" days");
                    }catch (Exception e){
                        System.out.printf("Invalid date format.");
                        continue;
                    }



                    break;
                }
                case 2:{
                    try {
                        System.out.print("Menu: date (YYYY-MM-DD): ");
                        String str_date1 = scanner.next();
                        System.out.print("days to add/subtract: ");
                        int day= scanner.nextInt();
                        LocalDate date1 = LocalDate.parse(str_date1,formatter);
                        date1 = date1.plusDays(day);
                        System.out.println("New date: "+formatter.format(date1));
                        //System.out.println("New date: "+date1.format(formatter));
                    }catch (Exception e){

                    }


                    break;


                }
                case 3:{
                    try {
                        System.out.print("Menu: date (YYYY-MM-DD): ");
                        String str_date1 = scanner.next();

                        LocalDate date1 = LocalDate.parse(str_date1,formatter);

                        System.out.println("Day of the week: "+date1.getDayOfWeek());
                    }catch (Exception e){
                        System.out.printf("Invalid date format.");
                        continue;
                    }
                    break;
                }
                case 4:{
                    System.out.println("Menu: Exiting...");
                    return; // Exit the program
                }
            }
        }

    }
}
