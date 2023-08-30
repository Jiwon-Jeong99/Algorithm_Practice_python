package boj;

/**
 * boj_11659 구간합구하기4
 * 
 * 문제
 * 1. 숫자가 주어진다
 * 2. i~j까지의 합을 구하라
 * 3. 인덱스+1 구간이 주어졌을때 해당 구간의 합을 구하라
 * 
 * 문풀 - 누적합 방식
 * 그냥 반복문 돌리면 시간초과나옴
 * 숫자 배열을 먼저 받고 누적합 배열을 만드는 것도 시간 초과 나옴
 * 1. int 배열에 이제까지 배열에 저장된 요소들의 누적합을 저장한다.
 * 2. 끝 인덱스에 해당하는 누적합에서 시작 인덱스 -1를 빼면 해당 구간 합이 나온다.
 * 
 * 시간 절약을 위한 다른 코드
 * => 메서드 나누기
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11659_구간합구하기4 {
	static BufferedReader br;
	static StringTokenizer st;

	static int size; // 숫자가 몇갠지
	static int repeat; // 몇번 합을 구해야 하는지
	static int[] nums; // 숫자 배열
	static int sum; // 합

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine().trim());
		size = Integer.parseInt(st.nextToken());
		repeat = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine().trim());

		nums = new int[size];

		// 누적합 숫자 배열
		for (int idx = 0; idx < size; idx++) {
			if (idx == 0)
				nums[idx] = Integer.parseInt(st.nextToken());
			else
				nums[idx] = Integer.parseInt(st.nextToken()) + nums[idx - 1];
		}

		for (int tc = 0; tc < repeat; tc++) {
			sum = 0;

			st = new StringTokenizer(br.readLine().trim());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			if (start == 1) {
				sum = nums[end - 1];
			} else {
				sum = nums[end - 1] - nums[start - 2];
			}

//			2. 끝 인덱스에 해당하는 누적합에서 시작 인덱스 -1를 빼면 해당 구간 합이 나온다.
			System.out.println(sum);
		}
	}
}
