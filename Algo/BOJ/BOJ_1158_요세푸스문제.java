package boj;
/**
 * boj_1158 요세푸스문제
 *
 * 문제
 * 1. n명이 원을 이루면서 앉아있다.
 * 2. 순서대로 k번째 사람을 제거
 * 3. 사람이 다 제거될때까지 반복
 * 4. 제거된 순서 반환
 *
 * 문풀
 * 1. 큐에 주어진 숫자만큼을 차례대로 넣는다.
 * 2. 주어진 순서에 맞는 수는 반환하고 나머지 수는 큐의 맨 뒤에 넣는다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1158_요세푸스문제 {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;

    static Queue<Integer> queue;
    static int peopleTotal;
    static int remove;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        queue = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine().trim());

        peopleTotal = Integer.parseInt(st.nextToken());
        remove = Integer.parseInt(st.nextToken());

        //1. 큐에 주어진 숫자만큼을 차례대로 넣는다.
        for(int idx=1; idx<=peopleTotal; idx++){
            queue.offer(idx);
        }

        int index=1;
        sb.append("<");

        //2. 주어진 순서에 맞는 수는 반환하고 나머지 수는 큐의 맨 뒤에 넣는다.
        while(!queue.isEmpty()) {
            if(index == remove){

                //마지막 수는 , 없이 출력
                if(queue.size() ==1){
                    sb.append(queue.poll());
                    break;
                }
                sb.append(queue.poll()+", ");
                index = 1;
            }else{
                int num = queue.poll();
                queue.offer(num);
                index++;
            }
        }
        sb.append(">");
        System.out.println(sb);
    }
}
