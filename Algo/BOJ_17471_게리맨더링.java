package BOJ;

/**
 * boj_17471 게리맨더링
 * 0.5초 512mb
 * 
 * 문제
 * 1. n개의 구역. 1~n까지의 번호
 * 2. 2개의 선거구로 나눠야 한다.
 * 3. 각 구역은 2개 중 하나에는 꼭 포함되어야 한다.
 * 4. 한 선거구에 포함되어 있는 구역은 모두 연결되어야 한다.
 * 5. 2개의 선거구에 포함된 인구의 차이를 최소로 하려고 한다.
 * 
 * 선거구를 나눌 수 없으면 -1 
 * 
 * input : 
 * - 첫째줄 : 구역의 개수
 * - 둘째줄 : 1~n까지의 인구수
 * - 셋째줄 ~ n개 : 인접한 구역 개수, 구역 개수만큼 (구역 번호) 
 * output : 두 선거구의 인구 차이의 최솟값
 * 
 * 문풀
 * 1. 선거구수+1로 배열을 만든다.
 * 2. 선거구를 2개의 선거구로 나누는 부분집합
 * 3. bfs 혹은 dfs로 해당 선거구끼리 이어져 있는지 확인
 * 4. 만약 최소값이라면 갱신
 * 
 * 5. 간선이 이어진 것끼리 인접행렬을 만들어서 연결
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17471_게리맨더링 {
	static BufferedReader br;
	static StringTokenizer st;
	
	static int group; //선거구 수
	static int[] people; //선거구별 인구수
	static int[][] map; //인접행렬
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		group = Integer.parseInt(br.readLine().trim());
		
		//선거구+1로 1번부터 시작되는 선거구에 맞춘다.
		people = new int[group+1];
		map = new int[group+1][group+1];
		
		st = new StringTokenizer(br.readLine().trim());
		for(int idx=1; idx<=group; idx++) {
			people[idx] = Integer.parseInt(st.nextToken());
		}
		
		//인접행렬 입력
		for(int idx=1; idx<=group; idx++) {
			st = new StringTokenizer(br.readLine().trim());
			
			int num = Integer.parseInt(st.nextToken());
			for(int i=0; i<num; i++) {
				int node = Integer.parseInt(st.nextToken());
				
				map[idx][node] = map[node][idx] = 1;
			}
		}
		
		
	}
	
	//부분집합 메서드
	static void subset() {
		
	}
	
	//bfs 메서드
	static void bfs() {
		
	}
}
