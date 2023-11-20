public class Person implements MyMovable{
    private String vehicle;
    public Person(String vehicle) {
        this.vehicle=vehicle;
    }

    //나는 subway로 출근한다.
    @Override
    public String moveBy() {
        return String.format("나는 %s로 출근한다.",vehicle);
    }
}
