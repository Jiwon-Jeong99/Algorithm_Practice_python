package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * boj_1106_호텔
 * 2초 128mb
 *
 * 문제
 * 1. input : 도시개수, 홍보비용, 증가고객수
 * 2. 정수배만큼 투자 가능 (소수는 안됨)
 * 3. C명 이상을 늘이기 위해 투자해야 하는 돈의 최솟값
 *
 * 문풀
 * 1. DP 중에서도 Bottom-up 방식의 최대/최소의 경우의 수를 구하는 문제
 * 2. 부분문제를 통해 더 큰 문제를 해결하는 DP
 * 3. 계산 재활용
 *
 * c명을 모집하는게 아니라 c명 이상을 모집해도 최소 비용이면 상관없기 떄문에 dp[c+1]이 아닌 dp[c+101] 선언
 *
 */

public class BOJ_1106_호텔 {
    static BufferedReader br;
    static StringTokenizer st;

    static int goal, cities;
    static int[] value;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine().trim());
        goal = Integer.parseInt(st.nextToken()); //목표고객수
        cities = Integer.parseInt(st.nextToken()); //도시수

        value = new int[goal+101]; //한번에 늘릴 수 있는 고객수가 100명을 넘지 않으니, 달성고객 + 최대 도시고객
        Arrays.fill(value, Integer.MAX_VALUE);
        value[0] = 0;

        //도시개수만큼 반복
        for(int idx=0; idx<cities; idx++){
            st = new StringTokenizer(br.readLine().trim());

            int cost = Integer.parseInt(st.nextToken());
            int people = Integer.parseInt(st.nextToken());
            for(int index=people; index<goal+101; index++) {
                int prev = value[index - people];
                if (prev != Integer.MAX_VALUE) {
                    value[index] = Math.min(value[index], cost + prev);
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for(int i=goal; i<goal+101; i++){
            answer = Math.min(answer, value[i]);
        }
        System.out.println(answer);
    }
}
