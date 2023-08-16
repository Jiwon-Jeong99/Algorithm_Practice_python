package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author 정지원
 *
 */
public class swea_9317 {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine().trim());
        for(int tc=1; tc<=testCase; tc++){
            int size = Integer.parseInt(br.readLine().trim());
            String[] correct = br.readLine().trim().split("");
            String[] wrong = br.readLine().trim().split("");
            int cnt = 0;
            for(int idx=0; idx<size; idx++){
                if(correct[idx].equals(wrong[idx])) cnt++;
            }
            System.out.println("#"+tc+" "+cnt);
        }
    }
}