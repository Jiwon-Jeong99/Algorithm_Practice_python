package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_10866_덱 {
    static BufferedReader br;
    static StringTokenizer st;
    static Deque<String> deque;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        deque = new ArrayDeque<>();

        int testCase = Integer.parseInt(br.readLine().trim());
        for(int tc=1; tc<=testCase; tc++){
            st = new StringTokenizer(br.readLine().trim());

            String what = st.nextToken();

            if(what.equals("push_front")) deque.addFirst(st.nextToken());
            else if(what.equals("push_back")) deque.addLast(st.nextToken());
            else if(what.equals("pop_front") && !deque.isEmpty()) System.out.println(deque.poll());
            else if(what.equals("pop_back") && !deque.isEmpty()) System.out.println(deque.pollLast());
            else if(what.equals("size")) System.out.println(deque.size());
            else if(what.equals("empty")) {
                if(deque.isEmpty()) System.out.println(1);
                else System.out.println(0);
            }
            else if(what.equals("front") && !deque.isEmpty()) System.out.println(deque.peek());
            else if(what.equals("back") && !deque.isEmpty()) System.out.println(deque.peekLast());
            else System.out.println(-1);
        }
    }
}
