package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * boj_1012 유기농배추
 * 
 * @author 정지원
 * 
 *
 */

public class boj_1012_유기농배추_dfs {
	static BufferedReader br;
	static StringTokenizer st;

	static int width; // 배추밭 가로길이
	static int height; // 배추밭 세로길이
	static int total; // 심어진 배추 개수
	static int[][] map; // 배추 위치 info
	static boolean[][] visited; // 방문했는지 체크
	static int count; // 지렁이 개수 총합
	static int[] dx = { 0, 0, -1, 1 }; // 상하좌우
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine().trim());
		for (int tc = 0; tc < testCase; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			width = Integer.parseInt(st.nextToken());
			height = Integer.parseInt(st.nextToken());
			total = Integer.parseInt(st.nextToken());

			map = new int[width][height]; // 배추 위치 배열
			visited = new boolean[width][height]; // 방문체크 배열

			for (int time = 0; time < total; time++) {
				st = new StringTokenizer(br.readLine().trim());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y] = 1; // 배추 좌표 입력
			}

			int count = 0; // 지렁이 개수

			// 좌표에 배추가 있는지 확인, 내가 체크안한 곳이 있는지 확인
			for (int col = 0; col < height; col++) {
				for (int row = 0; row < width; row++) {
					if (map[row][col] == 1 && !visited[row][col]) {
						dfs(row, col);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}

	static void dfs(int startX, int startY) {
		visited[startX][startY] = true;// 시작좌표엔 배추가 있으니 미리 true

		for (int idx = 0; idx < 4; idx++) {
			int nx = startX + dx[idx];
			int ny = startY + dy[idx];

			if (nx < 0 || nx >= width || ny < 0 || ny >= height) {
				continue;
			}

			// 상하좌우 움직인 좌표에 배추가 있고, 체크하지 않은 좌표이면
			if (map[nx][ny] == 1 && !visited[nx][ny]) {
				dfs(nx, ny);
			}
		}
	}
}
