package swea;
/**
 * sweea_1228 암호문1
 *=> 루프를 돌면서 스택 수정하면 예상치 못한 동작을 할 수 있음
 *
 * 문제
 * 1. 왼쪽 - 오른쪽 차례로 탑 세우기
 * 2. 왼쪽 방향으로 레이저 발사
 * 3. 레이저는 발사한 탑의 높이보다 같거나 크면 수신가능하다.
 * 4. 각 탑에서 발사한 레이저를 몇번째 탑이 수신하는지 적어라
 * 5. 수신하는 탑이 없다면 0
 *
 * 문풀
 * 1. stack에 탑의 개수만큼 탑의 높이를 넣는다.
 * 2. 만약 스택의 peek >= 이제 넣는 탑의 높이 => answer.push(peek()의 높이)
 *      peek < 이제 넣는 탑의 높이 => stack.pop()
 *      stack.isEmpty() =>answer.push(0)
 * 3. answer 스택 거꾸로 출력
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493_탑 {
    static BufferedReader br;
    static StringTokenizer st;

    static int towerTotal;
    static Stack<Tower> stack; //탑의 높이 넣을 스택
    static Stack<Integer> answer; //정답 스택

    static class Tower {
        int index;
        int height;

        public Tower(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        stack = new Stack<>();
        answer = new Stack<>();

        towerTotal = Integer.parseInt(br.readLine().trim());

        st = new StringTokenizer(br.readLine().trim());

        //1. stack에 탑의 개수만큼 탑의 높이를 넣는다.
        //2. 만약 스택의 peek >= 이제 넣는 탑의 높이 => answer.push(peek()의 높이)
        // peek < 이제 넣는 탑의 높이 => stack.pop()
        // stack.isEmpty() =>answer.push(0)
        for(int idx=1; idx<=towerTotal; idx++){
            int currentHeight = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty()){
                Tower top = stack.peek();
                if(top.height >= currentHeight){
                    answer.push(top.index);
                    stack.push(new Tower(idx, currentHeight));
                    break;
                }
                stack.pop();
            }
            if(stack.isEmpty()) {
                answer.push(0);
            }
            stack.push(new Tower(idx, currentHeight));
        }


        //3. answer 스택 거꾸로 출력
        int[] ans = new int[towerTotal];
        for(int index=towerTotal-1; index>=0; index--) {
            ans[index] = answer.pop();
        }

        for(int ansIdx=0; ansIdx<towerTotal; ansIdx++){
            System.out.print(ans[ansIdx]+" ");
        }
    }
}
