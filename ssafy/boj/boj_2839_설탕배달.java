package boj;

import java.io.BufferedReader;
/**
 * boj_2839 설탕배달
 * 
 * DP
 * 3의 배수부터 확인해서 max값을 채워나간다.
 * 만약 5로 나눈 몫이 3의배수가 아니라면 몫에서 1을 빼고 다시 한다.
 * 만약 3으로만 나눠도 되지 않을때는 -1 출력
 */
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2839_설탕배달 {
	static BufferedReader br;

	static int total;
	static int min = Integer.MAX_VALUE;
	static int three;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		total = Integer.parseInt(br.readLine().trim());
		int temp = total;
		// 최대가 될 가방개수부터 먼저 센다.
		if (total % 3 == 0) {
			min = total / 3; // 3의 배수면 일단 min에 저장
		}
		int maxFive = total / 5;

		for (int idx = 1; idx <= maxFive; idx++) {
			total = temp;
			total -= 5 * idx;
			if (total % 3 != 0) {
				continue;
			}
			three = total / 3;
			min = Math.min(min, idx + three);
		}
		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}
		System.out.println(min);
	}
}
