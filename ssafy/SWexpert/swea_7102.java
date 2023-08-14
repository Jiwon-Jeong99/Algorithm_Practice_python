package swea;

/**
 * swea+_7102 
 * 
 * 1. nC1 + mC1의 모든 경우의 수를 배열에 저장한다.
 * 2. 배열을 돌면서 해당 숫자에 해당하는 배열 인덱스의 값을 더해간다.
 * 3. 최빈수를 구하고 오름차순으로 정렬해서 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_7102 {
	static BufferedReader br;
	static StringTokenizer st;

	static int N;
	static int M;
	static int[] sum; // 전체 합의 빈도를 담은 배열

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= testCase; tc++) {

			st = new StringTokenizer(br.readLine().trim());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			sum = new int[N * M + 1];

			// 두수의 합에 해당하는 배열의 인덱스의 값 올려주기
			for (int idx = 1; idx <= N; idx++) {
				for (int id = 1; id <= M; id++) {
					sum[id + idx]++;
				}
			}
			// 배열에서 최대값 구하기
			int max = 0;
			for (int num = 0; num < sum.length; num++) {
				max = Math.max(max, sum[num]);
			}

			System.out.print("#" + tc + " ");
			// 배열에서 최대값에 해당하는 인덱스 다 출력
			for (int fina = 0; fina < sum.length; fina++) {
				if (sum[fina] == max)
					System.out.print(fina + " ");
			}
			System.out.println();
		}
	}

}
