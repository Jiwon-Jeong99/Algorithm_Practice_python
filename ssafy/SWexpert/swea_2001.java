package exercise;
/**
 * swea_2001 파리퇴치
 * @author 정지원
 * 
 * 1. 테스트케이스를 입력받기
 * 2. 테스트케이스만큼 반복하기
 * 3. N 배열, 내리칠 M크기 배열 입력받기
 * 4. N줄에 걸쳐 N배열 입력받기
 * 5. M배열에서 좌측상단을 중점으로 colIdx를 먼저 순회한 후에, rowIdx+1을 하는 식으로 순회한다.
 * 6. 배열 범위 내에서 움직이도록 한다.
 * 7. max값을 업데이트 하며 최종 max값을 출력한다.
 */
import java.util.Scanner;

public class swea_2001 {
	static int testCase; //테스트케이스
	static int N; //N배열 크기
	static int M; //내리칠 M배열 크기
	static int[][] arr; //NxN배열
	static int max; //잡은 파리의 최대합
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		testCase = scan.nextInt(); //1.테스트케이스 입력받기
		for(int tc=1; tc<=testCase; tc++) {//2.테스트케이스만큼 반복하기
			N = scan.nextInt(); //3. N배열 크기 입력받기
			M = scan.nextInt(); //내리칠 N배열 크기 입력받기
			
			arr = new int[N][N];
			//4. N줄에 걸쳐 NxN배열 입력받기
			for(int rowIdx=0; rowIdx<N; rowIdx++) {
				for(int colIdx=0; colIdx<N; colIdx++) {
					arr[rowIdx][colIdx] = scan.nextInt();
				}
				scan.nextLine();
			}
			
			max = 0;
			
			//5. M배열에서 좌측상단을 중점으로 colIdx를 먼저 순회한 후에, rowIdx+1을 하는 식으로 순회한다.
			for(int nRowIdx=0; nRowIdx<N-M+1; nRowIdx++) {
				for(int nColIdx=0; nColIdx<N-M+1; nColIdx++) {
					int sum = 0; //M배열에서 잡은 파리 수의 합
					for(int mIdx=0; mIdx<M; mIdx++) {
						for(int nIdx=0; nIdx<M; nIdx++) {
							sum += arr[nRowIdx+mIdx][nColIdx+nIdx]; //M배열에서 잡은 파리 수의 합
						}
					}
					max = Math.max(max, sum);
				}
			}
			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}
}
