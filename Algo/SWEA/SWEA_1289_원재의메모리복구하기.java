package swea;

/**
 * swea_1289 원재의 메모리 복구하기
 * 
 * 문제
 * 1. 00000에서 주어진 값으로 돌아가는데 몇번이나 고쳐야 하는지
 * 2. 특정 인덱스를 특정해 0 or 1을 고르면 해당 인덱스부터 끝까지 고른 숫자로 바뀐다.
 * 
 * 문제풀이
 * 1. 원래의 값을 String배열로 받아 int배열로 변환한다.
 * 2. 받은 배열의 길이만큼의 해당하는 int배열을 새로 만든다.
 * 3. 반복문을 돌며 수가 다르면 원래 배열의 숫자로 해당 인덱스부터 뒤까지를 바꾼다.
 * 4. 수가 다를때마다 count를 하나씩 올린다.
 * 5. 매 테스트케이스마다 count를 초기화하고 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1289_원재의메모리복구하기 {
	static BufferedReader br;
	static StringTokenizer st;

	static int[] num; // 입력받은 string[] -> int[]
	static int[] ans; // 복사한 지워진 배열
	static int count; // 바뀐 횟수

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= testCase; tc++) {
//			1. 원래의 값을 String배열로 받아 int배열로 변환한다.
			String[] nums = br.readLine().trim().split("");
			num = new int[nums.length];
			for (int idx = 0; idx < nums.length; idx++) {
				num[idx] = Integer.parseInt(nums[idx]);
			}
//			2. 받은 배열의 길이만큼의 해당하는 int배열을 새로 만든다.
			ans = new int[nums.length];

//			5. 매 테스트케이스마다 count를 초기화하고 출력한다.
			count = 0;
//			3. 반복문을 돌며 수가 다르면 원래 배열의 숫자로 해당 인덱스부터 뒤까지를 바꾼다.
			for (int index = 0; index < nums.length; index++) {
				if (ans[index] != num[index]) {
					for (int change = index; change < nums.length; change++) {
						ans[change] = num[index];
					}
//					 4. 수가 다를때마다 count를 하나씩 올린다.
					count++;
				}
			}

			System.out.println("#" + tc + " " + count);
		}
	}
}
