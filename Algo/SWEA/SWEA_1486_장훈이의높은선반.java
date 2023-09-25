package 보충;
/**
 * swea_1486_장훈이의높은선반
 * => 부분집합
 *
 * 문제
 * 1. 선반 최소허들을 넘으면서 차가 최소가 되는 부분집합을 구하라!
 *
 * 문풀
 * 1. 점원들의 키를 배열로 입력받는다.
 * 2. 부분집합으로 최소허들 이상의 값들을 구한다.
 * 3. 최소허들을 넘은 값들 중 최소값을 구한다.
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1486_장훈이의높은선반 {
    static BufferedReader br;
    static StringTokenizer st;

    static int totalPeople; //총 직원수
    static int minimum; //최소허들
    static int[] heights; //직원들의 키 배열

    static int answer; //최소값

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        //테스트케이스
        int testCase = Integer.parseInt(br.readLine().trim());
        for(int tc=1; tc<=testCase; tc++){
            answer = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine().trim());

            totalPeople = Integer.parseInt(st.nextToken());
            minimum = Integer.parseInt(st.nextToken());

            heights = new int[totalPeople];
            st = new StringTokenizer(br.readLine().trim());

            for(int idx=0; idx<totalPeople; idx++){
                heights[idx] = Integer.parseInt(st.nextToken());
            }

            subset(0, 0);
            System.out.println("#"+tc+" "+answer);
        }
    }

    //부분집합
    //종료, 선택함, 선택안함
    public static void subset(int num, int sum) {

        if(sum >= minimum) {
            answer = Math.min(answer, sum - minimum);
            return;
        }

        if(num == totalPeople){ //기저조건
            int cha = sum - minimum; // 차이

            //의미없는 값, 최소허들을 넘지 못한 경우
            if(cha < 0){
                return;
            }
            answer = Math.min(answer, cha);
            return;
        }

        //선택
        subset(num+1, sum+heights[num]);
        //선택안함
        subset(num+1, sum);
    }
}
