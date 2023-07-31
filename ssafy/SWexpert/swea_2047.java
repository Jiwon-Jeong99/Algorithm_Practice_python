package swea;
/**
 * 대소문자 변환
 * String클래스의 toUpperCase(), toLowerCase()
 * 대소문자 구분없이 문자열 비교 : equalsIgnoreCase()
 */

import java.util.Scanner;

public class swea_2047 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String words = scan.nextLine();
        words = words.toUpperCase();
        System.out.println(words);
    }
}
