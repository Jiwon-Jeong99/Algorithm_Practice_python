package swea;

import java.util.Scanner;
public class swea_2072 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCase = scan.nextInt();
        scan.nextLine();

        // 테스트케이스 수만큼 반복하기
        for(int tc=1; tc <= testCase; tc++){
            int sum = 0; //홀수를 더할 변수
            for(int idx=0; idx<10; idx++){ //10개의 변수를 순회하는 반복문
                int num = scan.nextInt();
                if(num % 2 != 0) sum += num; //홀수일 경우 sum에 추가
            }
            System.out.println(String.format("#%d %d", tc, sum));
            sum = 0; //sum초기화
        }
        scan.close();
    }
}
