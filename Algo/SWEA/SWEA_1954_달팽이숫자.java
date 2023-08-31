package swea;

/**
 * swea_1954 달팽이숫자
 *
 * 문제
 * 1. 맵 사이즈를 입력받고 맵의 사이즈를 결정한다.
 * 2. 시계방향으로 달팽이 껍질처럼 파고드는 모양으로 반환한다.
 *
 * 문풀
 * 1. 델타배열 상하좌우 한 다음 맵의 크기만큼 순회하며 이동
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1954_달팽이숫자 {
    static BufferedReader br;

    static int size; // 맵의 크기
    static int[][] map; // 달팽이 맵
    static int[] dx = { 0, 1, 0, -1 }; // 우하좌상
    static int[] dy = { 1, 0, -1, 0 };
    static int direct; //방향

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= testCase; tc++) {
            size = Integer.parseInt(br.readLine().trim());
            map = new int[size][size];

            direct = 0;
            int row = 0;
            int col = 0; //시작좌표

            for(int idx=1; idx<= size*size; idx++){
                map[row][col] = idx;

                int nx = row + dx[direct];
                int ny = col + dy[direct];

                //맵에서 나가면 방향전환하기
                if(nx <0||ny <0 || nx >=size ||ny >= size ||map[nx][ny] != 0){
                    direct = (direct+1)%4;//방향전환
                    nx = row + dx[direct];
                    ny = col + dy[direct];
                }

                row = nx;
                col = ny;
            }
            System.out.println("#"+tc);
            for(int index=0; index<size; index++) {
                for (int num : map[index])
                    System.out.print(num + " ");
                System.out.println();
            }
        }
    }
}
