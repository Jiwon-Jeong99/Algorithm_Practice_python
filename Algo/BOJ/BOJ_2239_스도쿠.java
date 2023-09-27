package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * boj_2239 스도쿠
 * 2초 256mb
 * 완전탐색, dfs
 * 
 * @author 정지원
 * 
 * 문제
 *	1. 9x9크기 보드
 *	2. 1~9가 중복없이 각행, 각 열, 3x3 사각형을 이뤄야 한다.
 *	3. 답은 사전식으로 앞서는 것(가장 작은수)
 * ================================================
 *	input : 스도쿠 퍼즐
 *	output : 0을 다 수로 채운 스도쿠 (최소값)
 *	
 *	오답노트
 *	-> 겹치지 않는 숫자를 판별해서 넣으려고 하니까 고려해야 할 조건이 너무 많아짐
 *	-> 숫자가 크지 않으니 완전탐색으로 1~9를 다 넣어보는 걸로 
 *	(int로 받지 않고 char로 그대로 하면 더 빠른가?)
 *
 *	개념
 *	-> map[a][b] = 25 이런식으로 값으로 일차원배열처럼 한다면
 *	-> 행 : 25 / 너비, 열 : 25 % 너비
 *	-> 로 x,y 좌표값에 접근할 수 있다.
 *	+ 받는 input에 띄어쓰기 없으니까 char로 할것
 * 
 * 문풀
 *	1. 이차원배열로 맵의 정보를 받는다.
 *	2. 0의 좌표를 입력받는 zeroList 생성한다.
 *	3. dfs로 zeroList를 재귀로 순회하는 메서드를 만든다.
 *		-> 1~9를 순회하면서
 *		-> 행, 열, 3x3을 보면서 해당 숫자와 겹치는 숫자는 없는지 확인
 *		-> 재귀 depth가 zeroList.size()이 되면 flag = true가 되고, flag = true면 탈출
 *	4. 이차원배열 순회 다 했으면, 9개씩 끊어서 출력
 * 
 */

public class BOJ_2239_스도쿠 {
	static BufferedReader br;
	static StringBuilder sb;

	static int[][] map; //map의 이차원배열
	static List<zeroPos> zeroList; //0의 좌표를 담은 리스트
	static int length; //zeroList의 길이
	static boolean flag; //dfs 탈출 및 결과 알려주는 flag값

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		map = new int[9][9];
		
		zeroList = new ArrayList<>();

		//1. 이차원배열로 맵의 정보를 받는다.
		for (int rowIdx = 0; rowIdx < 9; rowIdx++) {
			
			String input = br.readLine();
			
			for (int colIdx = 0; colIdx < 9; colIdx++) {
				map[rowIdx][colIdx] = input.charAt(colIdx) - '0';

				//0의 좌표를 저장하는 리스트
				if (map[rowIdx][colIdx] == 0) {
					zeroList.add(new zeroPos(rowIdx, colIdx));
				}
			}
		}

		length = zeroList.size();
		dfs(0);

		sb = new StringBuilder();
		
		//4. 이차원배열 순회 다 했으면, 9개씩 끊어서 출력
		for(int row=0; row<9; row++) {
			for(int col=0; col<9; col++) {
				sb.append(map[row][col]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

	//3. dfs로 zeroList를 재귀로 순회하는 메서드를 만든다.
	public static void dfs(int depth) {

		//-> 재귀 depth가 length가 되면 flag = true가 되고, flag = true면 탈출
		if (depth == length) {
			flag = true;
			return;
		}
		
		//이차원배열을 일차원배열처럼 접근
		int row = zeroList.get(depth).row;
		int col = zeroList.get(depth).col;

		//-> 1~9를 순회하면서
		for (int index = 1; index <= 9; index++) {
			//중복되는 숫자가 이미 존재한다면
			if (!isPossible(row, col, index))
				continue;

			//중복되는 숫자 없이 괜찮다면
			map[row][col] = index;

			dfs(depth + 1);
			if (flag)
				return;
			map[row][col] = 0;
		}
	}

	//-> 행, 열, 3x3을 보면서 해당 숫자와 겹치는 숫자는 없는지 확인
	//num은 해당자리에 입력할 숫자
	public static boolean isPossible(int row, int col, int num) {

		//행, 열
		for (int index = 0; index < 9; index++) {
			if (map[row][index] == num || map[index][col] == num)
				return false;
		}

		//3x3
		//0,1,2 / 3,4,5 / 6,7,8
		//행,열 : col / 3 * 3 -> 좌상단 좌표가 나옴
		int checkRow = row / 3 * 3;
		int checkCol = col / 3 * 3;
		
		for (int rowIdx = checkRow; rowIdx < checkRow + 3; rowIdx++) {
			for(int colIdx = checkCol; colIdx < checkCol + 3; colIdx++) {
				if(num == map[rowIdx][colIdx]) return false;
			}
		}
		
		return true;
	}

	//좌표  class
	public static class zeroPos {
		int row;
		int col;

		public zeroPos(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
