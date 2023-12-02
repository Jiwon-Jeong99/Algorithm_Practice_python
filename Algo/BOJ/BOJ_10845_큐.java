package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_10845_큐 {
    static BufferedReader br;
    static StringTokenizer st;

    static Deque<String> queue;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        queue = new ArrayDeque<>();

        int testCase = Integer.parseInt(br.readLine().trim());
        for(int tc=1; tc<=testCase; tc++){
            st = new StringTokenizer(br.readLine().trim());
            String what = st.nextToken();

            if(what.equals("push")) queue.offer(st.nextToken());
            else if(what.equals("pop") && !queue.isEmpty()) System.out.println(queue.poll());
            else if(what.equals("size")) System.out.println(queue.size());
            else if(what.equals("empty")) {
                if(queue.isEmpty()) System.out.println(1);
                else System.out.println(0);
            }
            else if(what.equals("front") && !queue.isEmpty()) System.out.println(queue.peek());
            else if(what.equals("back") && !queue.isEmpty()) System.out.println(queue.peekLast());
            else System.out.println(-1);
        }
    }
}
