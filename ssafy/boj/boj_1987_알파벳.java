package boj;

/**
 * boj_1987 알파벳
 * 
 * 1. 
 */
import java.io.BufferedReader;
/**
 * boj_1987 알파벳
 * 
 * 1. char[]를 만들어서
 */
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1987_알파벳 {
	static BufferedReader br;
	static StringTokenizer st;

	static int row; // 가로
	static int col; // 세로
	static int[][] map; // 알파벳 배열
	static boolean[] visited = new boolean[26]; // 알파벳 배열 방문했는지 여부 확인
	static int sum; // 지나갈 수 있는 칸 수
	static int max; // 최대 지나갈 수 있는 칸 수

	static int[] dx = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine().trim());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());

		map = new int[row][col];

		for (int tc = 0; tc < row; tc++) { // 배열 만들기
			char[] line = br.readLine().trim().toCharArray();
			for (int rc = 0; rc < col; rc++) {
				map[tc][rc] = line[rc] - 'A'; // 숫자를 집어넣자
			}
		}
		max = 0;
		sum = 0;
		dfs(0, 0);
		System.out.println(max);
	}

	static void dfs(int startX, int startY) {
		visited[map[startX][startY]] = true; // 시작좌표니까 true로
		sum++;

		for (int idx = 0; idx < 4; idx++) {
			int nx = startX + dx[idx];
			int ny = startY + dy[idx];

			// 좌표를 벗어나면 건너뛰기
			if (nx < 0 || nx >= row || ny < 0 || ny >= col) {
				continue;
			}

			// 만약 방문하지 않은 알파벳이면 방문
			if (!visited[map[nx][ny]]) {
				dfs(nx, ny);
				visited[map[nx][ny]] = false; // 방문체크 해제해서 다시 갈 수 있게끔
				// 디버깅 결과 갈 수 없으면 빠꾸한다음에 빠꾸하기 전까지는 갈 수 있으니까 sum에 더해줘야 되는데
				// sum을 먼저 빼버리고 max를 구해서 그랬던거임
				max = Math.max(max, sum);
				sum--;
			}
		}
		max = Math.max(max, sum); // 처음 에는 무조건 한칸 가능이니까
	}
}
