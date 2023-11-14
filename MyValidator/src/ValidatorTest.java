import student.Student;
import student.StudentRepository;

public class ValidatorTest {

    public static void main(String[] args) {

        StudentRepository repo = new StudentRepository();



        Student student1 = new Student("S001", "Jo");

        repo.save(student1);

        Student student2 = new Student("S002", null);

        repo.save(student2);

        Student student3 = new Student("S003", "John");

        repo.save(student3);

    }

}