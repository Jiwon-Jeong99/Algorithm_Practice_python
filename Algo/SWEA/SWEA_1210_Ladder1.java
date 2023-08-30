package swea;

/**
 * swea_1210 Ladder1
 * !!!!도착지점은 무조건 99,99 가 아니라 2로 표시된다!!!
 * 문제좀 잘 읽자,,,,젭알
 * 
 * 문제
 * 1. 맵의 크기는 100x100
 * 2. 출발점 시작은 0부터 시작 (인덱스와 동일)
 * 3. 좌우 방향 이동 가 -> 좌우 먼저
 * 4. 좌우 방향 이동 후에는 아래로만 이동
 * 5. 도착지점은 2로 알려줌
 * 
 * 문풀
 * 1. 100x100 맵을 이차원 int 배열로 받는다.
 * 2. 도착 지점의 좌표를 구해서 (2) 도착지점에서 출발한다.
 * 3. 좌우에 길인 1이 있으면 좌우로 이동하고 없으면 위로 이동한다.(델타배열)
 * 4. row = 0이 될때까지 반복하다 row=0이 되면 해당 col 인덱스를 반환한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1210_Ladder1 {
	static BufferedReader br;
	static StringTokenizer st;

	static int[][] map; // 사다리 타는 맵
	static int[] dx = { 0, 0, -1 }; // 상좌우
	static int[] dy = { -1, 1, 0 };
	static int arriveX, arriveY; // 도착지점

	static int nx;
	static int ny;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			br.readLine().trim(); // 테스트케이스 번호는 필요없으니까

			map = new int[100][100]; // 맵 초기화

//			1. 100x100 맵을 이차원 int 배열로 받는다.
			for (int rowIdx = 0; rowIdx < 100; rowIdx++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int colIdx = 0; colIdx < 100; colIdx++) {
					map[rowIdx][colIdx] = Integer.parseInt(st.nextToken());

					// 도착지점 좌표 확인
					if (map[rowIdx][colIdx] == 2) {
						arriveX = rowIdx;
						arriveY = colIdx;
					}
				}
			}

//			2. 도착 지점인 (99,99)에서 출발한다.
			int answer = search(arriveX, arriveY);
			System.out.println("#" + tc + " " + answer);
		}
	}

	// 길을 탐색하는 메서드
	static int search(int startX, int startY) {
		while (startX != 0) {

//			3. 좌우에 길인 1이 있으면 좌우로 이동하고 없으면 위로 이동한다.(델타배열)
			for (int idx = 0; idx < 3; idx++) {
				nx = startX + dx[idx];
				ny = startY + dy[idx];

				if (nx < 0 || ny < 0 || nx >= 100 || ny >= 100) // 맵 벗어나면 continue
					continue;

				if (map[nx][ny] == 1) {
					startX = nx;
					startY = ny;
					map[startX][startY] = 0; // 갔던 길은 다시 가지 못하게 0으로 처리
					break;
				}
			}
		}

//		4. row = 0이 될때까지 반복하다 row=0이 되면 해당 col 인덱스를 반환한다.
		return startY;
	}
}
