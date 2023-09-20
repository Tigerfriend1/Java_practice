import java.util.Arrays;
import java.util.Scanner;

public class RowColumnMain {
    public static void main(String[] args) {
        System.out.println("Enter two numbers: ");
        Scanner scanner = new Scanner(System.in);
        int N= scanner.nextInt();
        int M= scanner.nextInt();
        int[][] matrix = new int[N][M];
        int index = 1;
        for(int i=0; i<N; i++){
            for (int j=0;j<M;j++){
                if (j==M-1){
                    System.out.print(index);
                }
                else System.out.print(index+", ");
                matrix[i][j]=index;
                index++;
            }
            System.out.println("\n");

        }
        for (int k=0;k<matrix.length;k++){
            System.out.println(Arrays.toString(matrix[k]));
        }
        scanner.close();

    }
}