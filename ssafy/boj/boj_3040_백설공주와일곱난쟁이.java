package boj;

/**
 * 조합으로 합이 100이 되는 난쟁이 7명을 찾는다. 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_3040_백설공주와일곱난쟁이 {
	static BufferedReader br;

	static int[] nums; // 숫자배열
	static int[] select = new int[7];

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		nums = new int[9];
		for (int idx = 0; idx < 9; idx++) {
			nums[idx] = Integer.parseInt(br.readLine().trim());
		}
		combination(0, 0);

	}

	// 조합
	// 선택 하거나 안하거나
	static void combination(int start, int depth) {
		if (depth == 7) {
			int sum = 0;
			for (int index = 0; index < 7; index++) {
				sum += select[index];
			}
			if (sum == 100) {
				for (int i = 0; i < 7; i++) {
					System.out.println(select[i]);
				}
			}
			return;
		}

		// 모든 경우의 수로 다 골랐으면
		if (start == 9) {
			return;
		}

		select[depth] = nums[start];
		combination(start + 1, depth + 1);

		select[depth] = 0;
		combination(start + 1, depth);

	}
}
