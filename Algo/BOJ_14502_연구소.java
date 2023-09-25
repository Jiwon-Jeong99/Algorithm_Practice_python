package BOJ;
/**
 * boj_14502 연구소
 * 
 * 문제
 * 1. 지도의 가로height, 세로width길이 입력받기
 * 2. 빈칸 : 0, 벽 : 1, 바이러스 : 2
 * 3. 바이러스는 상하좌우로 퍼져나갈 수 있다. -> 0인 빈칸에 퍼짐
 * 4. 세울 벽의 개수는 3개. 무조건 세워야 한다.
 * 5. 바이러스가 퍼져나가지 않게 벽을 세워서
 * => 퍼진 후에 남은 0의 최대 개수를 구하라
 * 
 * 문풀
 * 1. 이차원배열에 지도 정보를 받는다.
 * 2. 2차원 배열의 빈칸인 0에서 조합으로 3개를 골라 벽을 두고
 * 3. bfs로 빈칸인지 벽인지 탐색하면서 너비 우선탐색 
 * 4. 빈칸이면 바이러스인 2로 바꾸고, 1 혹은 2이면 재탐색
 * 5. 상하좌우가 다 1 혹은 2이면 탐색 종료
 * 6. 전체 0 개수 카운트
 * 7. 최댓값 업데이트
 * => 복사된 맵의 값을 이용해야 함. 원본 배열 그대로 이용하면 안됨.
 */
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502_연구소 {
	static BufferedReader br; 
	static StringTokenizer st;
	
	static int height, width; //맵의 가로, 세로
	static int[][] map; //맵
	
	static boolean[][] visited; //방문처리
	static List<int[]> zeroCoordi; //0의 좌표값
	static int[] choiceList; //0좌표에서 고를 순서
	static int[][] selectList; //조합으로 선택된 벽 3개 세울 좌표
	
	static int maxSafe; //안전영역 최대값
	static int[] dx = {0,0,-1,1}; //상하좌우
	static int[] dy = {-1,1,0,0};
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine().trim());
		
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		
		//1. 이차원배열에 지도 정보를 받는다.
		map = new int[height][width];
		visited = new boolean[height][width];
		
		zeroCoordi = new ArrayList<>(); //빈칸인 0의 좌표 배열
		selectList = new int[3][2]; //
		
		for(int rowIdx=0; rowIdx<height; rowIdx++) {
			st = new StringTokenizer(br.readLine().trim());
			
			for(int colIdx=0; colIdx<width; colIdx++) {
				map[rowIdx][colIdx] = Integer.parseInt(st.nextToken());
				
				//빈칸 좌표 list에 add
				if(map[rowIdx][colIdx] == 0) {
					zeroCoordi.add(new int[] {rowIdx, colIdx});	
				}
			}
		}
		
		//0좌표의 개수를 넣은 숫자
		int length = zeroCoordi.size(); //0좌표 개수
		choiceList = new int[length];
		for(int idx=0; idx<length; idx++) {
			choiceList[idx] = idx; 
		}
		
	}
	
	//bfs 메서드
	public static void bfs(int startX, int startY) {
		Queue<int[]> queue = new ArrayDeque<>();
		
		queue.offer(new int[] {startX, startY});
		
		visited[startX][startY] = true;
	}
	
	//조합 메서드
	//2. 2차원 배열의 빈칸인 0에서 조합으로 3개를 골라 벽을 두고
	public static void combination(int start, int depth) {
		if(depth == 3) {
			for(int num=0; num<3; num++) {
				 map[0] = selectList[num][0];
				 map[1]
			}
		}
			return;
		
		if(start == 3){
            return;
        }
		
		//0이 위치한 좌표 넣기
        selectList[depth] = zeroCoordi.get(choiceList[start]);
        combination(start+1, depth+1);

        selectList[depth] = new int[2];
        combination(start+1, depth);
    }
}

