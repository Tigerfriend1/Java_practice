import java.util.*;

public class BinaryMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int ini = scanner.nextInt();
        int buf[] = new int[33];
        int binary[] = new int[]{0,1};
        int charPos = 32;
        int init=-ini;

        while(init<=-2){
            buf[charPos--]=binary[-(init%2)];
            init=init/2;
        }
        buf[charPos] = binary[-init];
        //System.out.println(buf);

        int[] l = Arrays.copyOfRange(buf,charPos,33);


        String a ="";
        for (int i : l){
            String k = Integer.toString(i);
            a+=k;
        }
        System.out.printf("Number %d in Binary Number: %s",ini,a);





    }
}