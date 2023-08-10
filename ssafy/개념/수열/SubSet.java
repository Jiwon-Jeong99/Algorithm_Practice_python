package 수열;

import java.util.Scanner;

/**
 * 부분집합
 * @author 정지원
 *
 * 각 원소를 고르거나 고르지 않거나(nC1, nC2,...)
 */
public class SubSet {
	static int n; //1~n까지의 수
	static boolean[] visited; //방문체크를 위한 배열
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		n = scan.nextInt();
		visited = new boolean[n];
		subset(0);
	}
	
	private static void subset(int num) {
		if(num == n) { //기저 조건, 부분집합 완
			for(int i=0; i<n; i++) {
				if(visited[i]) System.out.println((i+1)+" ");
			}
			System.out.println();
			return;
		}
		visited[num] = true; //방문체크하면
		subset(num+1); //부분집합에 포함한다는 visited에 추가하고 재귀
		visited[num] = false; //방문해제
		subset(num+1); //현재 숫자를 부분집합에 포함x 재귀
	}
}
