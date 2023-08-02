package exercise;
/**
 * boj_11659 구간합구하기4
 * @author 정지원
 * 
 * 1. 수의 개수 N, 횟수 M을 입력받기
 * 2. N개의 숫자 입력받기
 * 3. M만큼 반복하며, 구간 i와 j 입력받기
 * 4. i와 j는 실제 순서이기 때문에 -1을 해주어야 실제 배열에 들어있는 인덱스 값이 된다.
 * 5. 조정된 인덱스를 순회하며 합계 도출
 */
import java.util.Scanner;

public class boj_11659 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();//수의 개수 N 입력받기
		int M = scan.nextInt();//횟수 M 입력받기
		
		int[] nums = new int[N];//N개의 숫자를 입력받을 int 배열 생성
		for(int idx=0; idx<N; idx++) {//int 배열에 값 넣기
			nums[idx] = scan.nextInt();
		}
		
		for(int m=0; m<M; m++) {//M만큼 반복하며 i,j 값 입력받기
			int i = scan.nextInt();//i 입력받기
			int j = scan.nextInt();//j 입력받기
			
			int sum = 0;//i~j까지의 합
			for(int cnt=i-1; cnt<=j-1; cnt++) {//nums 배열의 인덱스를 i-1~j-1까지 순회하며 sum에 더하기
				sum += nums[cnt];
			}
			
			System.out.println(sum);
		}
		scan.close();
	}
}
