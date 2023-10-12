package SWEA;

/**
 * swea_1767 프로세서 연결하기
 * 
 * 문제
 * 1. mapSize : 7~12
 * 2. core 개수 : 1~12
 * 
 * - 전선은 직선으로만 설치 가능
 * - 전선은 절대로 교차x
 * - 가장자리에 붙어있는 경우 이미 전원이 연결된 것으로 간주
 * 
 * 1. 코어 개수를 최대치에서 한개씩 줄여가면서 코어 선택
 * 2. dfs를 사용하여 상하좌우로 전선을 만들 수 있는지 판단
 * 		-> 만들 수 있는 경우 : 재귀로 다음으로 넘어가고, 최솟값 갱신
 * 		-> 만들 수 없는 경우 : return으로 dfs 빠져나와 다음 조합으로 
 * 
 * output :
 * 1) 최대한 많은 코어에 전원을 연결 -> 전선 길이의 합 구하기
 * 2) 만약 여러방법이 있을 경우, 전선 길이의 합이 최소가 되는 값
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//코어 좌표 위치 객체
class Pos {
	int x, y;
	Pos(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class SWEA_1767_프로세서연결하기 {
	static BufferedReader br;
	static StringTokenizer st;
	
	static int mapSize; //이차원배열 맵의 크기
	static int[][] map; //이차원배열
	static List<Pos> list; //코어의 좌표 리스트
	
	//상하좌우 델타배열
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static final int DELTA = 4;
	
	static int minLen;
	static int maxCore;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		//테스트케이스 입력
		int testCase = Integer.parseInt(br.readLine().trim());
		
		for(int tc=1; tc<=testCase; tc++) {
			mapSize = Integer.parseInt(br.readLine().trim());
			
			map = new int[mapSize][mapSize];
			list = new ArrayList<>();
			
			//이차원배열 입력받기
			for(int rowIdx=0; rowIdx<mapSize; rowIdx++) {
				st = new StringTokenizer(br.readLine().trim());
				
				for(int colIdx=0; colIdx<mapSize; colIdx++) {
					map[rowIdx][colIdx] = Integer.parseInt(st.nextToken());
					
					//코어의 위치 리스트에 저장
					if(map[rowIdx][colIdx] == 1) {
						
						//가장자리에 붙어있는 코어 제외
						if(rowIdx == 0 || colIdx == 0 || rowIdx>=mapSize-1 || colIdx>=mapSize-1) continue;
						list.add(new Pos(rowIdx, colIdx)); //가장자리에 있는 코어 빼고 저장
					}
				}
			}
			
			minLen = Integer.MAX_VALUE;
			maxCore = Integer.MIN_VALUE;
			
			dfs(0,0,0);
			
			System.out.println("#"+tc+" "+minLen);
			
		}
	}
	
	//코어를 고르는 조합 + 이동 메서드
	static void dfs(int index, int coreCnt, int len) { //len은 간선의 길이 합
		if(index == list.size()) { //기저조건 : 증가되는 인덱스가 코어 개수 list의 사이즈만큼 되었을 때
			if(maxCore < coreCnt) { //코어개수가 더 많아서 갱신해야 될 때
				maxCore = coreCnt;
				minLen = len;
			}
			else if(maxCore == coreCnt) { //코어개수가 같으면 길이 비교
				if(minLen > len) minLen = len;
			}
			return;
		}
		
		//코어 좌표 받아오기
		int x = list.get(index).x;
		int y = list.get(index).y;
		
		//상하좌우
		for(int idx=0; idx<DELTA; idx++) {
			int count = 0;
			
			int nx = x;
			int ny = y;
			
			int originX = x;
			int originY = y;
			
			
			while(true) {
				
				//벽을 만날때까지 자기 자신을 계속 끝까지 연결시켜야 하니까
				nx += dx[idx];
				ny += dy[idx];
				
				//벽을 만날때까지
				if(nx<0 || ny<0 || nx>=mapSize || ny>= mapSize) break;
				
				if(map[nx][ny] == 1) {//전선이 있으면 못감
					count = 0; //이제까지 연결된 전선 개수 끊기
					break;
				}
				
				//전선 개수 증가시키기
				count++;
			}
			
			//전선 연결이 되는 경우 - 1로 전선 연결되었다고 표시하기
			for(int ix=0; ix<count; ix++) {
				originX += dx[idx];
				originY += dy[idx];
				
				map[originX][originY] = 1;
			}
			
			//전선을 연결할 수 없는 코어
			if(count == 0) {
				
				//다음 코어로 이동
				dfs(index+1, coreCnt, len);
			}else {
				
				//전선을 연결한 코어 - 다음 코어로 이동, 코어개수추가
				dfs(index+1, coreCnt+1, len+count);
				
				//dfs return이 되고 나면 (마지막 코어까지 연결해본 한 텀이 끝난거임)
				originX = x;
				originY = y;
				
				//index == list.size()일때, return 이 되면서 하나씩 dfs가 줄어들고 이게 나와서 다시 전선 1로 바꾼만큼 0으로 바꿔줌
				for(int i=0; i<count; i++) {
					
					originX += dx[idx];
					originY += dy[idx];
					
					map[originX][originY] = 0;
				}
			}
		}	
	}
}
