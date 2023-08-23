package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * boj_4963 섬의개수
 * 
 * @author 정지원
 * 
 *         1. dfs로 깊이우선탐색으로 재귀로 푼다. 2. 대각선까지 포함이니까 8방탐색으로 푼다.
 *
 */
public class boj_4963_섬의개수 {
	static BufferedReader br;
	static StringTokenizer st;

	static int row; // 가로
	static int col; // 세로
	static int cnt; // 섬 개수
	static int[][] graph; // 인접행렬
	static boolean[][] visited; // 방문배열

	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 }; // 상하좌우, 대각선
	static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			st = new StringTokenizer(br.readLine().trim());

			col = Integer.parseInt(st.nextToken());
			row = Integer.parseInt(st.nextToken());

			// 기저조건 모두 0일때
			if (col == 0 && row == 0)
				break;

			visited = new boolean[row][col]; // 방문배열 초기화
			graph = new int[row][col]; // 그래프 초기화

			for (int rowIdx = 0; rowIdx < row; rowIdx++) {// 그래프 만들기
				st = new StringTokenizer(br.readLine().trim());
				for (int colIdx = 0; colIdx < col; colIdx++) {
					graph[rowIdx][colIdx] = Integer.parseInt(st.nextToken());
				}
			}

			cnt = 0;

			// 바다를 만나게 되면 dfs가 끊기기 때문에 전체 순회
			for (int r = 0; r < row; r++) {
				for (int c = 0; c < col; c++) {
					if (graph[r][c] == 1 && !visited[r][c]) {// 끝나면 cnt 올리기
						dfs(r, c);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}

	// dfs
	static void dfs(int startX, int startY) {
		visited[startX][startY] = true; // 방문처리

		for (int idx = 0; idx < 8; idx++) { // 8방탐색
			int nx = startX + dx[idx];
			int ny = startY + dy[idx];

			if (nx < 0 || nx >= row || ny < 0 || ny >= col) {// 그래프를 벗어나면 pass
				continue;
			}

			if (graph[nx][ny] == 1 && !visited[nx][ny]) {// 방문하지 않았고 1인 곳을 만나면 dfs
				dfs(nx, ny);
			}
		}
	}
}
