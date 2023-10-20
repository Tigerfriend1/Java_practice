import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class School {

    private String name;

    private List<Student> students;

    public School(String name) {

        this.name = name;

        this.students = new ArrayList<>();

    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student){
        this.students.add(student);
    }

    public void listAllStudents() {
        if(this.getStudents().isEmpty()){
            System.out.println("No students enrolled.\n");
            return;
        }
        System.out.printf("All students:\n");
        for (Student stu : this.getStudents()){
            System.out.printf("Student{studentID=\'%s\', name=\'%s\', year=%d grade, GPA=%.1f}\n",stu.getStudentID(),stu.getName(),stu.getYear(),stu.getGPA());
        }
    }

    public void removeAllStudent() {
        this.students.clear();

    }
    public void removeStudent(String removeID){
        int idx=-1;
        for ( int i=1; i<this.getStudents().size();i++){
            if (this.getStudents().get(i).getStudentID().equals(removeID)){
                idx=i;
            }
        }
        if(idx==-1){
            System.out.println("we dont have that student");
        }
        else{
            this.students.remove(idx);
        }

    }

    public List<Student> listTopStudentsByGPA(int topNum){
        List<Student> studentList = new ArrayList<>();
        List<Student> copyStudents = new ArrayList<>(this.getStudents());
        //GPA값을 기준으로 정렬함.
        Collections.sort(copyStudents, new School.CustomComparator());
        //topNum개수만큼 리스트에 담아서 반환
        for (int i=0; i<topNum;i++){
            studentList.add(copyStudents.get(i));
        }
        return studentList;
    }

    public List<Student> findStudentByYear(int year){
        List<Student> studentList = new ArrayList<>();

        for (Student stu: this.getStudents()){
            if(stu.getYear()==year) {
                studentList.add(stu);
            }
        }
        return studentList;
    }

    public static class CustomComparator implements Comparator<Student>{
        @Override
        public int compare(Student stu1, Student stu2){
            if(stu1.getGPA()>stu2.getGPA()){
                return -1;
            }
            else{
                return 1;
            }
        }
    }

}