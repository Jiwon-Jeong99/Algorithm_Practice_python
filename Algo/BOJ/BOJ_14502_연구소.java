package BOJ;
/**
 * boj_14502 연구소
 * => bfs, 조합, 완탐
 * => 맵 크기가 작기 때문에 완탐 완전 가능
 * 
 * 문제
 * 1. 지도의 가로height, 세로width길이 입력받기
 * 2. 빈칸 : 0, 벽 : 1, 바이러스 : 2
 * 3. 바이러스는 상하좌우로 퍼져나갈 수 있다. -> 0인 빈칸에 퍼짐
 * 4. 세울 벽의 개수는 3개. 무조건 세워야 한다.
 * 5. 바이러스가 퍼져나가지 않게 벽을 세워서
 * => 퍼진 후에 남은 0의 최대 개수를 구하라
 * 
 * 문풀 
 * 1. 이차원배열에 지도 정보를 받는다.
 * 2. 2차원 배열의 빈칸인 0에서 조합으로 3개를 골라 벽을 두고
 * 3. bfs로 빈칸인지 벽인지 탐색하면서 너비 우선탐색 
 * 4. 빈칸이면 바이러스인 2로 바꾸고
 * 5. 상하좌우가 다 1 혹은 2이면 탐색 종료
 * 6. 전체 0 개수 카운트
 * 7. 최댓값 업데이트
 * => 깊은 복사된 맵의 값을 이용해야 함. 원본 배열 그대로 이용하면 안됨.
 * 
 * [재선님 꿀팁]
 * 빈칸, 벽, 바이러스 0,1,2로 직접 때려박지 말고 static final 선언해줘라
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//좌표 클래스 - 좌표가 영어로 coordinate
class coordi {
	int height, width;
	
	public coordi(int height, int width) {
		this.height = height;
		this.width = width;
	}
}

public class BOJ_14502_연구소 {
	static BufferedReader br; 
	static StringTokenizer st;
	
	static int height, width; //맵의 가로, 세로
	static int[][] map; //맵
	static int[][] copy; //맵 복사본
	
	static int maxSafe = Integer.MIN_VALUE; //안전영역 최대값
	static int[] dx = {0,0,-1,1}; //상하좌우
	static int[] dy = {-1,1,0,0};
	static Queue<coordi> queue; //큐
	static List<coordi> virusList; //바이러스 좌표 담은 리스트
	
	static final int BLANK = 0, WALL = 1, VIRUS = 2; //상수처리
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine().trim());
		
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		
		//1. 이차원배열에 지도 정보를 받는다.
		map = new int[height][width];
		copy = new int[height][width];
		
		virusList = new ArrayList<>();
		
		for(int rowIdx=0; rowIdx<height; rowIdx++) {
			st = new StringTokenizer(br.readLine().trim());
			
			for(int colIdx=0; colIdx<width; colIdx++) {
				map[rowIdx][colIdx] = Integer.parseInt(st.nextToken());
				
				//바이러스 좌표 위치를 나중에 탐색하지말고 처음 이차원배열 입력할때 넣어주기
				if(map[rowIdx][colIdx] == VIRUS) {
					virusList.add(new coordi(rowIdx, colIdx));
				}
			}
		}
		
		combination(0);
		
		System.out.println(maxSafe);
	}
	
	
	//깊은복사 메서드 -> 따로 메서드 분리하기
	public static void deepCopy() {
		//배열 복사
		for(int rowIdx = 0; rowIdx<height; rowIdx++) {
			for(int colIdx=0; colIdx<width; colIdx++) {
				copy[rowIdx][colIdx] = map[rowIdx][colIdx];
				//바이러스 위치 큐에 집어넣기
//				if(copy[rowIdx][colIdx] == VIRUS) queue.offer(new coordi(rowIdx,colIdx));
			}
		}
	}
	
	//조합 메서드
	//2. 2차원 배열의 빈칸인 0에서 조합으로 3개를 골라 벽을 두고
	public static void combination(int depth) {
		//바이러스 좌표 리스트를 기반으로 queue 생성
//		queue = new ArrayDeque<>(virusList);
		queue = new ArrayDeque<>();
		if(depth == 3) {
			deepCopy();
			
			for(int idx=0; idx<virusList.size(); idx++) {
				queue.offer(virusList.get(idx));
			}
			
			//바이러스 퍼지게 하기
			bfs();
			return;
		}
		
        for(int i=0; i<height; i++) {
            for(int j=0; j<width; j++) {
                if(map[i][j] == BLANK) {
                	
                	//선택한거
                    map[i][j] = WALL;
                    
                    //선택하지 않음
                    combination(depth+1);
                    map[i][j] = BLANK;
                }
            }
        }
		
    }
	
	//bfs 메서드
	public static void bfs() {
		if(queue == null) {
			queue = new ArrayDeque<>();
		}
		
		while(!queue.isEmpty()) {
			coordi current = queue.poll();
			
			//상하좌우 탐색
			for(int idx=0; idx<4; idx++) {
				int nx = current.height + dx[idx];
				int ny = current.width + dy[idx];
				
				//바이러스 퍼뜨리기
				if(0>nx || nx>=height || 0>ny || ny>=width ||copy[nx][ny] != 0)
					continue;
				queue.add(new coordi(nx,ny));
				copy[nx][ny] = 2;
			}
		}
		countsafe();
	}
	
	//안전영역 확인 메서드
	public static void countsafe() {
		int safe = 0;
		for(int rowIdx=0; rowIdx<height; rowIdx++) {
			for(int colIdx=0; colIdx<width; colIdx++) {
				if(copy[rowIdx][colIdx] == BLANK) {
					safe++;
				}
			}
		}
		maxSafe = Math.max(maxSafe, safe);
	}
	
}

