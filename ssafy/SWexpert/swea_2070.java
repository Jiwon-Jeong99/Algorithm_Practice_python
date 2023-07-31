package swea;

import java.util.Scanner;
public class swea_2070 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCase = scan.nextInt();

        for(int tc=1; tc<=testCase; tc++){
            int num1 = scan.nextInt();
            int num2 = scan.nextInt();
            // 두 변수의 크기 비교에 따른 부등호 출력
            if(num1 == num2) System.out.println(String.format("#%d =", tc));
            else if(num1 > num2) System.out.println(String.format("#%d >", tc));
            else if(num1 < num2) System.out.println(String.format("#%d <", tc));
        }
        scan.close();
    }
}
