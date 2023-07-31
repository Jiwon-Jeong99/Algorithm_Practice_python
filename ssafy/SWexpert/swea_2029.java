package swea;
/**
 * 몫 : Math.floorDiv(수, 나눌수)
 * 나머지 : Math.floorMod(수, 나눌수) -> % 와 차이점은 항상 양수가 나온다는 것. 나머지는 양수여야 하므로 이게 더 맞다.
 */

import java.util.Scanner;
public class swea_2029 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCase = scan.nextInt(); //테스트케이스 입력
        scan.nextLine(); //개행문자 날리기

        for(int tc=1; tc<=testCase; tc++){
            int num1 = scan.nextInt();
            int num2 = scan.nextInt();

            int mok = Math.floorDiv(num1, num2);
            int namo = Math.floorMod(num1, num2);

            System.out.println(String.format("#%d %d %d", tc, mok, namo));
        }
    }
}
