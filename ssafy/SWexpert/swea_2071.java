package swea;
/**
 * 소수점 n번째 자리까지 반올림하기
 * Math.round(숫자) -> 반올림
 * Math.ceil(숫자) -> 올림
 * Math.floor(숫자) -> 내림
 *or
 * int sum
 * double avr = (double) sum /10
 * printf("%.0f", avr)
 */
import java.util.Scanner;
public class swea_2071 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCase = scan.nextInt();

        for(int tc=1; tc<=testCase; tc++){
            double sum = 0; //전체합을 구할 변수
            for(int idx=0; idx<10; idx++){
                int num = scan.nextInt();
                sum += num;
            }
            int average = (int) Math.round(sum/10); //double -> int로 형변환
            System.out.println(String.format("#%d %d", tc, average));
        }
    }
}
