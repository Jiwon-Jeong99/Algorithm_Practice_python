package boj;

/**
 * boj_16435 스네이크버드
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_16435_스네이크버드 {
	static BufferedReader br;
	static StringTokenizer st;

	static int total; // 과일 개수
	static int initial; // 스네이크버드 초기 길이
	static int[] fruits; // 과일들 배열

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());

		total = Integer.parseInt(st.nextToken());
		initial = Integer.parseInt(st.nextToken());

		fruits = new int[total];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < total; i++) {
			fruits[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(fruits);

		for (int idx = 0; idx < total; idx++) {
			if (fruits[idx] <= initial) {
				initial++;
			}

		}
		System.out.println(initial);
	}
}