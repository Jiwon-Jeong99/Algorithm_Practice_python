package boj;
/**
 * boj_11286 절댓값힙
 *
 * 문제
 * 1. 배열에는 정수만
 * 2. 배열에서 절댓값이 가장 작은 값을 출력, 그 값을 배열에서 제거
 * 3. 절댓값이 가장 작은 값이 여러개일 때, 가장 작은 수 출력, 그 값 배열에서 제거
 * 4. 처음에는 비어있는 배열에서 시작
 * - 0이 아니라면) 값을 추가
 * - 0이라면) 절댓값이 가장 작은 값 출력 -> 그 값을 배열에서 제거
 * - 배열이 비어 있는데 절댓값이 가장 작은 값 출력하라고 한 경우 : 0 출력
 *
 * 문풀
 * 1. 우선순위큐에 절댓값의 오름차순으로 넣는다.
 * 2. 단, 절댓값이 같을 시, 수를 비교해서 작은 수가 앞으로 오도록
 * 3. comparator를 활용해서 정렬한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_11286_절댓값힙 {
    static BufferedReader br;

    static int num; //입력받는 정수
    static PriorityQueue<Integer> pq;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        //우선순위 큐 구현
        //new Comparator<Integer>는 람다로 대체될 수 있다. -> (o1, o2)
        //
        pq = new PriorityQueue<>((o1, o2) -> {
            int par1 = Math.abs(o1);
            int par2 = Math.abs(o2);
            if(par1>par2) return par1-par2;

            //기본 오름차순
            //return 값으로 양수 : 순서 바꾸겠다.
            //            음수 : 순서 바꾸지 않겠다.
            else if(par1==par2){
                if(o1 > o2) return 1;
                else return -1;
            }
            else return -1;
        });

        int testCase = Integer.parseInt(br.readLine().trim());
        for(int tc=1; tc<=testCase; tc++){
            num = Integer.parseInt(br.readLine().trim());
            if(num != 0){
                pq.offer(num);
//                System.out.println("힙안에는" + pq.peek());
            }else{
                if(!pq.isEmpty()){
                    System.out.println(pq.poll());
//                    System.out.println("힙안에는" + pq.peek());
                }
                else System.out.println(0);
            }
        }
    }
}
