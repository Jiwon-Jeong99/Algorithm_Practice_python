package SWEA;

/**
 * swea_4013_특이한자석
 * 5초 256mb
 * 
 * 문제
 * 1. 4개의 자석, 8개의 날
 * 2. 날에는 S or N
 * 3. 1칸 회전할 때, 서로 붙어있는 날의 자성이 다를 경우에만 반대방향으로 1칸 회전
 * 4. 점수 획득 방식 (최종 빨간 화살표의 위치)
 * 		- N : 0점
 * 		- 1번 자석 S : 1점
 * 		- 2번 자석 S : 2점
 * 		- 3번 자석 S : 4점
 * 		- 4번 자석 S : 8점 
 * 5. 시계방향 1, 반시계방향 -1
 * 6. n극 0, s극 1
 * 7. 자성정보 : 빨간색 화살표 위치부터 시계방향
 * 
 *  input : 자성 정보, k번 회전
 *  output : k번 회전 후, 획득하는 점수의 총합
 * 
 * 문풀
 * 1. 
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4013_특이한자석 {
	static BufferedReader br;
	static StringTokenizer st;
	
	static int turn; //회전 횟수
	static int[][] magnetic; //자석 정보
	static int[] rotateInfo; //회전 정보
	
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		//테스트케이스 입력받기
		int testCase = Integer.parseInt(br.readLine().trim());
		for(int tc=1; tc<=testCase; tc++) {
			turn = Integer.parseInt(br.readLine().trim());
			
			magnetic = new int[4][8];
			
			//자석 정보 받기
			for(int idx=0; idx<4; idx++) {
				st = new StringTokenizer(br.readLine().trim());
				
				for(int saw=0; saw<8; saw++) {
					magnetic[idx][saw] = Integer.parseInt(st.nextToken());
				}
				
			}
			
			//turn 정보 받기
			for(int )
		}
	}
	
	//자석 회전 정보
	static class rotate{
		int num, way;
		rotate(int num, int way){
			this.num = num;
			this.way = way;
		}
	}
}
