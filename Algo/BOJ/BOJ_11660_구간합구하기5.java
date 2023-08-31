package boj;

/**
 * boj_11660 구간합구하기5
 * 
 * 문제
 * 1. 인덱스 기준x, 숫자 기준
 * 2. 첫째줄 - 표의 크기 n, 구해야 하는 횟수 m
 * 	    둘째줄 ~n개줄 - 표에 대한 정보
 * 	   m개줄 - 좌표 (x1, y1), (x2, y2)
 * 3. (x1, y1) ~ (x2, y2) 까지의 합 구하기
 * ===============================================
 * 주의
 * - 최대 기준)nxn이 1024이고 구해야 하는 횟수가 100000이므로
 * 		    1024x100000 -> 이미 1억이 넘는다.
 * 따라서, 그냥 반복문으로 순회하면서 합을 구하면 안됨
 * => 누적합 
 * 
 * =>stringBuilder로 해야 더 빠름!!!
 * 
 * 문풀
 * 1. 이차원 배열 맵에 대한 입력 받기 (애초에 사이즈를 1 늘려서 받아 조건문 없어도 되게 하기)
 * 2. testCase만큼 반복해서 좌표 정보 입력 받기
 * 3. 해당 좌표 범위 안에 해당하는 점수 합하는 메서드 만들기
 * 		-> 각 줄마다 누적합 구해서
 * 		-> 가로 줄만 돌기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11660_구간합구하기5 {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;

	static int size; // 표의 크기
	static int testCase; // 구해야 하는 횟수
	static int[][] map; // 맵 이차원배열
	static int sum; // 합

	static int x1, y1, x2, y2; // 주어진 좌표

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		st = new StringTokenizer(br.readLine().trim());
		size = Integer.parseInt(st.nextToken());
		testCase = Integer.parseInt(st.nextToken());

		map = new int[size + 1][size + 1];

//		1. 이차원 배열 맵에 대한 입력 받기
		for (int sizeIdx = 1; sizeIdx <= size; sizeIdx++) {
			st = new StringTokenizer(br.readLine().trim());

			// 첫번째 인덱스 빼고는 전의 인덱스 요소를 합쳐서 저장할 것
			for (int col = 1; col <= size; col++) {
				map[sizeIdx][col] = Integer.parseInt(st.nextToken()) + map[sizeIdx][col - 1];
			}
		}

//		2. testCase만큼 반복해서 좌표 정보 입력 받기
		for (int tc = 0; tc < testCase; tc++) {
			st = new StringTokenizer(br.readLine().trim());

			sum = 0;

			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());

			search();

		}
		System.out.println(sb);
	}

//	 3. 해당 좌표 범위 안에 해당하는 점수 합하는 메서드 만들기
	static void search() {
		for (int rowIdx = x1; rowIdx <= x2; rowIdx++) {
			sum += (map[rowIdx][y2] - map[rowIdx][y1 - 1]);
		}
		sb.append(sum).append("\n");
	}
}
