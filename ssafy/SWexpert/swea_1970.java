package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1. money 금액단위를 담은 배열을 순회하면서 몫과 나머지금액을 반환한다.
 */
public class swea_1970 {
    static BufferedReader br;
    static StringBuilder sb;
    static int[] money = {50000,10000,5000,1000,500,100,50,10};
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine().trim());
        for(int tc=1; tc<=testCase; tc++){
            int totalMoney = Integer.parseInt(br.readLine().trim());
            sb.append("#").append(tc).append("\n");
            for(int idx=0; idx<money.length; idx++){
                int mok = totalMoney / money[idx];
                totalMoney %= money[idx];
                sb.append(mok).append(" ");
            }
            sb.append("\n");

        }
        System.out.print(sb);
    }
}
