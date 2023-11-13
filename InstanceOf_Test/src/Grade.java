//public enum Grade {
//    FRESH(1), SOPHOMORE(2) ,JUNIOR(3), SENIOR(4) ;
//    private int grade ;
//    private Grade() { this.grade = 1 ; }
//    private Grade(int grade) { this.grade = grade ; }
//    public int getGrade() { return grade ; }
//    public void upGrade() { if ( this != SENIOR ) grade ++ ; }
//    @Override
//    public String toString() { return String.valueOf(grade); }
//// override hashCode() and equals()
//}
public class Grade {
    public static final int FRESH = 1 ;
    public static final int SOPHOMORE = 2 ;
    public static final int JUNIOR = 3 ;
    public static final int SENIOR = 4 ;
    private int grade ;
    public Grade() { this.grade = FRESH ; }
    public Grade(int grade) { this.grade = grade ; }
    public int getGrade() { return grade ; }
    public void upGrade() { if ( grade != SENIOR ) grade ++ ; }
    @Override
    public String toString() { return String.valueOf(grade); }
// override hashCode() and equals()
}