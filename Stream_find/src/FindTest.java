import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindTest {

    public static void main(String[] args) {

        List<String> data = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {

            data.add(sc.next());

        }

        sc.close();

        System.out.println(data.stream().filter(p->p.contains("a")).findAny().isPresent());
        data.stream().filter(p->p.contains("a")).findAny().ifPresent(System.out::println); // your code here // ;

    }

}