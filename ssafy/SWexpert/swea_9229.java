package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * swea_9229 한빈이와 Spot Mart
 * @author 정지원
 * 
 * 1. 테스트케이스만큼 반복해서 입력받기
 * 2. combination 메서드로 고를 수 있는 과자수 total에서 2개를 뽑는 모든 조합을 만들어내기(완전탐색)
 * 	  무게의 누적합을 구한 뒤에, 과자 2개의 합이 무게제한보다 작거나 같으면 합을, 크다면 -1을 반환한다.
 *
 */
public class swea_9229 {
	static BufferedReader br;
	static StringTokenizer st;
	static int total; //고를 수 있는 과자 수
	static int limit; //최대무게제한
	static int[] snacks; //모든 과자 무게가 담겨있는 배열(조합을 뽑아낼 배열)
	static int answer; //최대무게 출력
	
	public static void main(String[] args) throws IOException, NumberFormatException{
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine().trim()); //테스트케이스 입력
		for(int tc=1; tc<=testCase; tc++) {//테스트케이스만큼 반복
			st = new StringTokenizer(br.readLine());
			total = Integer.parseInt(st.nextToken()); //고를 수 있는 과자수 입력
			limit = Integer.parseInt(st.nextToken()); //최대무게제한 입력
			
			//입력 받은 과자 무게들 int배열로
			st = new StringTokenizer(br.readLine());
			snacks = new int[total];
			for(int sn=0; sn<total; sn++) {
				snacks[sn] = Integer.parseInt(st.nextToken());
			}
			
			answer = -1; //최대 무게 값 출력 세팅
			combination(0,0,0); //조합 메서드
			System.out.println("#"+tc+" "+answer);
		}
	}
	//과자 2개의 무게가 limit 이하인 최대값을 구하기 위한 조합 메서드 - total 4개 중에 two 2개를 뽑는 조합
	private static void combination(int cnt, int depth, int sum) {
		if(cnt == 2) {
			answer = Math.max(answer,  (sum<=limit)?sum:-1); //2개의 합계가 제한무게보다 같거나 작으면 합계를, 아니면 -1
			return;
		}
		
		for(int weight=depth; weight<total; weight++) {
			//무게누적합
			combination(cnt+1, weight+1, sum+snacks[weight]);
		}
	}
}