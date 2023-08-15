package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 맨 왼쪽 ) 오른쪽만 2칸이상 조망이 되면 됨
 * 2. 맨 오른쪽 ) 왼쪽만 2칸이상 조망이 되면 됨
 * 3) 중간 나머지) 왼, 오 2칸 이상 조망이 되면 됨
 *
 */
public class swea_1206 {
    static BufferedReader br;
    static StringTokenizer st;

    static int size; //건물 개수
    static int[] buildings; //건물이 담긴 배열
    static int cnt; //조망권이 확보된 세대수
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        for(int tc=1; tc<=10; tc++){
            cnt = 0;
            size = Integer.parseInt(br.readLine().trim()); //건물개수
            st = new StringTokenizer(br.readLine().trim());
            buildings = new int[size];
            for(int idx=0; idx<size; idx++){ //건물 배열에 담기
                buildings[idx] = Integer.parseInt(st.nextToken());
            }

            for(int num=3; num<size-3; num++){
                if(buildings[num] >= buildings[num-1] && buildings[num] >= buildings[num-2] && buildings[num] >= buildings[num+1] && buildings[num] >= buildings[num+2]){
                    int leftMax = Math.max(buildings[num-1], buildings[num-2]);
                    int rightMax = Math.max(buildings[num+1], buildings[num+2]);
                    int max = Math.max(leftMax, rightMax);
                    cnt += buildings[num] - max;
                }
            }
            if(buildings[2] >= buildings[3] && buildings[2] >= buildings[4]) cnt += buildings[2] - Math.max(buildings[3], buildings[4]);
            if(buildings[size-3] >= buildings[size-4] && buildings[size-3] >= buildings[size-5]) cnt += buildings[size-3] - Math.max(buildings[size-4], buildings[size-5]);

            System.out.println("#"+tc+" "+cnt);
        }
    }
}
