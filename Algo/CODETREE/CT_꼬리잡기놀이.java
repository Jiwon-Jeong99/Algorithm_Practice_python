package CODETREE;

/**
 * ct_꼬리잡기놀이
 * 1초 80mb
 * 
 * 문제
 * 1. nxn 격자
 * 2. 머리사람 - 1, 중간사람 - 2, 꼬리사람 - 3
 * 3. 주어진 이동 선인 4를 따라서만 이동
 * 4. 머리사람을 따라 한칸 이동
 * 
 * 점수
 * 5. 해당 선에 최초로 만나게 되는 사람만이 점수 획득
 * 6. 머리사람 시작으로) k번째 사람 -> 점수 : k^2
 * 7. 공을 획득한 경우 머리사람과 꼬리사람이 바뀜.(방향 전환)
 * 
 * 한 턴 : 한칸 이동 -> 공 던지기
 * 
 * input : 맵크기, 팀개수, 라운드수
 * output : 각 팀이 획득한 점수의 총합
 * 
 * 문풀
 * - 처음에 팀 별 좌표 저장 , 팀 개수만큼 arraylist 만들기
 * - 이동 -> 델타배열로 4가 있다면 거기로 이동 -> 자신의 숫자와 옮기는 곳의 4를 바꿔줄 것
 * - 곻던지기
 * - 순서보장
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

public class CT_꼬리잡기놀이 {
	static BufferedReader br;
	static StringTokenizer st;
	
	static int mapSize, totalTeam, totalRound;
	static int[][] map; //이차원배열 map
	
	static List<Queue<Pos>> teamPos = new ArrayList<>(); //팀들의 좌표를 가지고 있는 arrayList
	
	//상하좌우
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static final int DELTA = 4;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine().trim());
		mapSize = Integer.parseInt(st.nextToken());
		totalTeam = Integer.parseInt(st.nextToken());
		totalRound = Integer.parseInt(st.nextToken());
		
		map = new int[mapSize][mapSize];
		
		//팀 수만큼 queue 넣기
		for(int team=1; team<=totalTeam; team++) {
			teamPos.add(new ArrayDeque<>());
		}
		
		//이차원 맵 입력받기
		for(int rowIdx=0; rowIdx<mapSize; rowIdx++) {
			st = new StringTokenizer(br.readLine().trim());
			
			for(int colIdx=0; colIdx<mapSize; colIdx++) {
				map[rowIdx][colIdx] = Integer.parseInt(st.nextToken());
				
				//팀별 큐에 POS로 좌표 넣기
				if(map[rowIdx][colIdx] >= 1 && map[rowIdx][colIdx] <= 3) {
					
				}
			}
		}
		
		
		//라운드수만큼 반복
		for(int turn=1; turn<=totalRound; turn++) {
			//모든 팀 이동
			
			
			//공던지기
			
		}
	}
	
	//상하좌우 이동 메서드
	static void move() {
		
	}
	
	//좌표 객체
	static class Pos{
		
		//value는 순서값
		int value,x,y;
		
		Pos(int value, int x, int y){
			this.value = value;
			this.x = x;
			this.y = y;
		}
	}
}
