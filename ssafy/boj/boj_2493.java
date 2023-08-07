package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * boj_2493 탑
 * @author 정지원
 *
 *1. 탑을 스택에 하나씩 넣으면서 진행
 *2. 스택이 비어있다면 정답 배열에 0추가
 *3. if) 넣으려고 하는 탑 > 스택상단에 있는 탑 : 스택에 있는 탑 pop
 *		 넣으려고 하는 탑 < 스택상단에 있는 탑 : 스택에 있는 탑의 번호 정답 배열에 추가
 */

public class boj_2493 {
	static BufferedReader br;
	static StringTokenizer st;
	static int total; //탑 총 개수
	static Stack<Integer> towers; //탑의 높이를 담은 큐
	static int[] towersCnt; //탑 별 레이저 받은 탑 번호
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		
		total = Integer.parseInt(br.readLine().trim()); //탑 총 개수 입력
		
		towers = new Stack<Integer>();
		
		for(int idx=0; idx<total; idx++) { //탑의 높이 담은 배열 만들기
			int tower = Integer.parseInt(st.nextToken());
			
			if(towers.isEmpty()) {
				towers.add(tower);
				towersCnt[idx] = 0;
			} else if(towers.peek() > tower) {
				towers.add(tower);
				
			}
		}
	}
}
