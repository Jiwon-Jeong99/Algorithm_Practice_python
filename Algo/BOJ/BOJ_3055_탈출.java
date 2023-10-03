package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * boj_3055 탈출
 * 1초 128mb
 *
 * bfs, 백트래킹
 *
 * @author 정지원
 *
 * 문제
 * 1. 티떱숲의 맵 R행 C열
 * 2. 빈 곳 : . , 물이 차있는 곳 : * , 돌 : X
 * 3. 비버 굴 : D, 고슴도치 위치 : S (S->D)
 * 4. 매분 마다 고슴도치는 상하좌우 이동 가능
 * 5. 		  물도 비어있는 칸으로 이동
 * 6. 물과 고슴도치는 돌을 통과할 수 없다.
 * 7. 고슴도치는 물이 차있는 구역으로 이동x
 * 	    물이 찰 예정인 칸으로 이동x
 * 8. 물도 비버의 소굴로 이동x
 * => 지도가 주어질 때) 고슴도치가 안전하게 비버의 굴로 이동하기 위해 필요한 최소시간을 구하라.
 *
 * input) 띠덮숲 이차원 배열 맵
 * output)
 * - 고슴도치가 비버의 굴로 이동할 수 있는 가장 빠른 시간 (S -> D)
 * - 비버의 굴로 이동 불가능 : KAKTUS
 * ========================================
 * 문풀
 * 이전 토마토 문제와 비슷
 * char로 바꿨을 때) 비버굴 : 3, 고슴도치 : 18, X : 23, 물 : -23, 빈곳 : -19
 * 1. 행과 열을 입력받는다.
 * 2. 2차원 맵에 char들을 int로 바꿔서 넣는다.
 * 3. 고슴도치와 비버굴의 좌표를 이차원 배열 정보 받을 때 같이 받아놓는다.
 * 4. 물과 고슴도치 이동 모두 bfs
 *      but, 물이 퍼질 곳은 고슴도치가 가면 안되니까 물이 퍼지고 난 후 -> 고슴도치 이동 순으로 1회 사용
 *                                        고슴도치의 queue크기, 물의 queue크기만큼 돌려야 함
 * 5. depth를 주어서 큐에 먼저 물의 depth=1인 애들부터 큐에서 빼서 체크해주고, 4방 이동하는 방식으로
 *    이동한 후의 애들은 depth+1을 해주어서 구분
 *
 * 오답노트
 * queue의 크기를 받아 그 크기만큼 돌려야 한다.
 * 물이동 -> 고슴도치 이동이라는 순서가 있기 때문에
 * 조건을 걸어두지 않고 while문으로 돌리면 순서 안지켜지면서 이상한 답이 나온다.
 */
public class BOJ_3055_탈출 {
    static BufferedReader br;
    static StringTokenizer st;

    static int row, col; //맵의 행, 열
    static char[][] map; //띠덮숲 이차원 배열 맵
    static int min = Integer.MAX_VALUE; //최소시간

    static int[] dy = {0, 0, -1, 1}; //상하좌우
    static int[] dx = {-1, 1, 0, 0};

    static Queue<waterPos> waterQueue = new ArrayDeque<>();
    static Queue<hedgePos> hedgehogQueue = new ArrayDeque<>();

    static final int DELTA_MOVE = 4;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine().trim());

        //1. 행과 열을 입력받는다.
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        map = new char[row][col];

        //2. 2차원 맵에 char들을 int로 바꿔서 넣는다.
        for(int rowIdx=0; rowIdx<row; rowIdx++) {
            String input = br.readLine().trim();

            for(int colIdx=0; colIdx<col; colIdx++) {
                map[rowIdx][colIdx] = input.charAt(colIdx);

                //3. 고슴도치와 비버굴의 좌표를 이차원 배열 정보 받을 때 같이 받아놓는다.
                if(map[rowIdx][colIdx] == 'S') hedgehogQueue.offer(new hedgePos(rowIdx, colIdx, 0));
                else if(map[rowIdx][colIdx] == '*') waterQueue.offer(new waterPos(rowIdx, colIdx));
            }
        }

        hedgeBfs();

        System.out.println(min == Integer.MAX_VALUE ? "KAKTUS" : min);

    }

    //고슴도치 이동 bfs(상하좌우 search)
    public static void hedgeBfs() {

        while(!hedgehogQueue.isEmpty()){
            //물을 먼저 퍼뜨린다
            waterBfs();
            int len = hedgehogQueue.size();
            for(int idx=0; idx<len; idx++) {

                hedgePos hog = hedgehogQueue.poll(); //저장된 객체를 꺼내서

                int x = hog.row; //고슴도치 x좌표
                int y = hog.col; //고슴도치 y좌표
                int depth = hog.depth;

                //상하좌우 이동
                for (int move = 0; move < DELTA_MOVE; move++) {
                    int nx = x + dx[move];
                    int ny = y + dy[move];

                    //맵을 벗어나거나 X를 만나거나 *을 만나면 continue
                    if (nx < 0 || nx >= row || ny < 0 || ny >= col || map[nx][ny] == 'X' || map[nx][ny] == '*' || map[nx][ny] == 'S') continue;

                    //상하좌우 움직여서 빈칸이라면
                    if (map[nx][ny] == 'D') {
                        min = Math.min(min, depth + 1);
                        return;
                    } else if (map[nx][ny] == '.') {
                        map[nx][ny] = 'S';
                        hedgehogQueue.offer(new hedgePos(nx, ny, depth + 1));
                    }
                }
            }
        }
    }

    //물 이동 bfs
    public static void waterBfs() {
        //여기에 while (!queue.isEmpty)를 지우니까 됐다..왜지?
            int len = waterQueue.size();
            for(int idx=0; idx<len; idx++) {

                waterPos w = waterQueue.poll();

                int x = w.row;
                int y = w.col;

                for (int move = 0; move < DELTA_MOVE; move++) {
                    int nx = x + dx[move];
                    int ny = y + dy[move];

                    if (nx < 0 || nx >= row || ny < 0 || ny >= col || map[nx][ny] == 'X' || map[nx][ny] == '*' || map[nx][ny] == 'D') continue;

                    if (map[nx][ny] == '.') {
                        map[nx][ny] = '*';
                        waterQueue.offer(new waterPos(nx, ny));
                    }
                }
            }

    }

    //좌표 객체
    public static class waterPos {
        int row, col;

        public waterPos(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static class hedgePos {
        int row, col, depth;

        public hedgePos(int row, int col, int depth) {
            this.row = row;
            this.col = col;
            this.depth = depth;
        }
    }
}