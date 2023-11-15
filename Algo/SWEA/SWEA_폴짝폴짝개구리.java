package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * swea_폴짝폴짝개구리
 *
 * 파리가 없는 칸 - 0
 * 파리가 있는 칸 - 1
 * 개구리가 있는 칸 - 2
 *
 * 총 3번 이동
 * 상하좌우
 * 파리 하나를 뛰어넘으면 빈칸에 위치, 그 다음 파리 먹고 해당칸에 위치 가능
 * 한번넘은 파리 다시 넘을 수 있다.
 */

public class SWEA_폴짝폴짝개구리 {
    static BufferedReader br;
    static StringTokenizer st;

    static int[][] map;
    static int mapSize;

    //상하좌우
    static int[] dx = {-1,1,0,0};
    static int[] dy= {0,0,-1,1};
    static final int DELTA = 4;

    static boolean[][] isEaten; //파리 남았는지
    static int flyCnt;


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        //테스트케이스만큼 반복
        int testCase = Integer.parseInt(br.readLine().trim());
        for(int tc=1; tc<=testCase; tc++) {
            mapSize = Integer.parseInt(br.readLine().trim());
            map = new int[mapSize][mapSize];
            isEaten = new boolean[mapSize][mapSize];
            Frog frog = null;

            for(int rowIdx=0; rowIdx<mapSize; rowIdx++){
                st = new StringTokenizer(br.readLine().trim());

                for(int colIdx=0; colIdx<mapSize; colIdx++){
                    map[rowIdx][colIdx] = Integer.parseInt(st.nextToken());
                    if(map[rowIdx][colIdx] == 2) {
                        frog = new Frog(rowIdx, colIdx);
                        //Frog 객체의 멤버 변수값 할당
                        frog.row = rowIdx;
                        frog.col = colIdx;
                    }
                }
            }

            //개구리 점프
            dfs(0, frog.row, frog.col);

            //먹은 파리수
            flyCnt = 0;
            for(int row = 0; row<mapSize; row++) {
                for(int col=0; col<mapSize; col++) {
                    if(isEaten[row][col]) flyCnt++;
                }
            }
            System.out.println("#"+tc+" "+flyCnt);
        }
    }

    //dfs로 판별
    static void dfs(int depth, int curRow, int curCol) {
        //3번 모두 움직이면 탈출
        if(depth == 3) return;

        //상하좌우로 이동
        for(int dir=0; dir<DELTA; dir++) {
            int nx = curRow + dx[dir];
            int ny = curCol + dy[dir];

            while(true) {
                //맵 탈출하면 다음 방향으로 이동하기
                if(nx < 0 || ny < 0 || nx >= mapSize || ny >= mapSize) break;

                //뛰어서 이동할 수 있는 상황이면
                if(isJump(dir, curRow, curCol, nx, ny)){
                    //뛴 칸에 파리가 있는지 확인
                    if(map[nx][ny] == 1) {
                        map[nx][ny] = 0;
                        isEaten[nx][ny] = true; //파리 먹었으니까
                        //다음 이동
                        dfs(depth+1, nx, ny);
                        map[nx][ny] = 1; //파리 상태 원상복구
                    }else { //파리가 없다면
                        dfs(depth+1, nx, ny);
                    }
                }

                //다음 위치로 계산 -> 해당 방향으로 1칸씩 늘려가면서 isJump에서 해당 구역에 파리가 있는지 확인
                nx += dx[dir];
                ny += dy[dir];
            }
        }
    }

    //개구리가 뛰어서 이동할 수 있는지 확인하는 메서드
    static boolean isJump(int dir, int fromRow, int fromCol, int toRow, int toCol) {
        //파리가 1마리면 뛰기 가능 - 2마리면 불가능
        int betweenFly = 0;

        //상
        if(dir == 0) {
            for(int row = fromRow; row > toRow; row--) { //현재 위치
                if(map[row][fromCol] == 1) betweenFly++;
            }
        }
        //하
        else if(dir == 1) {
            for(int row = fromRow; row < toRow; row++) {
                if(map[row][fromCol] == 1) betweenFly++;
            }
        }
        //좌
        else if(dir == 2) {
            for(int col = fromCol; col > toCol; col--) {
                if(map[fromRow][col] == 1) betweenFly++;
            }
        }
        //우
        else if(dir == 3) {
            for(int col = fromCol; col < toCol; col++) {
                if(map[fromRow][col] == 1) betweenFly++;
            }
        }

        if(betweenFly == 1) return true;
        return false;
    }

    static class Frog {
        int row, col;
        Frog(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
}
