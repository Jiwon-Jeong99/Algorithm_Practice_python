package swea;
/**
 * 등차수열의합 공식으로 접근한다.
 */

import java.util.Scanner;
public class swea_2025 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();
        int total = num*(num+1) / 2; //n(n+1)/2의 등차수열의합 공식으로 합을 알아낸다.
        System.out.println(total);
    }
}
