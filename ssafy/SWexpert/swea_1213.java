package swea;
/**
 * 1. indexOf(String str, int fromIndex)로 처음부터 해당 스트링을 찾는다.
 * 2. 있다면 cnt+1을 하고, fromIndex를 해당 문자열 다음으로 옮긴후 재실행한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_1213 {
    static BufferedReader br;

    static String str; //찾고자 하는 문자열
    static String strings; //찾을 문자열
    static int cnt; //총 문자열 개수
    static int size; //찾고자 하는 문자열의 길이
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc=1; tc<=10; tc++){
            br.readLine();
            str = br.readLine().trim();
            strings = br.readLine().trim();
            cnt = 0; //개수 초기화
            size = strings.length(); //strings의 길이
            find(0);
            System.out.println("#"+tc+" "+cnt);
        }
    }
    // 해당 str가 있는지 확인하는 메서드
    static void find(int index){
        while(index < size){ //string의 길이보다 작은 인덱스를 가질때
            int foundIndex = strings.indexOf(str, index); //index부터 찾고자하는 문자열str가 있는지 확인
            if(foundIndex != -1){ //문자열이 있을때
                cnt++; //1더하기
                index = foundIndex + 1; //해당 문자열 다음 문자열부터 다시 있는지 찾는다
            }else{ //없다면 탈출
                break;
            }
        }
    }
}
