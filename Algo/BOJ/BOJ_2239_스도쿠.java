package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;
/**
 * boj_2239 스도쿠
 * 2초 256mb
 * @author 정지원
 * 
 * 문제
 *	1. 9x9크기 보드
 *	2. 1~9가 중복없이 각행, 각 열, 3x3 사각형을 이뤄야 한다.
 *	3. 답은 사전식으로 앞서는 것(가장 작은수)
 * ================================================
 *	input : 스도쿠 퍼즐
 *	output : 0을 다 수로 채운 스도쿠 (최소값)
 *	문풀
 *	1. 9x9 스도쿠 퍼즐을 입력받는다.
 *	2. 0이 위치한 좌표를 입력받을 class 생성
 *	3. 0의 좌표를 저장하는 리스트를 만든다.
 *	4. 스도쿠 정답을 저장하는 스택을 만든다.
 *	5. 각 행을 돌면서 해당 행에 없는 숫자가 있으면 리스트에 저장
 *	6. 3x3에 있는 숫자와 비교
 *	7. 행에 있는 숫자와 비교
 *	
 */

public class BOJ_2239_스도쿠 {
	static BufferedReader br;
	static StringTokenizer st;
	
	static int[][] map; //이차원 배열 맵
	static int[] fullNum = {1,2,3,4,5,6,7,8,9}; //스도쿠 모든 숫자 배열
	static List<zeroPos> zeroList; //0의 좌표 저장
	static Stack<Integer> sudoku; //완성된 스도쿠
	
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[9][9];
		
		//3. 0의 좌표를 저장하는 리스트를 만든다.
		zeroList = new ArrayList<>();
		
		//4. 스도쿠 정답을 저장하는 스택을 만든다.
		sudoku = new Stack<>();
		
		//1. 9x9 스도쿠 퍼즐을 입력받는다.
		for(int rowIdx=0; rowIdx<9; rowIdx++) {
			st = new StringTokenizer(br.readLine().trim());
			
			for(int colIdx=0; colIdx<9; colIdx++) {
				map[rowIdx][colIdx] = Integer.parseInt(st.nextToken());
			
				//5. 각 행을 돌면서 해당 행에 없는 숫자가 있으면 리스트에 저장
				if(map[rowIdx][colIdx] == 0) {
					zeroList.add(new zeroPos (rowIdx, colIdx));
				}
			}
		}
		
		//5. 각 행을 돌면서 해당 행에 없는 숫자가 있으면 리스트에 저장
		for(int row=0; row<9; row++) {
			for(int col=0; col<9; col++) {
				if(map[row][col] != 0) sudoku.add(map[row][col]);
				else return;
			}
			
		}
		
	}
	
	//6. 3x3에 있는 숫자와 비교
	public static  void checkSquare() {
		if()
	}
	
	//7. 행에 있는 숫자와 비교
	public static void checkCol() {
		
	}
	
	//2. 0이 위치한 좌표를 입력받을 class 생성
	public static class zeroPos {
		public int x,y;
		
		public zeroPos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
