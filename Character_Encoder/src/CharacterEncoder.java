import java.util.Scanner;

public class CharacterEncoder {
    public static void main(String[] args) {

//        System.out.println((int)'a');
//        System.out.println((int)'z');
//        System.out.println((int)'A');
//        System.out.println((int)'Z');
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        int num = scanner.nextInt();
        num= num%26;
        char[] chars = string.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for(char c : chars){
            if (Character.isLowerCase(c)){
                stringBuilder.append((char)((c+num)%122));
            }
            else if(Character.isUpperCase(c)){
                stringBuilder.append((char)((c+num)%90));
            }else{ System.out.println("The string contains characters that cannot be encoded."); return;}

        }
        System.out.printf("Encoded string: %s", stringBuilder);

    }
}