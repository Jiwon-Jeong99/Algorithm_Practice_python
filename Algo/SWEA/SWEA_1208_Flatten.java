package swea;

/**
 * swea_1208 Flatten
 * 
 * 문제
 * => 최고점 - 최저점 반환
 * 1. 가장 높은 곳 -> 가장 낮은 곳 옮기기 (덤프)
 * 2. 가로길이는 100으로 고정
 * 3. 주어진 덤프 횟수 내에 평탄화가 완료되면 더이상 덤프 수행 x, 최고점 - 최저점 반환
 * 4. 총 10개의 테스트케이스
 * 
 * 문풀
 * 1. 상자의 높이를 int배열로 받는다.
 * 2. 오름차순으로 상자 높이를 정렬한다.
 * 3. 마지막 인덱스(가장 높은)와 가장 첫 인덱스(가장 낮은)간의 덤프를 진행한다.
 * 4. 오름차순으로 상자 높이를 재정렬한다.
 * 5. 덤프 제한 횟수만큼 
 * 6. 만약 최고점과 최저점의 차이가 1 or 0이면 중간에 break;
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1208_Flatten {
	static BufferedReader br;
	static StringTokenizer st;

	static int total; // 총 덤프횟수
	static int[] boxes = new int[100]; // 박스의 높이값 배열

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			total = Integer.parseInt(br.readLine().trim());
//			1. 상자의 높이를 int배열로 받는다.
			st = new StringTokenizer(br.readLine().trim());
			for (int idx = 0; idx < 100; idx++) {
				boxes[idx] = Integer.parseInt(st.nextToken());
			}
//			2. 오름차순으로 상자 높이를 정렬한다.
			Arrays.sort(boxes);

//			5. 덤프 제한 횟수만큼 
			for (int index = 0; index < total; index++) {
//				6. 만약 최고점과 최저점의 차이가 1 or 0이면 중간에 break;
				if (boxes[99] - boxes[0] <= 1)
					break;
				dump();
			}

			int answer = boxes[99] - boxes[0];
			System.out.println("#" + tc + " " + answer);
		}
	}

	// 덤프 메서드
	static void dump() {
//		3. 마지막 인덱스(가장 높은)와 가장 첫 인덱스(가장 낮은)간의 덤프를 진행한다.
		boxes[99]--;
		boxes[0]++;
//		4. 오름차순으로 상자 높이를 재정렬한다.
		Arrays.sort(boxes);
	}
}
