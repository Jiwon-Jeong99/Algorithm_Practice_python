package SAMSUNG;

/**
 * boj_20057 마법사상어와토네이도
 * 1초 512mb
 *
 * 문제
 * 인덱스는 1부터 시작
 * n은 홀수
 *
 * 1. 토네이도는 격자 가운데부터 시작
 * 2. 반시계 방향으로 이동
 * 3. 토네이도는 한 번에 한 칸 이동
 * 4. 비율 계산에서 소수점 아래는 버린다.
 * 5. a로 이동하는 모래의 양은 비율이 적혀있는 칸으로 이동하지 않은 남은 모래의 양
 * 6. 모래가 이미 있는 칸으로 이동하면, 모래의 양은 더해진다.
 * 7. 토네이도는 좌측상단 (1,1)까지 이동한 뒤 소멸한다.
 * 8. 모래는 격자 밖으로 이동할 수도 있다.
 * 9. 가운데 칸은 모래의 양 0
 *
 * input : n의 크기, 이차원배열
 * output : 격자의 밖으로 나간 모래의 양
 *
 * 문풀
 * 1. 토네이도 이동 방향 좌,하,우,상 순
 * 2. map보다 가로 세로로 각각 4씩 더 크게 받아서
 * 3. 토네이도가 반시계방향으로 다 돈 뒤,
 *      - row : 0~1, mapsize+3~mapSize+2
 *      - col : 0~1, mapSize+3~mapSize+2
 *
 *
 * 오답노트
 *  -> 방향이 바뀌면 해당 비율도 바뀌기 때문에 (방향) 보고 있는 방향에 따라 다르게 비율을 주어야 한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20057_마법사상어와토네이도 {
    static BufferedReader br;
    static StringTokenizer st;

    static int mapSize; //이차원배열 맵사이즈(홀수)
    static int[][] map; //이차원배열 맵

    //좌하우상
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};

    static final int DELTA = 4;

    static int x, y;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        mapSize = Integer.parseInt(br.readLine().trim());
        map = new int[mapSize+4][mapSize+4];

        // 이차원 배열 맵 입력받기
        for(int rowIdx=2; rowIdx<mapSize+2; rowIdx++){
            st = new StringTokenizer(br.readLine().trim());

            for(int colIdx=2; colIdx<mapSize+2; colIdx++){
                map[rowIdx][colIdx] = Integer.parseInt(st.nextToken());
            }
        }

        tornadoWay();
        int answer = sandSum();
        System.out.println(answer);

    }

    //토네이도 방향 메서드
    public static void tornadoWay() {
        x = mapSize / 2 + 2;
        y = mapSize / 2 + 2;

        for(int idx=1; idx<mapSize; idx++){

            //짝수일 때
            if(idx % 2 ==0){
                for(int i=1; i<=idx; i++){
                    move(2, x, y);
                }
                for(int i=1; i<=idx; i++){
                    move(3, x, y);
                }
                if(idx == mapSize-1){
                    for(int i=1; i<=idx; i++){
                        move(0, x, y);
                    }
                }
            } else { //홀수일 때
                for(int i=1; i<=idx; i++){
                    move(0, x, y);
                }
                for(int i=1; i<=idx; i++){
                    move(1, x, y);
                }
            }

            for(int i=0; i<mapSize+4; i++){
                for(int j=0; j<mapSize+4; j++){
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("======");
        }
    }

    //델타 배열 흩뿌리는 메서드
    public static void move(int idx, int startX, int startY) {
        //토네이도 이동 좌표
        int nx = startX + dx[idx];
        int ny = startY + dy[idx];

        //원래 있던 모래의 양
        int sand = map[nx][ny];

        map[nx-2][ny] += (int) (sand * 0.02);
        map[nx-1][ny+1] += (int) (sand * 0.01);
        map[nx-1][ny] += (int) (sand * 0.07);
        map[nx-1][ny-1] += (int) (sand * 0.1);
        map[nx][ny-2] += (int) (sand * 0.05);
        map[nx+1][ny-1] += (int) (sand * 0.1);
        map[nx+1][ny] += (int) (sand * 0.07);
        map[nx+1][ny+1] += (int) (sand * 0.01);
        map[nx+2][ny] += (int) (sand * 0.02);

        int sum = (int)(sand*0.02)+(int)(sand*0.01)+(int)(sand*0.07)+(int)(sand*0.1)+(int)(sand*0.05)+(int)(sand*0.1)+(int)(sand*0.07)+(int)(sand*0.01)+(int)(sand*0.02);

        map[nx][ny-1] += sand - sum;

        //토네이도 이동한 곳 0으로 만들기
        map[nx][ny] = 0;

        //토네이도 좌표 이동
        x = nx;
        y = ny;
    }

    //격자 바깥으로 나간 모래의 양 구하는 메서드
    public static int sandSum(){
        int sum = 0;

        //가로
        for(int rIdx=0; rIdx<2; rIdx++){
            for(int cIdx=0; cIdx<mapSize+4; cIdx++){
                sum += map[rIdx][cIdx];
                sum += map[mapSize+3-rIdx][cIdx];
            }
        }

        //세로
        for(int cIdx=0; cIdx<2; cIdx++){
            for(int rIdx=2; rIdx<mapSize+2; rIdx++){
                sum += map[rIdx][cIdx];
                sum += map[rIdx][mapSize+3-cIdx];
            }
        }

        return sum;
    }
}
