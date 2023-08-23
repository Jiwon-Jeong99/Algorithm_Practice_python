package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * boj_1260
 * 
 * @author 정지원
 * 
 *         배열 전체x -> 정점끼리의 연결 정보가 주어짐 1. 인접행렬 만들기 2. 방문체크를 위한 배열 만들기 3. dfs 4.
 *         bfs - ArrayDeque에 넣어서 하기 dfs - 재귀
 */
public class boj_1260_DFS와BFS {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;

	static int vertex; // 정점의 개수
	static int edge; // 간선의 개수
	static int start; // 시작할 정점의 번호

	static int[][] arr; // 인접행렬 - 이차원 배열
	static boolean[] visited; // 방문체크 배열

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		sb = new StringBuilder();

		vertex = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());

		arr = new int[vertex + 1][vertex + 1]; // 1로 시작하기 위해 +1
		visited = new boolean[vertex + 1];

		for (int tc = 0; tc < edge; tc++) {
			st = new StringTokenizer(br.readLine().trim());

			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());

			arr[num1][num2] = arr[num2][num1] = 1; // -> 인접행렬 만들기(양방향)
		}

		// dfs, bfs 불러오기
		dfs(start);
		sb.append("\n");
		// 방문배열 초기화
		visited = new boolean[vertex + 1];
		bfs(start);
		System.out.println(sb);
	}

	// dfs - 재귀
	// 이번에는 숫자의 나열이니까 1차원이어서 매개변수로 받는것도 한개
	static void dfs(int start) {
		visited[start] = true; // 방문체크
		sb.append(start + " ");

		// 아직 방문체크하지 않은 위치로 이동
		for (int idx = 1; idx <= vertex; idx++) {
			if (arr[start][idx] == 1 && !visited[idx])
				dfs(idx);
		}
	}

	// bfs
	static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		// 방문한 곳 큐에 삽입 및 방문처리
		queue.add(start);
		visited[start] = true;

		// 이동할 정점이 있을 때
		while (!queue.isEmpty()) {
			start = queue.poll();
			sb.append(start + " ");

			for (int num = 1; num <= vertex; num++) {
				if (arr[start][num] == 1 && !visited[num]) {
					visited[num] = true;
					queue.add(num);
				}
			}
		}
	}
}
