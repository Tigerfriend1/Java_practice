import java.util.Arrays;
import java.util.Scanner;

public class ArrayCopyMain {
    public static void main(String[] args) {
        //입력으로부터 배열을 생성하시오
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();
        int [] array = new int[num];
        for (int i=0; i<num; i++){
            int n = scanner.nextInt();
            array[i]=n;
        }
        int [] shallow = array; //shallow copy
        //shallow copy 수행 코드를 작성하시오
        modifyArray(shallow, 1);
        System.out.println("Shallow Copy: " + Arrays.toString(array));

        //deep copy 수행 코드를 작성하시오
        int [] deep = new int[array.length];
        System.arraycopy(array,0,deep,0,array.length);
        modifyArray(deep, 2);
        System.out.println("Deep Copy: " + Arrays.toString(array));
    }

    private static void modifyArray(int[] array, int index){
        array[index] = 15;
    }
}