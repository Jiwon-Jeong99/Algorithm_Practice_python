package exercise;
/**
 * boj_15649 N과M
 * @author 정지원
 * 
 * 순열 문제
 * arr : 선택할 수 있는 수가 담긴 배열
 * out : 선택한 원소를 순서대로 저장할 배열
 * visitied : 중복은 안되니까 이미 선택한 원소 다시 선택하지 않도록
 * r : 몇개 골라야 하는지
 *
 */
import java.util.Scanner;

public class boj_15649 {
	//순열 함수
	public static void permutation(int[] arr, int[] out, boolean[] visited, int depth, int r) {
		if(depth == r) {
			for(int num: out) System.out.print(num + " ");
			System.out.println();
			return;
		}
		for(int idx=0; idx<arr.length; idx++) {
			if(!visited[idx]) {
				visited[idx] = true;
				out[depth] = arr[idx];
				permutation(arr, out, visited, depth+1, r);
				visited[idx] = false;
			}
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int total = scan.nextInt();
		int choose = scan.nextInt();
		
		// arr: 선택할 수 있는 수가 담긴 배열
		int[] nums = new int[total];
		for(int num = 0; num<total; num++) {
			nums[num] = num+1;
		}
		permutation(nums, new int[choose], new boolean[total], 0, choose);
	}
}
