package study;

/**
 * 19416kb 348ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_10828_스택 {
    static BufferedReader br;
    static StringTokenizer st;
    static Stack<String> stack;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        stack = new Stack<>();

        int testCase = Integer.parseInt(br.readLine().trim());

        //테스트케이스만큼 반복
        for(int tc=0; tc<testCase; tc++){
            st = new StringTokenizer(br.readLine().trim());
            String what = "";

            //명령어 받기
            what = st.nextToken();

            //명령어에 따른 결과
            if(what.equals("push")) stack.push(st.nextToken());
            else if(what.equals("top") && !stack.isEmpty()) {
                System.out.println(stack.peek());
            }
            else if(what.equals("size")) System.out.println(stack.size());
            else if(what.equals("empty")){
                if(stack.isEmpty()) System.out.println("1");
                else System.out.println("0");
            }
            else if(what.equals("pop") && !stack.isEmpty()){
                System.out.println(stack.pop());
            }

            //스택이 비었다면
            else System.out.println("-1");

        }
    }
}
