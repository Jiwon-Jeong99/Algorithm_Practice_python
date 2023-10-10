package BOJ;

/**
 * boj_17144 미세먼지안녕
 * 1초 512mb
 * 
 * 문제
 * 1. r x c의 격자판
 * 2. 공기청정기는 항상 1열에 위치, 크기는 두 행을 차지
 * 3. 한 루틴
 * 		1) 미세먼지 확산 -> 미세먼지가 있는 모든 칸에서 동시에
 * 			- 상하좌우
 * 			- 공기청전기나 칸이 없으면 확산x
 * 			- 확산되는 양은 x/5씩, 소수점은 버림(int)
 * 			- r,c에 남은 미세먼지의 양 : x - (x/5)x(확산된 방향의 개수)
 * 		2) 공기청정기 작동
 * 			- 위쪽 바람 반시계방향, 아래쪽 바람 시계방향
 * 			- 바람이 불면 미세먼지는 바람의 방향으로 한칸씩 이동
 * 			- 공기청정기로 들어간 미세먼지는 모두 정화
 *	
 * input : row, col, turn / 이차원배열
 * output : t초가 지난 후 방에 남아있는 미세먼지의 양
 * 
 * 문풀
 * 겉에 있는 미세먼지만 rotate
 * 위 : 반시계, 아래 : 시계방향
 * 시작점 : -1
 * 
 * 1. 이차원 배열 받기
 * 2. 받을 때, dustQueue에 먼지 좌표와 값 넣기
 * 3. 공기청정기 좌표 cleaner 배열에 넣기
 * 4. 미세먼지 확산 메서드
 * 5. 상하좌우 델타배열 생성
 * 6. bfs로 모두 확산
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17144_미세먼지안녕 {
	static BufferedReader br;
	static StringTokenizer st;

	static int row, col, turn; // 이차원배열의 row, col, 턴수
	static int[][] map; // 이차원배열 맵
	static Queue<Pos> dustQueue; // 먼지 좌표, 값 큐
	static ArrayList<Integer> cleaner; // 공기청정기 행 좌표

	// 5. 상하좌우 델타배열 생성
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static final int DELTA = 4;

	// 반시계방향 - 상우하좌
	static int[] antidx = { -1, 0, 1, 0 };
	static int[] antidy = { 0, 1, 0, -1 };
	static int[] antiSize;

	// 시계방향 - 하우상좌
	static int[] nordx = { 1, 0, -1, 0 };
	static int[] nordy = { 0, 1, 0, -1 };
	static int[] norSize;
	
	static int sum=0;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine().trim());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		turn = Integer.parseInt(st.nextToken());

		map = new int[row][col];
		dustQueue = new ArrayDeque<>();
		cleaner = new ArrayList<>();

		// 1. 이차원 배열 받기
		for (int rowIdx = 0; rowIdx < row; rowIdx++) {
			st = new StringTokenizer(br.readLine().trim());

			for (int colIdx = 0; colIdx < col; colIdx++) {

				map[rowIdx][colIdx] = Integer.parseInt(st.nextToken());

				// 2. 받을 때, dustQueue에 먼지 좌표와 값 넣기
				if (map[rowIdx][colIdx] > 0) {
					dustQueue.offer(new Pos(rowIdx, colIdx, map[rowIdx][colIdx]));
				} else if (map[rowIdx][colIdx] == -1) { // 3. 공기청정기 좌표 cleaner 배열에 넣기
					cleaner.add(rowIdx);
				}
			}
		}

		antiSize = new int[4];
		antiSize[0] = cleaner.get(0);
		antiSize[1] = col-1;
		antiSize[2] = cleaner.get(0);
		antiSize[3] = col-1;

		norSize = new int[4];
		norSize[0] = row - cleaner.get(1)-1;
		norSize[1] = col-1;
		norSize[2] = row - cleaner.get(1)-1;
		norSize[3] = col-1;

		// turn 수만큼 반복
		for (int idx = 0; idx < turn; idx++) {
			dustBFS();
			antiRotate();
			norRotate();
			putQueue();
		}
		
		while(!dustQueue.isEmpty()) {
			Pos pos = dustQueue.poll();
			sum += pos.dust;
		}
		
		System.out.println(sum);
	}

	// 미세먼지 확산 bfs메서드
	static void dustBFS() {
		while (!dustQueue.isEmpty()) {
			Pos pos = dustQueue.poll();

			// 현재 좌표
			int x = pos.x;
			int y = pos.y;
			// 현재값
			int dust = pos.dust;

			// 뿌려줄 값
			int spread = dust / 5;

			// 몇 방향으로 뿌려졌는지
			int cnt = 0;

			// 상하좌우 탐색
			for (int idx = 0; idx < DELTA; idx++) {
				int nx = x + dx[idx];
				int ny = y + dy[idx];

				if (nx < 0 || ny < 0 || nx >= row || ny >= col || map[nx][ny] == -1)
					continue;
				map[nx][ny] += spread;
				cnt++;
			}

			// 자기 자리에서 없어질 미세먼지양
			map[x][y] -= spread * cnt;
		}
	}

	// antirotate 반시계 방향 메서드
	static void antiRotate() {
		int x = cleaner.get(0);
		int y = 0;

		// 반시계방향
		for (int idx = 0; idx < DELTA; idx++) {
			for (int move = 0; move < antiSize[idx]; move++) {
				int nx = x + antidx[idx];
				int ny = y + antidy[idx];
				
				if (map[nx][ny] == -1) {
					map[x][y] = 0;
					return;
				}
				
				map[x][y] = map[nx][ny];

				if (x == cleaner.get(0) && y == 0)
					map[x][y] = -1;
				
				x = nx;
				y = ny;
			}
		}

	}

	// norrotate 시계 방향 메서드
	static void norRotate() {
		int x = cleaner.get(1);
		int y = 0;

		// 시계방향
		for (int idx = 0; idx < DELTA; idx++) {
			for (int move = 0; move < norSize[idx]; move++) {
				int nx = x + nordx[idx];
				int ny = y + nordy[idx];
				
				if (map[nx][ny] == -1) {
					map[x][y] = 0;
					return;
				}

				map[x][y] = map[nx][ny];

				if (x == cleaner.get(1) && y == 0)
					map[x][y] = -1;
				
				x = nx;
				y = ny;
			}
		}
	}

	// 이차원배열 돌면서 큐에 먼지 넣는 메서드
	static void putQueue() {
		dustQueue = new ArrayDeque<>();

		for (int rowIdx = 0; rowIdx < row; rowIdx++) {
			for (int colIdx = 0; colIdx < col; colIdx++) {
				if (map[rowIdx][colIdx] > 0) {
					dustQueue.offer(new Pos(rowIdx, colIdx, map[rowIdx][colIdx]));
				}
			}
		}
	}

	// 먼지 좌표 객체
	static class Pos {
		int x, y, dust;

		public Pos(int x, int y, int dust) {
			this.x = x;
			this.y = y;
			this.dust = dust;
		}
	}
}
