package swea;

/**
 * 1. 자연수를 입력받고
 * 2. 10을 나눈 자릿수를 더해간다.
 */
import java.util.Scanner;
public class swea_2058 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int sum = 0; //각자릿수를 더할 변수
        while(num>0){
            sum += num%10;
            num /= 10; //int라 소수점은 자동으로 없어짐
        }
        System.out.println(sum);
    }
}
