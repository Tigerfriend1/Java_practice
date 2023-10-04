import java.util.Scanner;
import java.util.Objects;

public class Employee {
    private String name;
    private Double salary;

    public Employee(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return  name +" "+ salary ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        //Employee employee = (Employee) o;
        //return Objects.equals(name, employee.name) && Objects.equals(salary, employee.salary);
        Employee other = (Employee) o; //Object인 o를 Employee로 형변환(비교하기 위함)
        return name.equals(other.name) && salary.equals(other.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary);
    }
}
