package SAMSUNG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  boj_16926 배열돌리기1
 *  1초 512mb
 *
 *  문제
 *  1. 이차원 배열을 반시계 방향으로 돌려보자.
 *  2. 겉 행끼리, 그 안행끼리
 *  3. 배열과 정수가 주어졌을 때, 배열을 r번 회전시킨 결과를 구하라.
 *
 *  input : 배열의 row, col, 회전수 totalRotate
 *  output : 주어진 배열을 totalRotate번 회전시킨 결과
 *
 *  문풀
 *  총 rotate의 사이클 (segment) 개수 : Math.min(col/2, row/2)
 *  (x, row-x), (y, col-y) 범위 내에 있는 것들이 같은 segment
 *  x,y 기준 오른쪽에 있는 값 nx,ny를 x,y에 대입
 *
 *  1. 이차원 배열에 배열 정보를 담는다.
 *  2. 반시계 방향으로 회전하는 segments의 수는 row와 col 중 더 작은 수 /2
 *  3. 회전 횟수만큼 회전시키기
 *  4. rotate 메서드에서는 segment 수 만큼 회전시키기
 *  5. segments의 수만큼 반복하면서 델타 배열을 사용하여 수를 집어넣는다.
 *  6. (0,0)과 같이 좌측 상단의 가장 첫번째 값은 temp 변수로 따로 저장하여 마지막 자리 인덱스에 넣어준다.
 */

public class BOJ_16926_배열돌리기1 {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;

    static int mapRow, mapCol, totalRotate; //배열의 가로, 세로, 회전수
    static int[][] map; //이차원 배열
    static int segment; //몇개의 segment가 있는지

    //우하좌상
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    static final int DELTA = 4;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine().trim());
        mapRow = Integer.parseInt(st.nextToken());
        mapCol = Integer.parseInt(st.nextToken());
        totalRotate = Integer.parseInt(st.nextToken());

        map = new int[mapRow][mapCol];

        //1. 이차원 배열에 배열 정보를 담는다.
        for(int rIdx=0; rIdx<mapRow; rIdx++){
            st = new StringTokenizer(br.readLine().trim());
            for(int cIdx=0; cIdx<mapCol; cIdx++){
                map[rIdx][cIdx] = Integer.parseInt(st.nextToken());
            }
        }

        //2. 반시계 방향으로 회전하는 segments의 수는 row와 col 중 더 작은 수 /2
        segment = Math.min(mapRow, mapCol) / 2;

        //3. 회전 횟수만큼 회전시키기
        for(int idx=0; idx<totalRotate; idx++){
            rotate();
        }

        //출력
        for(int rowIdx=0; rowIdx<mapRow; rowIdx++){
            sb = new StringBuilder();
            for(int colIdx=0; colIdx<mapCol; colIdx++){
                sb.append(map[rowIdx][colIdx]);
                sb.append(" ");
            }
            System.out.println(sb);
        }
    }

    public static void rotate() {

        //4. rotate 메서드에서는 segment 수 만큼 회전시키기
        for(int seg=0; seg<segment; seg++){
            //segment의 첫 시작 부분 (좌측 상단)
            int x = seg;
            int y = seg;

            //맨 시작부분, 즉 마지막에 넣을 부분 미리 temp에 저장해놓기
            int temp = map[x][y];

            int idx=0;

            //만약 계속 좌측으로 이동해야 할 상황이면 해당 방향으로 쭉 가야 하니까, for문 말고 while사용
            while(idx<DELTA){
                int nx = x + dx[idx];
                int ny = y + dy[idx];

                //범위 안이면
                if(nx<mapRow-seg && ny<mapCol-seg && nx>=seg && ny>=seg){
                    map[x][y] = map[nx][ny]; //현재 위치에 다음 위치의 값 넣기
                    x = nx;
                    y = ny;
                }else idx++;
            }

            //맨 처음 좌측상단 값을 좌측 하나 아래에다가 넣기
            map[seg+1][seg] = temp;
        }
    }
}
