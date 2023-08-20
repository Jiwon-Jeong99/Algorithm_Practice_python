package swea;

//겹치지 않는 경우 1, 겹칠 경우 0
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1974_스도쿠검증 {
    static BufferedReader br;
    static StringTokenizer st;

    static int[][] map;
    static boolean[] visited;
    static int answer = 1;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= testCase; tc++) {
            answer = 1;
            map = new int[9][9];
            visited = new boolean[10];
            for (int i = 0; i < 9; i++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int j = 0; j < 9; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (!visited[map[i][j]])
                        visited[map[i][j]] = true;
                }
                for (int idx = 1; idx < 10; idx++) {
                    if (!visited[idx]) {
                        answer = 0;
                        break;
                    }
                }
                visited = new boolean[10];
            }

            for (int rowIdx = 0; rowIdx < 9; rowIdx++) {
                for (int colIdx = 0; colIdx < 9; colIdx++) {
                    if (!visited[map[colIdx][rowIdx]])
                        visited[map[colIdx][rowIdx]] = true;
                }
                for (int idx2 = 1; idx2 < 10; idx2++) {
                    if (!visited[idx2]) {
                        answer = 0;
                        break;
                    }
                }
                visited = new boolean[10];
            }

            // 격자
            for (int index1 = 0; index1 < 9; index1 += 3) {
                for (int index2 = 0; index2 < 9; index2 += 3) {
                    for (int a = 0; a < 3; a++) {
                        for (int b = 0; b < 3; b++) {
                            if (!visited[map[index1 + a][index2 + b]]) {
                                visited[map[index1 + a][index2 + b]] = true;
                            }
                        }
                    }
                    for (int idx3 = 1; idx3 < 10; idx3++) {
                        if (!visited[idx3]) {
                            answer = 0;
                            break;
                        }
                    }
                    visited = new boolean[10];
                }
            }
            System.out.println("#" + tc + " " + answer);
        }
    }
}
