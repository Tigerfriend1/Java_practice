import java.util.*;

public class SchoolTest {

    private static final Scanner scanner = new Scanner(System.in);

    private static final School school = new School("PNU");



    private static final Map<Command, Runnable> commandMap = new HashMap<>();
    private static String name ;

    private static int year ;

    private static double GPA ;

    private static int topNum;

    private static int findNum;

    private static String removeID;


    static {

        commandMap.put(Command.ADD, SchoolTest::addStudent);

        commandMap.put(Command.REMOVE, SchoolTest::removeStudent);

        commandMap.put(Command.FIND, SchoolTest::findStudentByYear);

        commandMap.put(Command.TOP, SchoolTest::listTopStudentsByGPA);

        commandMap.put(Command.CLEAR, () -> {

            school.removeAllStudent();

            System.out.println("All students have been removed.");

        });

        commandMap.put(Command.LIST, SchoolTest::listAllStudents);

        commandMap.put(Command.QUIT, () -> System.out.println("Goodbye!"));

        commandMap.put(Command.INVALID, () -> System.out.println("Invalid command!"));

    }




    public static void main(String[] args) {

        while (true) {

            Command cmd = getCommand();

            commandMap.getOrDefault(cmd, commandMap.get(Command.INVALID)).run();

            if (cmd == Command.QUIT) {

                break;

            }

        }

    }



    private static Command getCommand() {

        System.out.print("Enter command: ");

        String input = scanner.next().toUpperCase();

        try {
            if (input.equals("ADD")){
                name = scanner.next();
                year = scanner.nextInt();
                GPA = scanner.nextDouble();
            }
            else if(input.equals("TOP")){
                topNum = scanner.nextInt();
            }
            else if(input.equals("FIND")){
                findNum= scanner.nextInt();
            }
            else if(input.equals("REMOVE")){
                removeID = scanner.next();
            }

            return Command.valueOf(input);

        } catch (IllegalArgumentException e) {

            return Command.INVALID;

        }

    }



    // implement your code

    enum Command{
        ADD, REMOVE, FIND, TOP, CLEAR, LIST, QUIT, INVALID

    }

    private static void addStudent() {
        Student student = new Student(name, year, GPA);
        school.addStudent(student);

    }
    private static void listAllStudents() {
        //Student{studentID='PNU20231', name='Kim', year=2 grade, GPA=3.5}
        school.listAllStudents();
    }

    private static void listTopStudentsByGPA() {
        System.out.printf("Top %d students by GPA:\n",topNum);
        for (Student stu : school.listTopStudentsByGPA(topNum)){
            System.out.printf("Student{studentID=\'%s\', name=\'%s\', year=%d grade, GPA=%.1f}\n",stu.getStudentID(),stu.getName(),stu.getYear(),stu.getGPA());
        }
    }


    private static void findStudentByYear() {
        System.out.printf("Students for year %d:\n",findNum);
        for (Student stu : school.findStudentByYear(findNum)){
            System.out.printf("Student{studentID=\'%s\', name=\'%s\', year=%d grade, GPA=%.1f}\n",stu.getStudentID(),stu.getName(),stu.getYear(),stu.getGPA());
        }
    }

    private static void removeStudent() {
        school.removeStudent(removeID);
        System.out.println("Student removed (if present).\n");

    }



}