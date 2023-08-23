package boj;

/**
 * boj_7576 토마토
 * 
 * bfs : 최단시간을 알고 싶어하니까
 * 
 * 1. 4방향 델타배열 생성
 * 2. 토마토가 없는 -1은 visited를 true로 박아두어서 0이 있으면 바로 0이 출력되도록
 * !!가장 큰 문제!!
 * -> 주어진 익은 토마토가 여러개일때, 동시다발적으로 bfs가 이루어져야 하고, 시간이 지날때마다 점진적으로 익은 토마토의 개수가 증가해야 한다.
 * -> 이걸 어떻게 구현해야 할지 모르겟음
 * 
 * !! 해결방법 !!
 * 1. depth를 주어서 
 * 2. 큐에 1이 주어진 순서대로 넣고 
 * 3. depth=1인 애들부터 큐에서 빼서 체크해주고
 * 4. 4방 델타로 이동한 애들은 큐에 넣고 빼면서
 * 5. 그래프에 있는 번호를 depth=1인 애들의 +1을 해줘서 depth를 나타낸다.
 * 6. 마지막으로 모두 순회하면서 가장 큰 값을 찾으면 걸리는 시간을 알 수 있다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_7576_토마토 {
	static BufferedReader br;
	static StringTokenizer st;

	static int[][] graph; // 그래프 이차원 배열

	static int row; // 가로
	static int col; // 세로

	static int[] dx = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dy = { 0, 0, -1, 1 };

	static boolean allRipe; // 토마토가 다 익었는지 여부
	static int count; // 걸리는 날
	static int depth; // 언제 1이 되었는지에 따른 depth

	static Queue<int[]> queue = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());

		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());

		allRipe = true; // 모든 토마토가 익었는지 알기 위한 초기화
		graph = new int[row][col];

		// 그래프 채우기
		for (int rowIdx = 0; rowIdx < row; rowIdx++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int colIdx = 0; colIdx < col; colIdx++) {
				graph[rowIdx][colIdx] = Integer.parseInt(st.nextToken());
				if (graph[rowIdx][colIdx] == 0)
					allRipe = false;
			}
		}

		// 저장될 때부터 모든 토마토가 익어있다면
		if (allRipe) {
			System.out.println(0);
			return;
		}

		count = 0; // 흐르는 요일

		// 모든 배열의 원소들을 순회하면서 확인
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				// 방문하지 않은 익은 토마토가 있다면 거기부터 시작해야 하니까
				if (graph[r][c] == 1) {
					queue.offer(new int[] { r, c }); // 처음 시작이 1인 곳을 queue에 담아준다.
				}

			}
		}
		int answer = bfs();
		System.out.println(answer);
	}

	// bfs
	static int bfs() {
		// 상하좌우 이동 가능
		while (!queue.isEmpty()) {
			int[] poll = queue.poll(); // 저장된 정점을 꺼내서

			int x = poll[0]; // 전의 x좌표
			int y = poll[1]; // 전의 y좌표

			// 상하좌우 위치이동
			for (int move = 0; move < 4; move++) {
				int nx = x + dx[move];
				int ny = y + dy[move];

				// 해당 박스를 벗어나거나 -1을 만나면 continue
				if (nx < 0 || nx >= row || ny < 0 || ny >= col) {
					continue;
				}

				// 상하 좌우로 움직인 위치에 토마토가 있고, 체크하지 않은 곳이면
				if (graph[nx][ny] == 0) {
					queue.offer(new int[] { nx, ny });
					graph[nx][ny] = graph[x][y] + 1; // depth설정해서 몇번째로 bfs가 일어나는건지
				}
			}
		}

		int max = 0;
		if (impossible())
			return -1; // 불가능하면 -1 반환
		else {
			// 전체 그래프 순회하면서 최대값 찾기 => 지난 요일 + 1이 값으로 있기 때문에 -1 해주어야 함
			for (int width = 0; width < row; width++) {
				for (int height = 0; height < col; height++) {
					if (max < graph[width][height]) {
						max = graph[width][height];
					}
				}
			}
			return max - 1;
		}

	}

	// 전체 익게 하기 불가능 check
	static boolean impossible() {
		for (int width = 0; width < row; width++) {
			for (int height = 0; height < col; height++) {
				if (graph[width][height] == 0)
					return true;
			}
		}
		return false;
	}
}
