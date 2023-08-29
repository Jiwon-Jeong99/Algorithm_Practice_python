package boj;

/**
 * boj_15650 N과M2
 * 
 * 문제
 * 1. 조합
 * 
 * 문풀
 * 1. combination 메서드를 만들어서 중복없이 고르는 로직을 짠다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15650_N과M2 {
	static BufferedReader br;
	static StringTokenizer st;

	static int range; // 전체 수
	static int pick; // 뽑는 숫자 수
	static int[] nums; // range까지의 숫자를 담는 배열
	static int[] select; // 조합으로 뽑힌 배열

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());

		range = Integer.parseInt(st.nextToken());
		pick = Integer.parseInt(st.nextToken());

		nums = new int[range];
		select = new int[pick];

		// nums에 range까지 넣기
		for (int idx = 1; idx <= range; idx++) {
			nums[idx - 1] = idx;
		}

		combination(0, 0);
	}

	static void combination(int start, int depth) {
		if (depth == pick) {
			for (int index = 0; index < pick; index++) {
				System.out.print(select[index] + " ");
			}
			System.out.println();
			return;
		}

		if (start == range)
			return;

		// 원소 뽑기
		select[depth] = nums[start];
		combination(start + 1, depth + 1);
		// 원소 안뽑기
		select[depth] = 0;
		combination(start + 1, depth);
	}
}
