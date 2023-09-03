package boj;
/**
 * boj_2961 도영이가만든맛있는음식
 * 1. 신맛-곱/쓴맛-합
 * 2. 신맛과 쓴맛의 차이를 작게
 * 3. 재료는 적어도 하나 사용
 *
 * 문풀
 * 1. 재료의 각각의 맛을 이차원배열로 받는다.
 * 2. 부분집합을 이용해 각각의 재료를 선택해 최소의 값을 찾는다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2961_도영이가만든맛있는음식 {
    static BufferedReader br;
    static StringTokenizer st;

    static int foodTotal; //재료개수
    static int[][] taste; //재료별 신맛 쓴맛
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        foodTotal = Integer.parseInt(br.readLine().trim());

        taste = new int[foodTotal][2];
        visited = new boolean[foodTotal];

        //맛 이차원배열로 받기
        for(int tc=0; tc<foodTotal; tc++){
            st = new StringTokenizer(br.readLine().trim());

            taste[tc][0] = Integer.parseInt(st.nextToken());
            taste[tc][1] = Integer.parseInt(st.nextToken());
        }
        select(0);
        System.out.println(min);
    }

    //부분집합
    static void select(int depth) {
        int sour = 1; //곱할거니까 세팅 1
        int bitter = 0;

        if(depth == foodTotal){
            for(int idx=0; idx<foodTotal; idx++){
                if(visited[idx]){
                    sour *= taste[idx][0];
                    bitter += taste[idx][1];
                }
            }

            //재료는 적어도 하나를 선택해야 함
            if(sour != 1 && bitter !=0) {
                min = Math.min(min, Math.abs(sour - bitter));
            }
            return;
        }

        visited[depth] = true; //방문체크
        select(depth+1); //부분집합에 포함
        visited[depth] = false; //방문해제
        select(depth+1); //현재 숫자 부분집합에 포함x
    }
}
