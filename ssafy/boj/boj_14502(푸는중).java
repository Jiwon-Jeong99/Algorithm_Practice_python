package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * boj_14502 연구소
 * @author 정지원
 * 
 * 1.2를 찾아서 상하좌우 중 0이 있다면 -> bfs로 최종 1이 막혀있는지 확인
 * 2.없다면 1로 막고 (총3개) 안을 2로 다 바꾸기
 * 3. map에서 0 개수 세기
 *
 */
public class boj_14502 {
	static BufferedReader br;
	static StringTokenizer st;
	
	static int height; //지도 세로길이
	static int width; //지도 가로길이
	static String[][] map; //지도 이차원 배열
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		
		height = Integer.parseInt(st.nextToken()); //지도 세로길이 입력
		width = Integer.parseInt(st.nextToken()); //지도 가로길이 입력
		
		map = new String[height][width]; //지도 초기화
		for(int h=0; h<height; h++) {//지도모양 입력
			String[] line = new String[width]; //지도 모양 입력 한줄
			line = br.readLine().split(" ");
			map[h] = line; //이차원 배열 map에 넣기
		}
		
		
	}
}
