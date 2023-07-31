package swea;
/**
 * charAt(인덱스) : String으로 저장된 문자열 중에서 한 글자만 선택해서 char타입으로 변환
 * 1. A는 아스키코드 65니까 1로 만들기 위해 64를 빼준다.
 */

import java.util.Scanner;
public class swea_2050 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String alphas = scan.nextLine();

        for(int idx=0; idx<alphas.length(); idx++){
            System.out.print((alphas.charAt(idx)-64) + " ");
        }
    }
}
