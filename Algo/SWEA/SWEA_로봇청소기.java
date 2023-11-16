package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * swea_로봇청소기
 *
 * 1. 1번 -> 2번 번호 순서대로 청소
 * 2. (1,1) 좌측 상단, 오른쪽 방향 바라보고 있다.
 * 3. 직진 or 시계방향 90도 회전
 * 4. 한자리에서 1번만 회전, 먼지를 청소함과 동시에 회전 가능
 *
 *  회전
 * - 현재 바라보는 방향에서 앞에 먼지가 있을 경우
 *      -> 오른쪽 +1, 왼쪽 +3
 * - 현재 바라보는 방향에서 뒤에 먼지가 있을 경우
 *      -> 오른쪽 +2, 왼쪽 +3
 */

public class SWEA_로봇청소기 {
    static BufferedReader br;
    static StringTokenizer st;

    static int mapSize;
    static int minRotate; //최소 회전횟수
    static int[] cur; //현재 청소기의 행, 열, 방향 저장
    static int[][] dustPos; //먼지 순서, 먼지 위치
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine().trim());
        for(int tc=1; tc<=testCase; tc++) {
            mapSize = Integer.parseInt(br.readLine().trim());
            dustPos = new int[11][2];
            cur = new int[]{0, 0, 0};
            //로봇 청소기 방향 : 우-0, 하-1, 좌-2, 상-3(시계방향)
            minRotate = 0;
            int input, dust = 0;

            for (int rowIdx = 0; rowIdx < mapSize; rowIdx++) {
                st = new StringTokenizer(br.readLine().trim());

                for (int colIdx = 0; colIdx < mapSize; colIdx++) {
                    input = Integer.parseInt(st.nextToken());
                    if (input != 0) {
                        //먼지 위치 저장
                        dustPos[input][0] = rowIdx;
                        dustPos[input][1] = colIdx;
                        dust++; //먼지 개수
                    }
                }
            }
            for(int dustNum = 1; dustNum <= dust; dustNum++) {
                getDust(dustNum);
            }
            System.out.println("#"+tc+" "+minRotate);
        }
    }

    static void getDust(int dustNum) {
        //청소기와 먼지의 위치의 차이 구하기
        int row = dustPos[dustNum][0] - cur[0];
        int col = dustPos[dustNum][1] - cur[1];
        int dir;

        //위치에 따라 청소기 얼마나 회전할지
        //행, 열, 방향
        if(cur[2] == 0) { //청소기 우쪽
            if(row>0){
                if(col>0)
                    dir = 1; //먼지가 청소기 오른쪽 앞에 위치
                else
                    dir = 2; //먼지가 청소기 오른쪽 뒤에 위치
            }else
                dir = 3; //먼지가 청소기 왼쪽 앞 or 뒤에 위치
        }else if(cur[2] == 1){ //청소기 하쪽 바라보고 있을때
            if(col<0){
                if(row>0)
                    dir = 1; //오른쪽 앞
                else
                    dir = 2; //오른쪽 뒤
            } else
                dir = 3; //왼쪽 앞이나 뒤
        }else if(cur[2] == 2){ //청소기 왼쪽 바라보고 있을때
            if(row<0){
                if(col<0)
                    dir=1; //오른쪽 앞
                else
                    dir=2; //오른쪽 뒤
            }else
                dir=3; //왼쪽 앞이나 뒤
        }else { //청소기가 상쪽 바라보고 있을때
            if(col>0){
                if(row<0)
                    dir=1; //오른쪽 앞
                else
                    dir=2; //오른쪽 뒤
            }else
                dir=3; //왼쪽 앞이나 뒤
        }
        //청소기의 위치와 방향 업데이트(치운 먼지가 있는 곳으로)
        cur[0] = dustPos[dustNum][0];
        cur[1] = dustPos[dustNum][1];
        cur[2] += dir; // 몇번 회전

        //한 바퀴 돌면 다시 방향 잡기
        if (cur[2] > 3)
            cur[2] -= 4;
        minRotate += dir;
    }
}
