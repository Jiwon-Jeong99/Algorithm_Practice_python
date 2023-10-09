package SAMSUNG;

/**
 * boj_20057 마법사상어와토네이도
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20057_마법사상어와토네이도 {
    static BufferedReader br;
    static StringTokenizer st;

    static int mapSize; //맵 사이즈
    static int[][] map; //이차원 배열 맵

    //좌하우상
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};
    static int[] dr = {1,1,2,2}; //좌하우상 반시계 방향의 개수

    static final int DELTA = 4;

    //좌하우상일 때 각각 퍼지는 좌표의 위치
    //퍼지는 x 위치
    static int[][] spreadX = {{-1,1,-2,-1,1,2,-1,1,0}, {-1,-1,0,0,0,0,1,1,2},
                             {1,-1,2,1,-1,-2,1,-1,0}, {1,1,0,0,0,0,-1,-1,-2}};
    //퍼지는 y 위치
    static int[][] spreadY = {{1,1,0,0,0,0,-1,-1,-2},{-1,1,-2,-1,1,2,-1,1,0},
                             {-1,-1,0,0,0,0,1,1,2},{1,-1,2,1,-1,-2,1,-1,0}};

    static final int SPREAD = 9;

    static int[] spreadRate = {1,1,2,7,7,2,10,10,5};

    static int sum; //맵 밖으로 벗어난 모래양

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        mapSize = Integer.parseInt(br.readLine().trim());

        map = new int[mapSize][mapSize];

        //이차원 배열 map 입력받기
        for(int rowIdx=0; rowIdx<mapSize; rowIdx++){

            st = new StringTokenizer(br.readLine().trim());

            for(int colIdx=0; colIdx<mapSize; colIdx++){
                map[rowIdx][colIdx] = Integer.parseInt(st.nextToken());
            }
        }

        int middle = mapSize / 2;
        int answer = move(middle, middle);
        System.out.println(answer);
    }

    //위치 이동 메서드
    static int move(int startX, int startY) {
        sum = 0;

        while(true) {
            for(int idx=0; idx<DELTA; idx++){
                for(int moveCnt=0; moveCnt<dr[idx]; moveCnt++){
                    //이동
                    int nx = startX + dx[idx];
                    int ny = startY + dy[idx];

                    //맵 밖으로 탈출하면 return
                    if(nx < 0 || nx >= mapSize || ny < 0 || ny >= mapSize ){
                        return sum;
                    }

                    spread(nx, ny, idx);

                    //토네이도 이동위치를 현재 위치로 업데이트
                    startX = nx;
                    startY = ny;

                }
            }

            //반시계방향으로 도는 한 텀이 좌하우상이 끝날때마다 +2씩 더해주어야함 -> 다음 턴을 위해
            for(int index=0; index<DELTA; index++){
                dr[index] += 2;
            }
        }
    }

    //모래 뿌리는 메서드
    static void spread(int nx, int ny, int idx){
        int sand = map[nx][ny]; //모래 총양
        map[nx][ny] = 0; //토네이도에 날아간 모래

        int totalSpread = 0; //총 spread한 모래의 양

        //a를 제외하고 흩뿌린 모래의 양
        for(int spread=0; spread<SPREAD; spread++){
            int sandX = nx + spreadX[idx][spread];
            int sandY = ny + spreadY[idx][spread];
            int spreadRatio = (sand * spreadRate[spread]) / 100;

            //맵 밖으로 벗어난 모래는 더하기
            if(sandX<0 || sandY<0 || sandX>=mapSize || sandY>=mapSize){
                sum += spreadRatio;
            } else{ //맵 밖으로 벗어난게 아니라면 맵에 더해주기
                map[sandX][sandY] += spreadRatio;
            }
            totalSpread += spreadRatio;
        }

        //a 뿌리기
        int aX = nx + dx[idx];
        int aY = ny + dy[idx];

        int aRatio = sand - totalSpread;
        if(aX<0 || aY<0 || aX>=mapSize || aY>=mapSize){
            sum += aRatio;
        }else {
            map[aX][aY] += aRatio;
        }

    }
}
