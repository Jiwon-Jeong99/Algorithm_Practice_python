package study.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * boj_5052_전화번호목록
 * 1초 256mb
 *
 * 문제
 * 1. 한 번호가 다른 번호의 접두어인 경우가 없어야 한다.
 *
 * 문풀
 * startsWith
 */

public class BOJ_5052_전화번호목록 {
    static BufferedReader br;
    static int numberCnt;
    static List<String> list;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine().trim());

        //테스트케이스만큼 반복
        for(int tc=1; tc<=testCase; tc++){
            numberCnt = Integer.parseInt(br.readLine().trim());
            list = new ArrayList<>();

            //list에 넣기
            for(int idx=0; idx<numberCnt; idx++){
                String str = br.readLine().trim();
                list.add(str);
            }
            //리스트 정렬
            Collections.sort(list);

            testAccept(list);
        }
        br.close();
    }

    //일관성이 있는지 확인하는 메서드
    //오름차순으로 정리해서 접두어가 있다면 해당 전화번호 다음에 바로 있을거다.
    //다음 문자열만 확인하면 된다.
    //원래는 for문으로 돌렸는데 찾아보니 startWith 함수가 있어서 리팩함.
    static void testAccept(List<String> list){
        for(int idx=0; idx<numberCnt-1; idx++){
            if(list.get(idx+1).startsWith(list.get(idx))){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
