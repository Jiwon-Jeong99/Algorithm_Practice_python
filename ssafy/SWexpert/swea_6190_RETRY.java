package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * swea_6190 정곤이의 단조 증가하는 수
 * 
 * @author SSAFY
 *
 *         조합 1. 테스트케이스 입력받기 2.
 */
public class swea_6190_RETRY {
	static BufferedReader br;
	static StringTokenizer st;

	static int size; // 수의 개수
	static int[] nums; // 수를 담은 배열
	static int[] multiple; // 조합으로 두 수를 곱한 수 중 단조증가인 수를 담은 배열

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= testCase; tc++) {
			size = Integer.parseInt(br.readLine().trim()); // 수의 개수 입력받기

			st = new StringTokenizer(br.readLine().trim());
			nums = new int[size];
			for (int idx = 0; idx < size; idx++) { // 배열에 수를 담기
				nums[idx] = Integer.parseInt(st.nextToken());
			}
			multiple = new int[size * (size + 1) / 2]; // 조합으로 두 수를 곱한 수 중 단조증가인 수를 담은 배열
			combination(0, 0);

			// 여기 이상함 다시 해야됨
			int answer = 1;
			for (int number = 0; number < size * (size + 1) / 2; number++) {
				String multiNum = Integer.toString(multiple[number]);
				for (int i = 0; i < multiNum.length() - 1; i++) {
					if (multiNum.charAt(i) <= multiNum.charAt(i + 1)) {
						answer = 1;
						continue;
					} else {
						answer = 0;
						break;
					}
				}
				if (answer == 1)
					System.out.print(multiNum);
			}
		}
	}

	// size중에서 2개를 고르는 조합 메서드
	public static void combination(int start, int depth) {
		int multiply = 1;
		int index = 0;
		if (depth == 2) { // 기저조건1) 조합 완료
			for (int num = 0; num < 2; num++) {
				multiply *= multiple[num];

			}
			multiple[index] = multiply; // multiple배열에 저장
			index++;
			return;
		}

		if (start == size) { // 기저조건2) 다 돌았음
			return;
		}

		// 원소 선택 시
		multiple[depth] = nums[start];
		combination(start + 1, depth + 1);

		// 원소 선택x 시
		multiple[depth] = 0;
		combination(start + 1, depth);
	}

}
