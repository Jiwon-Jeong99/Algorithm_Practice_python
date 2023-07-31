package swea;

/**
 * max 변수와 입력받는 수를 비교해서 입력받는 수가 더 크면 max 변수에 저장
 */

import java.util.Scanner;
public class swea_2068 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCase = scan.nextInt();

        for(int tc=1; tc <= testCase; tc++){
            int max=0;
            for(int tmp=0; tmp<10; tmp++){
                int num = scan.nextInt();
                if(num > max) max = num;
            }
            System.out.println(String.format("#%d %d", tc, max));
        }
    }
}
