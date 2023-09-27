package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * boj_3055 탈출
 * 1초 128mb
 * 
 * bfs, 백트래킹
 * 
 * @author 정지원
 * 
 * 문제
 * 1. 티떱숲의 맵 R행 C열
 * 2. 빈 곳 : . , 물이 차있는 곳 : * , 돌 : X
 * 3. 비버 굴 : D, 고슴도치 위치 : S
 * 4. 매분 마다 고슴도치는 상하좌우 이동 가능
 * 5. 		  물도 비어있는 칸으로 이동
 * 6. 물과 고슴도치는 돌을 통과할 수 없다.
 * 7. 고슴도치는 물이 차있는 구역으로 이동x
 * 	    물이 찰 예정인 칸으로 이동x
 * 8. 물도 비버의 소굴로 이동x
 * => 지도가 주어질 때) 고슴도치가 안전하게 비버의 굴로 이동하기 위해 필요한 최소시간을 구하라.
 * 
 * input) 띠덮숲 이차원 배열 맵
 * output) 
 * - 고슴도치가 비버의 굴로 이동할 수 있는 가장 빠른 시간 (S -> D)
 * - 비버의 굴로 이동 불가능 : KAKTUS
 * ========================================
 * 문풀
 * 1. 행과 열을 입력받는다.
 * 2. 2차원 맵에 char들을 int로 바꿔서 넣는다.
 * 3. 고슴도치와 비버굴의 좌표를 이차원 배열 정보 받을 때 같이 받아놓는다.
 * 
 */
public class BOJ_3055_탈출 {
	static BufferedReader br;
	static StringTokenizer st;
	
	static int row, col; //맵의 행, 열 
	static int[][] map; //띠덮숲 이차원 배열 맵
	static int min; //최소시간
	
	static int[] dx = {0, 0, -1, 1}; //상하좌우
	static int[] dy= {-1, 1, 0, 0};
	
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine().trim());
		
		//1. 행과 열을 입력받는다.
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		map = new int[row][col];
		
		//2. 2차원 맵에 char들을 int로 바꿔서 넣는다.
		for(int rowIdx=0; rowIdx<row; rowIdx++) {
			String input = br.readLine().trim();
			
			for(int colIdx=0; colIdx<col; colIdx++) {
				map[rowIdx][colIdx] = input.charAt(colIdx) - 'A';
				
				//3. 고슴도치와 비버굴의 좌표를 이차원 배열 정보 받을 때 같이 받아놓는다.
				if(map[rowIdx][colIdx] == 18) new hedgehog(rowIdx, colIdx);
				else if(map[rowIdx][colIdx] == 3) new beaver(rowIdx, colIdx);
				
			}

		}
			
	}
	
	//bfs(상하좌우 search)
	public static void bfs() {
		
	}
	
	//고슴도치 좌표
	public static class hedgehog {
		int row, col;

		public hedgehog(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	//비버굴 좌표
	public static class beaver {
		int row, col;
		
		public beaver(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
