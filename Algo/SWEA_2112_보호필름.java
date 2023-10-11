package SWEA;

/**
 * swea_2112 보호필름
 * 5초 256mb
 * 
 * 문제
 * 1. row : D, col : W 보호필름
 * 2. 각 층은 A or B 특성을 가지고 있다.
 * 3. 합격기준 : 모든 col이 동일한 특성의 셀들이 k개 이상 연속적으로 있는 경우
 * 4. 약품 : row에 A or B를 넣어 모든 row를 해당 문자로 변화시킴.
 * 5. 약품투입횟수를 최소로 하여 성능검사에 통과하도록
 * 
 * output : 약품 최소 투입횟수 / 약품 투입x 시 - 0
 * 
 * 문풀
 * - 특성 A - 0 / 특성  B - 1
 * - 조합 -> 1 ~ ++
 * 
 * 1. 초기 상태에서 모든 행을 다 조사 -> 연속된 특성 개수가 모두 success 이상이면 0 출력
 * 2. 검사할 때마다 배열 복사 (기존 값의 변형이 일어나지 않도록)
 * 3. 아니라면) 모든 열 선택 -> 열 하나당 0 or 1 전제 바꿔서 다시 확인
 * 
 * 만약 초기에 통과가 되면 answer = 0으로 바로 출력
 * 만약 초기 통과 안되면 통과될 때까지 조합으로 +1씩 하면서 조합 돌리기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2112_보호필름 {
	static BufferedReader br;
	static StringTokenizer st;
	
	static int row, col, success; //세로, 가로, 합격기준
	static int[][] map; //이차원배열 맵
	static int answer;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine().trim());
		
		//테스트케이스만큼 반복
		for(int tc=1; tc<=testCase; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			
			row = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());
			success = Integer.parseInt(st.nextToken());
			
			map = new int[row][col];
			
			//이차원배열 받기
			for(int rowIdx=0; rowIdx<row; rowIdx++) {
				st = new StringTokenizer(br.readLine().trim());
				
				for(int colIdx=0; colIdx<col; colIdx++) {
					map[rowIdx][colIdx] = Integer.parseInt(st.nextToken());
				}
			}
			
			int answer = 0;
			
			if(checkSuccess(map)) answer = 0;
			else {
				while(checkSuccess(map) != true) {
					answer++;
					combi(index, cnt, answer);
				}
			}
			
			System.out.println("#"+tc+" "+answer);
		}
	}
	
	//success 확인하는 메서드 - 이차원 배열 모두 탐방
	static boolean checkSuccess(int[][] map) {
		int ok = 0; //성공한 열의 개수
		for(int cIdx=0; cIdx<col; cIdx++) {
			int count = 0; //연속적인 값들의 수
			int temp = -1; //저장 값
			
			for(int rIdx=0; rIdx<row; rIdx++) {
				if(rIdx == 0) {
					temp = map[rIdx][cIdx];
					count++;
					continue;
				}
				if(temp == map[rIdx][cIdx]) count++;
				else count = 0;
				
				temp = map[rIdx][cIdx];

				if(count >= success) {
					ok++;
					break;
				}
			}
			//열의 ok개수가 인덱스+1 값과 일치하면 이제까지 success 통과한거니까 coninue
			if(ok == cIdx+1) continue;
			else return false; 
		}
		return true;
	}
	
	
}
