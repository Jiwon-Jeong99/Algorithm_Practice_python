package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * boj_1158 요세푸스 문제
 * @author 정지원
 *
 *1.n,k를 입력받기
 *2. n 사이즈의 큐 생성
 *3. 큐에서 index+1이 k의 배수인 곳까지 엘리먼트를 빼서 다시 끝에 집어넣고, 3의 배수가 되는 엘리먼트는 answer 배열에 저장
 *4. while문으로 큐의 엘리먼트가 1개 남을 때까지 반복하기
 */


public class boj_1158 {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in)); //입력을 위해
		st = new StringTokenizer(br.readLine()); //스페이스 처리를 위해
		sb = new StringBuilder(); //출력을 위해
		
		// 1. n,k 입력받기
		int total = Integer.parseInt(st.nextToken());
		int kill = Integer.parseInt(st.nextToken());
		
		Deque<Integer> deque = new ArrayDeque<>(); //원탁 순서 넣을 큐 생성
		
		for(int i=0; i<total; i++) { //queue에 total까지의 사람 번호 넣기
			deque.add(i+1); 
		}
		sb.append("<");
		while(deque.size() != 1) { //원탁 번호가 1개 초과일 때 반복
			for(int idx=0; idx<kill-1; idx++) { //kill의 배수 전까지는 꺼내서 뒤로 보냄
				deque.add(deque.poll());
			}
			sb.append(deque.poll()+", "); //kill의 배수일 때는 꺼내서 출력
		}
		
		sb.append(deque.poll() + ">");
		
		System.out.println(sb);//최종 출력

	
	}
}
