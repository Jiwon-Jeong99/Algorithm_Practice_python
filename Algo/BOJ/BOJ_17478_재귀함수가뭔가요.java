package boj;

/**
 * boj_17478 재귀함수가 뭔가요
 * 
 * 문풀
 * 1. 재귀함수가 뭔가요~선인에게 한 선비가 찾아와 까지 depth가 진행될수록 ____ 추가
 * 2. 입력받은 수에 해당하는 depth에 도달했을 때는 재귀함수가 뭔가요~라고 답변하였지 하고 
 * 3. 라고 답변하였지 한칸씩 줄어듦.
 * 4. 언더바는 depth가 하나씩 추가될 때마다 string에 추가해주는 걸로 
 * 
 * 호출스택 안에 넣고 하나씩 뺀다고 생각하자
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17478_재귀함수가뭔가요 {
	static BufferedReader br;
	static StringBuilder sb;

	static int repeat; // 반복횟수

	static String[] listen = { "\"재귀함수가 뭔가요?\"", "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.",
			"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.", "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"" };

	static String[] listen2 = { "\"재귀함수가 뭔가요?\"", "\"재귀함수는 자기 자신을 호출하는 함수라네\"", "라고 답변하였지." };

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		repeat = Integer.parseInt(br.readLine().trim());

		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		recursion(repeat, 0);
		System.out.println(sb);
	}

	// 재귀
	// ____점점 추가해가는 로직
	static void recursion(int repeat, int num) {
		StringBuilder under = new StringBuilder();
		// 재귀돌때마다 언더바 4개씩 추가
		for (int idx = 0; idx < num; idx++) {
			under.append("____");
		}
		sb.append(under); // 언더바 추가
		sb.append(listen[0]).append("\n");
		if (repeat == 0) { // 재귀가 끝까지 돌고 마지막이면 리턴하고 return
			sb.append(under);
			sb.append(listen2[1]).append("\n");
			sb.append(under);
			sb.append(listen2[2]).append("\n");
			return;
		}

		for (int idx = 1; idx <= 3; idx++) {
			sb.append(under);
			sb.append(listen[idx]).append("\n");
		}

		recursion(repeat - 1, num + 1);
		sb.append(under);
		sb.append(listen2[2]).append("\n");

	}
}
