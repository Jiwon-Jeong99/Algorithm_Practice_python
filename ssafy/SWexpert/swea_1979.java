package java_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1979 {
	static BufferedReader br;
	static StringTokenizer st;
	
	static int size; //맵의 크기
	static int len; //들어가야할 길이
	static int[][] map;
	
	static int cnt; //1의 개수 세기
	static int sum; //전체 3의 길이 합
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine().trim());
		for(int tc=1; tc<=testCase; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			size = Integer.parseInt(st.nextToken());
			len = Integer.parseInt(st.nextToken());
			map = new int[size][size];
			
			cnt = 0;
			sum = 0;
			for(int rowIdx=0; rowIdx<size; rowIdx++) {
				st = new StringTokenizer(br.readLine().trim());
				for(int colIdx=0; colIdx<size; colIdx++) {
					map[rowIdx][colIdx] = Integer.parseInt(st.nextToken());
					if(map[rowIdx][colIdx] == 1) {
						cnt++;
					}else {
						if(cnt == len) sum++;
						cnt = 0;
					}
				}
				if(cnt == len) sum++;
				cnt = 0;
			}
			
			for(int xIdx=0; xIdx<size; xIdx++) {
				for(int yIdx=0; yIdx<size; yIdx++) {
					if(map[yIdx][xIdx] == 1) {
						cnt++;
					}else {
						if(cnt == len) sum++;
						cnt = 0;
					}
				}
				if(cnt == len) sum++;
				cnt = 0;
			}
			System.out.println("#"+tc+" "+sum);
		}
	}

}
