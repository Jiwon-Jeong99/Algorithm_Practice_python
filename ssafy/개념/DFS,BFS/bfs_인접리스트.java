package algorithm;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class bfs_인접리스트 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt(); // 정점
		int E = sc.nextInt(); // 간선

		int[][] adjMatrix = new int[V][V]; // 초기값 0
		// 간선 있으면 1, 없으면 0
		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjMatrix[to][from] = adjMatrix[from][to] = 1;
		}
		bfs(adjMatrix);
	}

	private static void bfs(int[][] adjMatrix) {
		int size = adjMatrix.length;
		Queue<Integer> queue = new ArrayDeque<>(); // 큐에 넣는 값은 방문대상을 관리할 값과 그 밖의 값들을 넣을 수 있다.
		boolean[] visited = new boolean[size];

		// 탐색시작점 정점 0으로
		queue.offer(0);
		visited[0] = true;

		while (!queue.isEmpty()) {
			int current = queue.poll();
			System.out.println((char) (current + 65));

			// 현 정점의 인접정점들 체크하며 대기열에 넣기
			for (int i = 0; i < size; i++) {
				// 나중에 가중치가 있을 가능성을 위해 ==1이 아닌 !=0으로
				if (adjMatrix[current][i] != 0 && !visited[i]) { // 인접하지만 방문한 적이 없으면
					queue.offer(i); // queue에 값 추가
					visited[i] = true; // 방문체크
				}
			}
		}
	}
}
