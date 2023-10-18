package boj;

/**
 * boj_1697 숨바꼭질
 * 2초 128mb
 *
 * 문제
 * 1. 수빈이는 점 n, 동생은 점 k
 * 2. 수빈이는 걷거나 순간이동을 할 수 있다.
 * 3. 수빈이의 위치 x일때 -> 걷는다면 1초 후 x+1 or x-1로 이동
 *                    -> 순간이동 1초 후 2*x의 위치로 이동
 *
 * output : 수빈이가 동생을 찾는 가장 빠른 시간
 *
 * 문풀
 * 1. bfs로 3가지 방향으로 서치
 * 2. 만약 종점에 도착하면 출력하기
 * 3. 도착하지 않으면, 배열에 +1씩 넣어주기
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697_숨바꼭질 {
    static BufferedReader br;
    static StringTokenizer st;

    static int current, arrive; //현재 지점, 도착 지점
    static int[] check = new int[100001];

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine().trim());

        current = Integer.parseInt(st.nextToken());
        arrive = Integer.parseInt(st.nextToken());

        //시작할때부터 같은 위치면
        if(current == arrive) System.out.println(0);
        else bfs(current);
    }

    //bfs
    static void bfs(int num) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(num);
        check[num] = 1;

        while(!queue.isEmpty()){
            int pos  = queue.poll();
            System.out.println(pos);

            for(int idx=0; idx<3; idx++){
                int next;
                if(idx==0) next = pos + 1;
                else if(idx==1) next = pos - 1;
                else next = pos*2;

                if(next == arrive){
                    System.out.println(check[pos]);
                    return;
                }

                if(next >= 0 && next < check.length && check[next] == 0) {
                    queue.add(next);
                    check[next] = check[pos] + 1; //최단경로
                    System.out.println();
                }
            }


        }
    }

    static class Pos {
        int n, cnt;
        Pos(int n, int cnt){
            this.n = n;
            this.cnt = cnt;
        }
    }
}
