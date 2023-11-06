import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * swea_2105 디저트카페
 * @author 정지원
 * 3초 256mb
 * 
 * 문제
 * - nxn 정사각형 디저트카페
 * - 대각선 방향으로 움직일 수 있는 길 o
 * - 대각선 방향으로 움직이고, 사각형 모양 그리며, 출발한 카페로 돌아와야 한다.
 * - 해당 지역을 벗어나면 안된다.
 * - 카페 투어 중 같은 숫자의 디저트를 팔고 있는 카페 x
 * - 1개의 카페도 x
 * - 왔던 길 다시 돌아가는 것도 x
 * - 디저트 되도록 많이 먹으려고 한다.
 * 
 * output : 가장 많이 먹을 수 있는 디저트 수 
 * 			디저트 먹을 수 없으면 -1 출력
 * 
 * 문풀
 * 1. DFS - 이전의 방향을 기억하는
 * 2. 이전의 방향을 매개변수로 보내서 그 방향 다음 방향만 찾도록 한다.
 * ------------------------------------
 * 1. 최소 양옆, 밑에 2칸까지는 여유가 있어야 함
 * 2. 먹은 디저트 방문처리, 위치 방문처리 (중복x)
 * 3. dfs 돌면서 이전방향 다음 방향만 탐색
 * 4. 자기자신 좌표가 나오면 종료 -> max를 비교
 * 
 *
 */

public class SWEA_2105_디저트카페 {
	static BufferedReader br;
	static StringTokenizer st;
	
	static int mapSize; //정사각형 맵 사이즈
	static int[][] map; //정사각형 맵
	
	//이동방향
	static int[] dx = {1,1,-1,-1};
	static int[] dy= {-1,1,1,-1};
	
	//디저트번호 리스트
	static List<Integer> foodList;
	
	//result는 케이스별 디저트개수, max는 최대 디저트수
	static int result, max;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine().trim());
		
		//테스트케이스
		for(int tc=1; tc<=testCase; tc++) {
			mapSize = Integer.parseInt(br.readLine().trim());
			map = new int[mapSize][mapSize];
			foodList = new ArrayList<>();
			max = Integer.MIN_VALUE;
			result = 0;
			
			//맵 채우기
			for(int ridx=0; ridx<mapSize; ridx++) {
				st = new StringTokenizer(br.readLine().trim());
				for(int cidx=0; cidx<mapSize; cidx++) {
					map[ridx][cidx] = Integer.parseInt(st.nextToken());
				}
			}
			
			//map의 각 위치 마다 탐색 시작
			for(int rowIdx=0; rowIdx<mapSize; rowIdx++) {
				for(int colIdx=0; colIdx<mapSize; colIdx++) {
					//디저트번호 리스트에 첫번째 요소 넣고 dfs 탐색 시작
					foodList.add(map[rowIdx][colIdx]);
					dfs();
					//dfs가 끝나면 리스트 비워줌
					foodList.clear();
				}
			}
		}
		
	}
	
	//dfs
	//현재 위치 x,y 시작위치
	static void dfs()
}
