package java_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * swea_1209 sum
 * @author 정지원
 * 
 * 
 *
 */
public class swea_1209 {
	static BufferedReader br;
	static StringTokenizer st;
	
	static int max; //최대값
	static int sum; //합
	static int[][]nums;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		for(int tc=1; tc<=10; tc++) {
			br.readLine();
			nums = new int[100][100];
			max=0;
			for(int rowIdx=0; rowIdx<100; rowIdx++) {//이차원 배열 만들기
				st = new StringTokenizer(br.readLine().trim());
				sum=0;
				for(int colIdx=0; colIdx<100; colIdx++) {
					nums[rowIdx][colIdx] = Integer.parseInt(st.nextToken());
//					System.out.print(nums[rowIdx][colIdx]+" ");
					sum += nums[rowIdx][colIdx]; //가로 합 중 max값 뽑기
				}
				max = Math.max(sum, max);
			}
			for(int col=0; col<100; col++) {//세로 합 중 max값 뽑기
				sum = 0;
				for(int row=0; row<100; row++) {
					sum += nums[row][col];
				}
				max = Math.max(sum, max);
			}
			sum=0;
			for(int diag=0; diag<100; diag++) {//우하향 합
				sum += nums[diag][diag];
			}
			max = Math.max(max, sum);
			
			sum=0;
			for(int dia=99; dia>=0; dia--) { //좌->우하향 합
				sum += nums[99-dia][dia];
			}
			max = Math.max(max, sum);
			System.out.println("#"+tc+" "+max);
		}
	}
}
