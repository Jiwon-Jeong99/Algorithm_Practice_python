import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * swea_5656 벽돌깨기
 * @author 정지원
 * 3초 256mb
 * 
 * 문제
 * 1. wxh배열 - 0:빈공간, 벽돌:숫자
 * 2. 구슬은 항상 맨 위에 있는 벽돌만 깨트림
 * 3. 벽돌 숫자 1~9, 상하좌우로 (벽돌에 적힌 숫자 -1)만큼 같이 제거
 * 4. 제거될 때 건드린 벽돌의 숫자가 있으면 그만큼 또 제거됨
 * 
 * 문풀
 * 1. col 길이만큼 중복순열로 circle만큼 픽하기 
 * 2. 중간 벽돌들이 깨졌을 때, 만약 하 방향을 탐색해서 0이면 0->(해당 숫자)로 바꿈 
 * 3. 연쇄로 벽돌이 깨지는 함수 (숫자 -> 0으로)
 * 4. 전체 벽돌개수 세는 함수(0이 아닌 숫자의 개수 세기)
 * 
 */

public class SWEA_5656_벽돌깨기 {
	static BufferedReader br;
	static StringTokenizer st;
	
	static int circle, row, col; //구슬개수,가로,세로
	static int[][] map; //이차원배열 맵
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine().trim());
		
		//테스트케이스만큼 반복
		for(int tc=1; tc<=testCase; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			
			circle = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());
			row = Integer.parseInt(st.nextToken());
			
			map = new int[row][col];
			
			//이차원 배열 맵 입력받기
			for(int rIdx=0; rIdx<row; rIdx++) {
				st = new StringTokenizer(br.readLine().trim());
				
				for (int cIdx=0; cIdx<col; cIdx++) {
					map[rIdx][cIdx] = Integer.parseInt(st.nextToken());
				}
			}
			
			
		}
	}
}
