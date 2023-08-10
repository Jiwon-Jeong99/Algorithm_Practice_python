package 수열;

import java.util.Scanner;

/**
 * 순열 nPr
 * @author 정지원
 * 1부터 n까지 자연수 중에서 중복 없이 m개를 고른 수열
 *
 * 1. 재귀를 이용해 출력
 * 2. 중복 허용x -> 중복 방지 체크 배열을 만들어 중복 방지
 * 
 * 필요 요소
 * 1. n,r 입력
 * 2. n까지의 숫자 중 m개를 고른 배열 result
 * 3. 중복 방지를 위한 방문 체크 배열 visited
 */

//n과 r을 입력해야 하는 ver. 
public class Permutation1 {
	static int n,r;
	static int[] result; //n까지의 숫자 중 m개를 고른 배열
	static boolean[] visited; //중복 방지를 위한 방문 체크 배열
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		n = scan.nextInt();
		r = scan.nextInt();
		
		//초기화
		result = new int[r];
		visited = new boolean[n];
		
		//재귀 호출
		permutation(0);
	}
	
	private static void permutation(int depth) {
		//r개를 모두 선택했다면
		if(depth == r) {
			//출력
			for(int num:result) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
		else {
			for(int num=0; num<n; num++) {
				//방문하지 않은 경우만 방문
				if(!visited[num]) {
					visited[num] = true; //방문처리
					result[depth] = num + 1; //순열 배열에 저장 - 인덱스가 0부터 시작이니까 +1
					permutation(depth+1); //재귀 호출
					visited[num] = false; //방문 해제
				}
			}
		}
	}
}
