package exercise;

import java.util.Scanner;

/**
 * boj_2961 도영이가 만든 맛있는 음식
 * @author 정지원
 *
 *부분집합 - 주어진 재료 중에 신맛과 쓴맛 차이가 가장 적게 나는 요리를 만들 수 있는 요리 개수를 선택해야 하므로
 *
 *1. 요리 개수 N 입력받기
 *2. 요리 개수만큼 반복문 돌려서 신맛, 쓴맛 입력받기
 *3. 이차원 배열에 요리의 신맛과 쓴맛을 넣기
 *4. 부분집합 재귀로 부분집합 중 신맛과 쓴맛의 차(절댓값)가 최소인 경우를 찾아 차이를 출력
 */
public class boj_2961 {
	static int N;
	static int sour;
	static int bitter;
	static int[][] totalTaste;
	static boolean[] isSelected;
	static Integer min; //최소 차이를 저장하기 위한 변수
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt(); //재료 개수
		isSelected = new boolean[N];
		
		totalTaste = new int[N][2];
		for(int idx=0; idx<N; idx++) { //재료 개수만큼 반복
			sour = scan.nextInt(); //신맛
			bitter = scan.nextInt(); //쓴맛
			
			//이차원 배열에 각각 값넣기
			totalTaste[idx][0] = sour; 
			totalTaste[idx][1] = bitter;
		}
		
		min = Integer.MAX_VALUE; //long의 최대 길이를 구한 수를 넣음
		generateSubset(0);// 시작할 원소의 인덱스
		System.out.println(min);
	}
	
	//재귀로 부분집합 구현
	private static void generateSubset(int cnt) { //cnt: 현재 처리할 원소의 인덱스 
		boolean isZero = false;// 1개 이상을 선택해야 하므로
		
		if(cnt == N) {// 원소 개수와 같으면 부분집합 완성
			int sourSum = 1; //신맛 총합
			int bitterSum = 0; //쓴맛 총합
			
			for(int i=0; i<N; i++) {	
				if(isSelected[i]) {//선택되면
					sourSum *= totalTaste[i][0]; // 신맛 곱하기
					bitterSum += totalTaste[i][1];// 쓴맛 더하기
					isZero = true; 
				}
			}
				if(!isZero) return; //음식을 최소 1개 이상 선택해야 하므로
				int differ = Math.abs(sourSum - bitterSum);//신맛과 쓴맛의 차
				min = Math.min(min, differ);//신맛과 쓴맛의 최소차
				return;
			
		}
		isSelected[cnt] = true; //선택
		generateSubset(cnt+1);
		isSelected[cnt] = false; //비선택
		generateSubset(cnt+1);
	}
}
