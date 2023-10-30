public class Professor extends Person {
    String schoolName;
    String major;
    public Professor(String name, int age, String address, String schoolName, String major) {
        super(name,age,address);
        this.schoolName = schoolName;
        this.major = major;
    }

//    public void rename(String thomson) {
//    }

//    public void increaseAge() {
//
//    }

    public void setMajor(String informationScience) {
        this.major = informationScience;
    }

    @Override
    public String toString(){
        return String.format("%s, %d, %s, %s, %s",getName(),getAge(),getAddress(),schoolName,major);
    }
}
