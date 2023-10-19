import java.util.concurrent.atomic.AtomicInteger;

public class Student {

    private static final AtomicInteger COUNTER = new AtomicInteger(0);

    private String studentID;

    private String name ;

    private int year ;

    private double GPA ;



    public Student(String name, int year, double GPA) {

        this.studentID = "PNU2023" + COUNTER.incrementAndGet();

        this.name = name;

        this.year = year;

        this.GPA = GPA;

    }

    // implement your code

}

