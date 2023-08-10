package 수열;

import java.util.Scanner;

/**
 * 중복조합 nHr
 * @author 정지원
 * 서로다른 n개 중 중복된 r개를 뽑는 경우의 수 
 *
 * 1. 재귀 이용
 * 2. 반복문의 시작 지점을 파라미터로 받아서 이전 인덱스 이후로 저장되도록 함
 */
public class CombinationWithRepetition {
	static int n,r;
	static int[] result; //n까지의 숫자 중 m개를 고른 배열
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		n = scan.nextInt();
		r = scan.nextInt();
		
		//초기화
		result = new int[r];
		
		//재귀 호출
		combination(0, 0);
	}
	
	private static void combination(int depth, int start) {//시작점 & 깊이 2가지를 파라미터로 담는다.
		//r개를 모두 선택했다면
		if(depth == r) {
			//출력
			for(int num:result) {
				System.out.print(num + " ");
			}
			System.out.println();
			return;
		}
		//반복문을 start부터 시작하여 순서대로 증가하며 도는 배열
		for(int i=start; i<n; i++) {
			result[depth] = i+1; //현재 위치에 숫자 선택
			combination(depth+1, i); //다음 위치로 이동(시작을 한번더 받아서 다음 숫자 들어갈 수 있도록)
		}
		
	}
}
