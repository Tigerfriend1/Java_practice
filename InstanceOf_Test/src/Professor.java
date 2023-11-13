public class Professor extends Person {

    String schoolName;
    String major;
    public Professor(String name, int age, String address, String schoolName, String major) {
        super(name,age,address);
        this.schoolName = schoolName;
        this.major = major;
    }
    public String getSchoolName() {
        return schoolName;
    }

    public String getMajor() {
        return major;
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
    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Professor)){
            return false;
        }
        Professor p = (Professor) obj;
        return getName().equals(p.getName())&&getAge()== p.getAge()&&getAddress().equals(p.getAddress()) && getSchoolName().equals(p.getSchoolName()) && getMajor().equals(p.getMajor());
    }


}
