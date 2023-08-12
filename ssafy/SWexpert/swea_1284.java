package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * swea_1284
 * 입력한 w에 대해 a사 방침과 b사 방침을 각각 적용하여 더 적은 요금을 선택
 */
public class swea_1284 {
    static BufferedReader br;
    static StringTokenizer st;

    static int comAp; //A사 리터당 요금
    static int comBq; //B사 리터이하 요금
    static int comBr; //B사 리터이하 기준
    static int comBs; //B사 초과 요금
    static int use; //사용한 물의 양
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine().trim());
        for(int tc=1; tc<=testCase; tc++){
            st = new StringTokenizer(br.readLine().trim());

            comAp = Integer.parseInt(st.nextToken());
            comBq = Integer.parseInt(st.nextToken());
            comBr= Integer.parseInt(st.nextToken());
            comBs = Integer.parseInt(st.nextToken());
            use = Integer.parseInt(st.nextToken());

            int answer = Math.min(companyA(comAp, use), companyB(comBq, comBr, comBs, use));

            System.out.println("#"+tc+" "+answer);
        }
    }

    private static int companyA(int comAp, int use){
        return use*comAp;
    }

    private static int companyB(int comBq, int comBr, int comBs, int use){
        if(use <= comBr) return comBq;
        else return comBq + comBs*(use-comBr);
    }
}
