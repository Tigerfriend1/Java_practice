public class Student extends Person {
    private String schoolName ;
    private Grade grade;
    public Student(String name, int age, String address, String schoolName) {
        super(name, age, address) ;
        this.schoolName = schoolName ;
    }
    public String getSchoolName() { return schoolName ; }
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName ;
    }
    public Grade getGrade() { return grade ; }
    public void upGrade() { grade.upGrade() ; }
    @Override
    public String toString() {
        return String.format("%s, %d, %s, %s, %s",
                getName(), getAge(), getAddress(), schoolName, grade) ;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Student)){
            return false;
        }
        Student p = (Student) obj;
        return getName().equals(p.getName())&&getAge()== p.getAge()&&getAddress().equals(p.getAddress())&&getGrade()==p.getGrade();
    }

// override hashCode() and equals()
}