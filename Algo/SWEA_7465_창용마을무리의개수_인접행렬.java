package SWEA;

/**
 * 혼자일때도 무리로 카운팅되어야 한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7465_창용마을무리의개수_인접행렬 {
	static BufferedReader br;
	static StringTokenizer st;
	
	static int people, relation; //사람수, 관계수
	static int[][] map; //인접행렬
	static boolean[] visited; //방문확인배열
	static int answer; //무리의 개수
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine().trim());
		for(int tc=1; tc<=testCase; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			
			people = Integer.parseInt(st.nextToken());
			relation = Integer.parseInt(st.nextToken());
			
			
		}
	}
}
