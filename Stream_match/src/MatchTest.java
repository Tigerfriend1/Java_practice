import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatchTest {

    public static void main(String[] args) {

        List<Integer> data = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {

            data.add(sc.nextInt());

        }

        sc.close();

        System.out.println(data.stream().anyMatch(p->p<10));
        System.out.println(data.stream().allMatch((p->p<10)));
        System.out.println(data.stream().noneMatch(p->p<10));

    }

}