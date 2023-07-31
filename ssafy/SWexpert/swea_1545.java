package swea;
/**
 * for문을 돌면서 입력받은 수부터 0이 될때까지 출력한다.
 */

import java.util.Scanner;

public class swea_1545 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();
        for(int idx=num; idx>=0; idx--){
            System.out.print(idx + " ");
        }
    }
}
