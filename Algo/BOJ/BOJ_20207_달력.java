package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * boj_달력
 * 1초 512mb
 *
 * 어차피 일정이 얼마나 연속되어 있는지, 겹치는 일정이 몇개인지에 따라 ㄴ면적이 결정됨.
 * 각 요일별로 몇개의 일정이 겹쳐져 있는지 알면됨.
 */

public class BOJ_20207_달력 {
    static BufferedReader br;
    static StringTokenizer st;

    static final int DAYS = 365;
    static int[] day;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int plans = Integer.parseInt(br.readLine().trim());

        day = new int[DAYS+1];

        //일정의 개수만큼 반복
        for(int plan=0; plan<plans; plan++){
            st = new StringTokenizer(br.readLine().trim());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            //일정이 있는 곳 다 카운트
            for(int idx=start; idx<=end; idx++){
                day[idx]++;
            }
        }

        int sum = 0;
        int height = 0;
        int width = 0;
        for(int i=0; i<=DAYS; i++){
            if(day[i] == 0){ //만약 일정이 없는 날을 만나면
                sum += height * width;
                //초기화
                height=0;
                width=0;
                continue;
            }
            width++;
            height = Math.max(height, day[i]); //최대 높이 갱신
        }
        //마지막으로 있는 일정들
        sum += height * width;
        System.out.println(sum);
    }
}
