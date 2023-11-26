import java.util.*;
import java.util.stream.Collectors;

public class FilterCountDistinctTest {

    public static void main(String[] args) {

        List<Integer> data = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {

            data.add(sc.nextInt());

        }

        sc.close();

        System.out.println(data.stream().filter(p->10>p).toList());
        System.out.println(data.stream().filter(p->10>p).count());
        System.out.println(data.stream().filter(p->10>p).distinct().toList());
        System.out.println(data.stream().filter(p->10<=p).toList());
        System.out.println(data.stream().filter(p->10<=p).count());
        System.out.println(data.stream().filter(p->10<=p).distinct().toList());

    }

}