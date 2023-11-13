public class Person {
    private String name ;
    private int age ;
    private String address ;
    public Person(String name, int age, String address) {
        this.name = name ; this.age = age ; this.address = address ;
    }
    public String getName() { return name ; }
    public void rename(String name) { this.name = name ; }
    public int getAge() { return age ; }
    public void increaseAge() { age ++ ; }
    public String getAddress() { return address ; }
    public void moveTo(String address) { this.address = address ; }
    @Override
    public String toString() {
        return String.format("%s, %d, %s", name, age, address) ;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Person)){
            return false;
        }
        Person p = (Person) obj;
        return name.equals(p.getName())&&age== p.getAge()&&address.equals(p.getAddress());
    }

// override hashCode() and equals()
}