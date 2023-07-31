package swea;
/**
 * Math.pow(숫자, 몇제곱) ->  제곱 표시함수(double형이기에 int로 바꿔주어야함)
 */

import java.util.Scanner;

public class swea_2019 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();
        for(int idx=0; idx< num; idx++){
            System.out.print((int)Math.pow(2, idx)+ " ");
        }
    }
}
