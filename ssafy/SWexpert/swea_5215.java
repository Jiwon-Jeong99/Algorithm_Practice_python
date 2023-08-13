package swea;
/**
 * swea_5215 햄버거 다이어트
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_5215 {
    static BufferedReader br;
    static StringTokenizer st;

    static int total; //재료의 수
    static int limitCal; //제한 칼로리
    static int[][] burgers; //버거 정보 담은 배열
    static boolean[] visited;
    static int maxTaste;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine().trim()); //테스트케이스 입력
        for(int tc=1; tc<=testCase; tc++){
            st = new StringTokenizer(br.readLine().trim());
            total = Integer.parseInt(st.nextToken()); //재료의 수 입력
            limitCal = Integer.parseInt(st.nextToken()); //제한 칼로리 입력
            maxTaste = 0;
            visited = new boolean[total];
            burgers = new int[total][2];
            for(int num=0; num<total; num++){//버거 정보 담은 배열에 입력 추가
                st = new StringTokenizer(br.readLine().trim());
                burgers[num][0] = Integer.parseInt(st.nextToken());
                burgers[num][1] = Integer.parseInt(st.nextToken());
            }
            subset(0,0,0);
            System.out.println("#"+tc+" "+maxTaste);
        }
    }

    private static void subset(int depth, int sumTaste, int sumCal){
        if(sumCal > limitCal) return;
        if(depth == total) {//기저조건
            if(sumTaste > maxTaste){
                maxTaste = sumTaste;
            }
            return;
        }
        visited[depth] = true;
        subset(depth+1, sumTaste+burgers[depth][0], sumCal+burgers[depth][1]);
        visited[depth] = false;
        subset(depth+1, sumTaste, sumCal);
    }
}
