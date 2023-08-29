package boj;

/**
 * boj_1244 스위키켜고끄기
 * 
 * 문제
 * 1. 1 - 스위치 on / 0 - 스위치 off
 * 2. 남학생-받은 수의 배수 / 여학생-받은 수의 양옆이 대칭이면 해당 범위를 받은 수 포함해서 전체 다 바꿈
 * 3. 마지막 스위치의 상태 출력
 * 4. 한 줄에 20개씩만 출력
 * 5. 스위치 사이 빈칸 하나씩
 * 
 * 문풀
 * 1. 스위치를 int 배열 안에 넣는다.
 * 2. 학생수만큼 반복
 * 3. 남학생 메서드 - 받은 수의 배수 스위치를 모두 바꾼다.를 만든다.
 * 4. 여학생 메서드 - 양옆 인덱스를 탐색하면서 대칭이면 해당 범위의 수를 모두 바꾼다.
 * 5. 스위치 출력 - 20개씩 끊어서
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1244_스위치켜고끄기 {
	static BufferedReader br;
	static StringTokenizer st;

	static int size; // 스위치 개수
	static int[] switches; // 스위치 배열

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		size = Integer.parseInt(br.readLine().trim());
		switches = new int[size + 1]; // 스위치 번호는 1부터 시작
		st = new StringTokenizer(br.readLine().trim());
//		1. 스위치를 int 배열 안에 넣는다.
		for (int idx = 1; idx <= size; idx++) {
			switches[idx] = Integer.parseInt(st.nextToken());
		}

//		2. 학생수만큼 반복
		int testCase = Integer.parseInt(br.readLine().trim());
		for (int tc = 0; tc < testCase; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			int sex = Integer.parseInt(st.nextToken()); // 성별
			int num = Integer.parseInt(st.nextToken()); // 주어진 숫자
			if (sex == 1)
				boy(num);
			else if (sex == 2)
				girl(num);
		}

//		5. 스위치 출력 - 20개씩 끊어서
		for (int index = 1; index <= size; index++) {
			if (index % 20 == 1 && index != 1)
				System.out.println();
			System.out.print(switches[index] + " ");
		}
	}

//	3. 남학생 메서드 - 받은 수의 배수 스위치를 모두 바꾼다.를 만든다.
	static void boy(int num) {
		for (int boyIdx = num; boyIdx <= size; boyIdx += num) {
			switches[boyIdx] = 1 - switches[boyIdx];
		}
	}

//	4. 여학생 메서드 - 양옆 인덱스를 탐색하면서 대칭이면 해당 범위의 수를 모두 바꾼다.
	static void girl(int num) {
		int min = Math.min(size - num + 1, num); // 1~num, num~끝까지 중에서 더 작은 범위 골라서 반복 돌기
		for (int idx = 0; idx < min; idx++) {
			if (idx == 0) // 자기자신을 무조건 바꾸기
				switches[num] = 1 - switches[num];
			else if (idx != 0 && switches[num - idx] == switches[num + idx]) {// 대칭이면 스위치 변경
				switches[num - idx] = switches[num + idx] = 1 - switches[num - idx];
			} else // 동일하지 않다면 탈출
				break;
		}
	}
}
