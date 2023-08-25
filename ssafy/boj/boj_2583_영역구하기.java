package boj;

import java.io.BufferedReader;
/**
 * boj_2583_영역구하기
 * 
 * 문제
 * 1. 왼쪽 아래 꼭짓점 x,y - 오른쪽 위 꼭짓점 x,y
 * 
 * 1. 직사각형의 좌표가 벽 1인 걸로
 * 2. bfs로 나머지 0의 구간의 크기를 구해서 저장한다.
 */
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2583_영역구하기 {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;

	static int row; // 가로
	static int col; // 세로
	static int total; // 직사각형 개수
	static int[][] map; // 2차원 배열
	static boolean[][] visited; // 방문체크 배열

	static int sum; // 영역의 총 개수
	static int count; // 각 영역의 크기

	static int[] dx = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dy = { 0, 0, -1, 1 };
	static List<Integer> list;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine().trim());

		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		total = Integer.parseInt(st.nextToken());

		// 이차원 배열들 초기화
		map = new int[row][col];
		visited = new boolean[row][col];

		for (int tc = 0; tc < total; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			int smallY = Integer.parseInt(st.nextToken());
			int smallX = Integer.parseInt(st.nextToken());
			int bigY = Integer.parseInt(st.nextToken());
			int bigX = Integer.parseInt(st.nextToken());

			// 직사각형이 위치한 곳 1로 배치
			for (int rowIdx = smallX; rowIdx < bigX; rowIdx++) {
				for (int colIdx = smallY; colIdx < bigY; colIdx++) {
					map[rowIdx][colIdx] = 1;
				}
			}

		}
		sum = 0;
		count = 0;

		list = new ArrayList<>();
		// 전체를 탐색하면서 0의 위치 찾아 시작하기
		for (int x = 0; x < row; x++) {
			for (int y = 0; y < col; y++) {
				if (map[x][y] == 0 && !visited[x][y]) {
					bfs(x, y);
					sum++;
					list.add(count);
					count = 0;
				}
			}
		}
		Collections.sort(list);

		System.out.println(sum);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}

	// bfs
	static void bfs(int startX, int startY) {
		Queue<int[]> queue = new ArrayDeque<>();

		// x,y좌표 저장
		queue.offer(new int[] { startX, startY });

		// 시작좌표에 있으니 true
		visited[startX][startY] = true;
		count++;

		while (!queue.isEmpty()) {
			int[] poll = queue.poll();

			// 상하좌우
			for (int idx = 0; idx < 4; idx++) {
				int nx = poll[0] + dx[idx];
				int ny = poll[1] + dy[idx];

				if (nx < 0 || nx >= row || ny < 0 || ny >= col) {
					continue;
				}

				// 상하좌우 빈공간이 있고 방문체크 안했으면
				if (map[nx][ny] == 0 && !visited[nx][ny]) {
					queue.offer(new int[] { nx, ny });
					visited[nx][ny] = true;
					count++;
				}
			}
		}
	}
}
