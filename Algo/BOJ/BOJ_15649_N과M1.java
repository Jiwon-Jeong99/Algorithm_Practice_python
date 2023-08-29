package boj;

/**
 * boj_15649 n과m1
 * 
 * 문제
 * 1. 1부터 n까지 m개 뽑는 순열
 * 2. 사전 순으로 증가
 * 3. 공백 추가
 * 
 * 문풀
 * 1. 최대 8까지니까 n까지의 수를 담은 int 배열 생성
 * 2. permutation 메서드 만들어서 출력하도록 한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15649_N과M1 {
	static BufferedReader br;
	static StringTokenizer st;

	static int range; // 숫자 범위
	static int pick; // 뽑는 숫자 개수
	static int[] nums; // range까지의 숫자가 담긴 배열
	static int[] select; // 뽑은 조합을 저장하는 배열
	static boolean[] visited; // 방문체크배열

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());

		range = Integer.parseInt(st.nextToken());
		pick = Integer.parseInt(st.nextToken());

		select = new int[pick];
		visited = new boolean[range];

//		1. 최대 8까지니까 n까지의 수를 담은 int 배열 생성
		nums = new int[range];
		for (int idx = 1; idx <= range; idx++) {
			nums[idx - 1] = idx;
		}
		permutation(0);
	}

//	2. permutation 메서드 만들어서 출력하도록 한다.
	static void permutation(int depth) {
		if (depth == pick)

		{
			for (int idx = 0; idx < pick; idx++) {
				System.out.print(select[idx] + " ");
			}
			System.out.println();
			return;
		}
		for (int num = 0; num < range; num++) {
			if (!visited[num]) {
				visited[num] = true;
				select[depth] = nums[num];
				permutation(depth + 1);
				visited[num] = false;
			}

		}
	}
}
