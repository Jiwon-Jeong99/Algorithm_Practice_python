package swea;

import java.io.BufferedReader;
/**
 * swea_1215 암호생성기
 * 
 * 1. ArrayDeque를 만들어 입력받은 8개의 숫자를 넣고
 * 2. 앞 요소를 빼서 사이클에 맞게 뺀 후에 큐의 뒤에 다시 추가해준다.
 * 3. 이때 요소를 사이클에 맞게 뺐을 때, 0이하이면 break하고 탈출한다.
 * 4. 그리고 사이클이 5까지 감소하는 거기 때문에 5가 되면 다시 1부터 시작하게 세팅해준다.
 */
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class swea_1225 {
	static BufferedReader br;
	static StringTokenizer st;

	static ArrayDeque<Integer> deque = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) { // 10번 반복하기
			br.readLine();
			st = new StringTokenizer(br.readLine().trim());

			for (int idx = 0; idx < 8; idx++) { // deque에 8개 숫자 집어넣기
				deque.offerLast(Integer.parseInt(st.nextToken()));
			}

			int cnt = 1;
			while (true) { // 사이클에 따른 요소가 0이하가 되기 전까지 반복
				int temp = deque.poll();
				int alpha = temp - cnt;
				if (alpha <= 0) { // 0이하가 되면 0으로 치고, 탈출
					alpha = 0;
					deque.offerLast(alpha);
					break;
				}
				deque.offerLast(alpha);
				if (cnt == 5) // 사이클인 5가 되면 0으로 초기화해서 1부터 시작할 수 있도록
					cnt = 0;
				cnt++;
			}
			System.out.print("#" + tc + " ");
			for (int dequeIdx = 0; dequeIdx < 8; dequeIdx++) {
				System.out.print(deque.poll() + " ");
			}
			System.out.println();
		}
	}
}
