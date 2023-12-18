package study.Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * boj_1874_스택수열
 * 2초 128mb
 *
 * 문제
 * 1. 스택으로 넣었다 빼면서 주어진 수열을 만들 수 있는지 확인해라
 *
 * 문풀
 * 1. 가능하다면 StringBuilder로 답을 저장했다가 내놓기
 * 2. 불가능하다면 바로 System.out.println으로 NO 내놓기
 * 3.
 */

public class BOJ_1874_스택수열 {
    static BufferedReader br;
    static StringBuilder sb; //수열이 가능하다면 출력할 결과물
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        stack = new Stack<>();

        int testCase = Integer.parseInt(br.readLine().trim());

        int start = 0; //배열 추적할 변수

        for(int tc=0; tc<testCase; tc++){
            int num = Integer.parseInt(br.readLine().trim());

            if(num > start) {
                for(int idx = start+1; idx <= num; idx++){
                    stack.push(idx);
                    sb.append("+").append("\n");
                }
                start = num; //다음 push시, 오름차순을 유지하기 위한 업데이트
            }

            //stack의 top이랑 입력받은 값이 같지 않은 경우
            else if(stack.peek() != num){
                System.out.println("NO");
                System.exit(0);
            }

            stack.pop();
            sb.append("-").append("\n");
        }
        System.out.println(sb);
    }
}
