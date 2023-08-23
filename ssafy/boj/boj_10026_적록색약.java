package boj;

/**
 * boj_10026 적록색약
 * 
 * 1. 일반인일 경우) 시작하는 좌표의 문자와 같은 문자일때만 그룹으로 치고 카운트한다.
 * 2. 적록색약일 경우) numR과 numG는 같다고 가정하고 푼다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_10026_적록색약 {
	static BufferedReader br;
	static StringBuilder sb;

	static int numR = 'R' - 'A';
	static int numG = 'G' - 'A';
	static int[][] map;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		System.out.println(numR);
		int num = Integer.parseInt(br.readLine().trim());

		// 이차원 배열 만들기
		for (int tc = 0; tc < num; tc++) {
			char[] line = br.readLine().trim().toCharArray();
			for (int idx = 0; idx < num; idx++) {
				map[tc][idx] = line[idx] - 'A'; // 숫자로 집어넣자
			}
		}

	}
}
