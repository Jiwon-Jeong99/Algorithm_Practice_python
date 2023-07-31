package swea;
/**
 * 1. 두수의 차이 +1을 해준다.
 */

import java.util.Scanner;
public class swea_2043 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int password = scan.nextInt();
        int current = scan.nextInt();
        System.out.println(password-current+1);
    }
}
