package boj;
/**
1. 큐를 만들어서
2. 처음 x,y좌표 저장
3. 시작좌표 방문 true
4. 큐가 비어있지 않을 때
5. queue 꺼내기
6. 상하좌우 반복
7. 좌표를 벗어났다면 다음 좌표 체크
8. 배추가 있고, 체크하지 않은 좌쵸이면 
9. 좌표 저장하고 방문체크
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * boj_1012_유기농배추
 * 
 * @author 정지원
 * 
 *         bfs - 인접행렬 => 정점의 정보가 위치로 주어졌기 때문에, 정점끼리의 정보가 주어지지 않았기에 인접행렬로 푼다.
 * 
 *         1이 연결되어있는 곳의 총합을 구하면 됨
 * 
 *         1. 위치를 입력받아서 2차원 배열을 만든다. 2. (0,0)부터 bfs/dfs로 1의 위치를 찾는다. (모든 배열 다 탐색
 *         - 완전탐색) 3. 사방이 다 0일때 cnt++ 해준다. 4. 0일때 bfs/dfs 탐색이 끊기므로 반복문을 넣어서
 *         방문체크를 안한 배추가 남아있는지 확인한다.
 * 
 */
public class boj_1012_유기농배추_bfs {
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

			int count = 0; // 지렁이 개수 세기

			// 모든 map배열의 원소들을 순회하면서 배추가 있는지를 확인하기
			for (int col = 0; col < height; col++) {
				for (int row = 0; row < width; row++) {
					// 좌표에 배추가 있는지 확인, 체크 안한 곳인지 확인
					if (map[row][col] == 1 && !visited[row][col]) {
						// 배추가 있고 방문체크가 안된 지점부터 bfs로 연결
						bfs(row, col);

						// 인접한 곳을 모두 파악했으면 지렁이 놓기
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}

	static void bfs(int startX, int startY) { // i 정점부터 시작
		Queue<int[]> queue = new ArrayDeque<>();

		// bfs에서 queue의 역할은 다음 탐색할 좌표를 미리 저장해 놓는 것
		// bfs 1번 실행될때마다 인접한 곳을 모두 탐색하고 종료하니 bfs안에 queue 선언

		// x,y좌표 저장
		queue.offer(new int[] { startX, startY });

		// 시작좌표에 배추가 있으니 미리 true
		visited[startX][startY] = true;

		// 배추가 상하좌우에 인접하면 이동가능
		// 현재 자리에서 상하좌우 움직이는 좌표 지정 => dx, dy

		// queue가 비어있으면 더이상 인접한 배추가 없다는 뜻
		while (!queue.isEmpty()) {
			int[] poll = queue.poll(); // 저장된 queue 꺼내기

			// 상하좌우가 4가지 이니 for문 4번 반복
			for (int idx = 0; idx < 4; idx++) {// 상하좌우 좌표 이동
				int nx = poll[0] + dx[idx];
				int ny = poll[1] + dy[idx];

				// 좌표가 배추밭을 벗어나면 다음 좌표 체크
				if (nx < 0 || nx >= width || ny < 0 || ny >= height) {
					continue;
				}

				// 상하좌우로 움직인 좌표에 배추가 있고, 체크하지 않은 좌표이면
				if (map[nx][ny] == 1 && !visited[nx][ny]) {
					queue.offer(new int[] { nx, ny }); // 좌표 저장
					visited[nx][ny] = true; // 방문체크
				}
			}
		}

	}
}
