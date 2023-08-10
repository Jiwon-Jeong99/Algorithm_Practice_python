package 수열;

import java.util.Scanner;

/**
 * 중복순열 nㅠr
 * @author 정지원
 * 서로다른 n개의 수를 중복을 허락해서 r개를 선택하여 일렬로 나열하는 경우의 수 
 *
 * 1. 순열 코드에서 visited를 빼서 중복 검사를 하지 않은 ver.
 */
public class PermutationWithRepetition {
	static int n,r;
	static int[] result; //n까지의 숫자 중 m개를 고른 배열
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		n = scan.nextInt();
		r = scan.nextInt();
		
		//초기화
		result = new int[r];
		
		//재귀 호출
		repeatPermutation(0);
	}
	
	private static void repeatPermutation(int depth) {
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
				result[depth] = num + 1; //순열 배열에 저장 - 인덱스가 0부터 시작이니까 +1
				repeatPermutation(depth+1); //재귀 호출
			}
		}
	}
}
