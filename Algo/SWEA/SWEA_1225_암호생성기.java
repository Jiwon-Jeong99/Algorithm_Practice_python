package swea;
/**
 * swea_1225 암호생성기
 *
 * 문제
 * 1. n개의 수 처리 -> 암호 생성
 *      -> 8개의 숫자 입력
 *      -> 첫 번째 숫자 1 감소 뒤, 맨 뒤로 보냄
 *      -> 다음 수는 2 감소한 뒤, 맨뒤로
 *      -> 5까지 감소하고 맨뒤로
 *      ->다시 1부터 감소
 * 2. 0보다 작아지는 경우 0으로 유지, 프로그램 종료
 *
 * 문풀
 * 1. queue에 8개의 숫자를 집어넣는다.
 * 2. 0이하의 수가 나올때까지 1~5를 돌면서 수를 빼주고 큐 맨 뒤로 넣는다.
 * 3. 0 이하의 수가 나오면 break
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1225_암호생성기 {
    static BufferedReader br;
    static StringTokenizer st;
    static Queue<Integer> queue;
    static boolean isDone;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        //테스트케이스 10번 반복
        for(int tc=1; tc<=10; tc++){
            br.readLine().trim();

            st = new StringTokenizer(br.readLine().trim());

            //테스트케이스별 큐 초기화
            queue = new ArrayDeque<>();

            isDone = false;

            //큐에 8개의 숫자 집어넣기
            for(int idx=0; idx<8; idx++){
                queue.offer(Integer.parseInt(st.nextToken()));
            }

            while(true){

                //1~5까지 숫자 빼주고 큐 맨뒤에 넣기
                for(int index=1; index<=5; index++){
                    int num = queue.poll();
                    num -= index;

                    //0이하의 수가 나오면 isDone true로 해주고 탈출
                    if(num <= 0) {
                        num = 0;
                        queue.offer(num);
                        isDone = true;
                        break;
                    }

                    queue.offer(num);
                }
                if(isDone) break;
            }

            System.out.print("#"+tc+" ");
            for(int idx=0; idx<8; idx++){
                System.out.print(queue.poll()+" ");
            }
            System.out.println();
        }
    }
}
