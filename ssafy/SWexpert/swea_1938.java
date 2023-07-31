package swea;
import java.util.Scanner;
public class swea_1938 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num1 = scan.nextInt();
        int num2 = scan.nextInt();

        System.out.println(num1 + num2);
        System.out.println(num1 - num2);
        System.out.println(num1 * num2);
        System.out.println(num1 / num2); // int형식이기 때문에 소수점 이하의 숫자는 버려진다.
    }
}
