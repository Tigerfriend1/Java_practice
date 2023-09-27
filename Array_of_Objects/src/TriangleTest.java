import java.util.Scanner;

class Triangle {
    //Your code here (멤버 변수로 밑변과 높이를 정의)
    //Your code here (생성자, getArea(), toString() 메서드 정의)
    private final int base;
    private final int height;

    Triangle(int base, int height){
        this.base=base;
        this.height=height;
    }
    public double getArea(){
        return base*height*0.5;
    }

}
public class TriangleTest {
    public static void main(String[] args) {
        //Your code here (표준 입력을 받아 N개의 삼각형을 생성하고, 밑변, 높이, 넓이를 출력하시오)
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        Triangle[] triangles = new Triangle[N];
        for (int i=0;i<N;i++){
            int base = scanner.nextInt();
            int height = scanner.nextInt();
            triangles[i]=new Triangle(base,height);
            System.out.printf("Triangle [base=%d, height=%d, area=%.2f]\n",base,height,triangles[i].getArea());
        }

    }
}