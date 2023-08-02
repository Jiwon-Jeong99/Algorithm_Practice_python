package exercise;
/**
 * boj_11659 구간합구하기4
 * @author 정지원
 * 
 * 1. 수의 개수 N, 횟수 M을 입력받기
 * 2. N개의 숫자 입력받기
 * 3. M만큼 반복하며, 구간 i와 j 입력받기
 * 4. 배열을 순회하면서 합계를 구하면 100억 정도로 시간초과가 나기 때문에(시간초과 나봤음)
 * 	4-1. 첫번째 인덱스부터 해당 인덱스까지 합을 넣은 누적합 배열을 만들어
 * 	4-2. j에 해당하는 배열값에서 i에 해당하는 배열값을 빼면 i~j까지의 합계를 구할 수 있다.
 */
import java.util.Scanner;

public class boj_11659 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();//수의 개수 N 입력받기
		int M = scan.nextInt();//횟수 M 입력받기
		
		int[] nums = new int[N+1];//N개의 숫자를 입력받을 int 배열 생성
		for(int idx=1; idx<=N; idx++) {//전 인덱스의 값과 입력받은 값을 더한 누적합배열 생성
			nums[idx] = nums[idx-1] + scan.nextInt();
		}
		
		for(int m=0; m<M; m++) {//M만큼 반복하며 i,j 값 입력받기
			int i = scan.nextInt();//i 입력받기
			int j = scan.nextInt();//j 입력받기
			
			int answer = nums[j] - nums[i-1];//j인덱스-(i-1)인덱스로 구간합 구하기
			
			System.out.println(answer);
		}
		scan.close();
	}
}
