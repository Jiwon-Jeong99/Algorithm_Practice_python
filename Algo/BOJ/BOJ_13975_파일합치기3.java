package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * boj_파일합치기3
 *
 * 오답
 * 1. 우선순위 큐 생각은 했는데 기억이 안났음
 * 2. 무심결에 계속 int를 썼는데 범위 초과해서 -> Long 써줘야함
 * 3. 파일 크기가 작은 것부터 우선순위를 높게 설정
 * 4. 파일을 더해가면서 합친 파일 크기를 우선순위큐에 다시 넣어주면서 파일 합치는 과정 반복
 */

public class BOJ_13975_파일합치기3 {
    static BufferedReader br;
    static StringTokenizer st;

    static long answer;
    static PriorityQueue<Long> pq;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine().trim());
        for(int tc=1; tc<=testCase; tc++){
            int total = Integer.parseInt(br.readLine().trim());
            pq = new PriorityQueue<>();
            answer = 0;
            st = new StringTokenizer(br.readLine().trim());

            //우선순위큐에 넣기
            for(int idx=0; idx<total; idx++){
                pq.offer(Long.parseLong(st.nextToken()));
            }

            while(pq.size() > 1) {
                long file1 = pq.poll();
                long file2 = pq.poll();
                long sum = file1+file2;
                pq.offer(sum);
                answer += sum;
            }
            System.out.println(answer);
        }
    }
}
