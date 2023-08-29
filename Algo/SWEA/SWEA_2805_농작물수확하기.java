package swea;

/**
 * swea_2805 농작물 수확하기
 * 
 * 문제
 * 1. 농장의 크기는 항상 홀수
 * 2. 농장 크기에 딱맞는 정사각형 마름모 형태만 가능
 * 
 * 문풀
 * 1. 상반신(처음 ~ 맵의 사이즈만한 길이)
 * 2. 하반신(맵 사이즈만한 길이의 인덱스+1~끝)
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2805_농작물수확하기 {
	static BufferedReader br;

	static int size; // 농장 크기
	static int sum; // 농작물 가치 총합
	static int[][] map; // 농장 이차원배열

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= testCase; tc++) {
			sum = 0;
			size = Integer.parseInt(br.readLine().trim());

			map = new int[size][size]; // 농장 초기화
			// 농장 이차원 int 배열로 받기
			for (int idx = 0; idx < size; idx++) {
				String line[] = br.readLine().trim().split("");
				for (int index = 0; index < size; index++) {
					map[idx][index] = Integer.parseInt(line[index]);
				}
			}

			// 1. 상반신(처음 ~ 맵의 사이즈만한 길이)
			for (int bigIdx = 0; bigIdx <= (size / 2); bigIdx++) {
				for (int smallIdx = (size / 2) - bigIdx; smallIdx <= (size / 2) + bigIdx; smallIdx++) {
					sum += map[bigIdx][smallIdx];
				}
			}

			// 2. 하반신(맵 사이즈만한 길이의 인덱스+1~끝)
			for (int rowIdx = (size / 2) - 1, index = 1; rowIdx >= 0; rowIdx--) {
				for (int colIdx = (size / 2) - rowIdx; colIdx <= (size / 2) + rowIdx; colIdx++) {
					sum += map[(size / 2) + index][colIdx];
				}
				index++;
			}
			System.out.println("#" + tc + " " + sum);
		}
	}
}
