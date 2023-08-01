package exercise;

import java.util.Scanner;
/**
*앞에 네자리, 2자리, 2자리씩 잘라서
*올바른 날짜 영역인지 확인한 후에
*올바르다면, / 문자 추가, 올바르지 않다면, -1 출력
*/
public class swea_2056 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCase = Integer.parseInt(scan.nextLine());
        int[] monthDate = {31,28,31,30,31,30,31,31,30,31,30,31}; //유효달 확인할 수 있는 배열
        
    for(int tc=1; tc<=testCase; tc++){
        String date = scan.nextLine();
        StringBuilder sb = new StringBuilder(date);
        
        // 문자열 연월일에 맞춰 자르기
        int month = Integer.parseInt(sb.substring(4,6));
        int day = Integer.parseInt(sb.substring(6));
        
        // 월이 1~12 범위 안에 있을 때만
        if(month>0 && month<13) {
        	// 해당 월에 유효범위 안에 있는 일일때만
        	if(monthDate[month-1] >= day && day > 0) {
        		String ymd = sb.substring(0,4) + "/" + sb.substring(4,6) + "/" + sb.substring(6);
        		System.out.println(String.format("#%d %s", tc, ymd ));
        	} else {
        		System.out.println(String.format("#%d %s", tc, -1));
        	}
        	
        }else {
        	System.out.println(String.format("#%d %s", tc, -1));
        }
    }
    scan.close();

    }
}
