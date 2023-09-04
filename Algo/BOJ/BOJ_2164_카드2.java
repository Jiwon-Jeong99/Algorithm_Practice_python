package boj;
/**
 * boj_2164 카드2
 *
 * 문제
 * 1. 한장 남을때까지 반복
 * 2. 처음 카드 - 버리기
 * 3. 다음 카드 - 제일 아래로 옮기기
 *
 * 문풀
 * 1. 받은 수만큼 큐에 순서대로 넣기
 * 2. 큐의 첫번째 버리기
 * 3. 큐의 첫번째 맨 뒤에 옮기기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ_2164_카드2 {
    static BufferedReader br;
    static Queue<Integer> queue = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine().trim());

        //1. 받은 수만큼 큐에 순서대로 넣기
        for(int idx=1; idx<=num; idx++){
            queue.add(idx);
        }

        int index=1;
        while(queue.size() > 1){
            //홀수냐 짝수냐에 따라
            if((index & 1) == 1) { //2. 큐의 첫번째 버리기
                queue.poll();
            } else { //3. 큐의 첫번째 맨 뒤에 옮기기
                queue.add(queue.poll());
            }
            index++;
        }

        System.out.println(queue.poll());
    }
}
