package swea;
/**
 * swea_2001 파리퇴치
 * 이차원배열 순회 - O(n^2)
 *
 * 문제
 * 1. mapSize 입력
 * 2. 파리잡을 범위 입력
 *
 * 문풀
 * 1. 테스트케이스를 입력받기
 * 2. 테스트케이스만큼 반복하기
 * 3. N 배열, 내리칠 M크기 배열 입력받기
 * 4. N줄에 걸쳐 N배열 입력받기
 * 5. M배열에서 좌측상단을 중점으로 colIdx를 먼저 순회한 후에, rowIdx+1을 하는 식으로 순회한다.
 * 6. 배열 범위 내에서 움직이도록 한다.
 * 7. max값을 업데이트 하며 최종 max값을 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2001_파리퇴치 {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;

    static int mapSize;
    static int catchSize;
    static int[][] map;
    static int max;
    static int sum;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine().trim());
        for(int tc=1; tc<=testCase; tc++){
            st = new StringTokenizer(br.readLine().trim());
            mapSize = Integer.parseInt(st.nextToken());
            catchSize = Integer.parseInt(st.nextToken());

            map = new int[mapSize][mapSize];
            //map입력받기
            for(int rowIdx = 0; rowIdx<mapSize; rowIdx++){
                st = new StringTokenizer(br.readLine().trim());
                for(int colIdx=0; colIdx<mapSize; colIdx++){
                    map[rowIdx][colIdx] = Integer.parseInt(st.nextToken());
                }
            }

            max = 0;
            // 5. M배열에서 좌측상단을 중점으로 colIdx를 먼저 순회한 후에, rowIdx+1을 하는 식으로 순회한다.
            for(int rIdx=0; rIdx<mapSize-catchSize+1; rIdx++) {
                for (int cIdx = 0; cIdx < mapSize - catchSize + 1; cIdx++) {
                    sum = 0;
                    for (int limitRowIdx = 0; limitRowIdx < catchSize; limitRowIdx++) {
                        for (int limitColIdx = 0; limitColIdx < catchSize; limitColIdx++) {
                            sum += map[limitRowIdx + rIdx][limitColIdx + cIdx];
                        }
                        max = Math.max(max, sum);
                    }
                }
            }
            System.out.println("#"+tc+" "+max);
        }
    }
}
