package exercise;
/**
 * boj_2164 카드2
 * @author 정지원
 *
 *큐
 *1. deque에 입력받은 num까지의 원소를 넣는다.
 *2. cnt를 만들어서 cnt가 홀수면 카드를 버리고, cnt가 짝수면 맨뒤로 보낸다.
 */

import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Deque;

public class boj_2164 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt(); //카드수 입력
		Deque<Integer> deque = new ArrayDeque<>(); //카드 덱 만들기
		
		for(int idx=1; idx<=num; idx++) {//deque에 숫자 넣기
			deque.add(idx);
		}
		
		// 덱에 카드들이 존재하면 로직을 수행한다.	
		int cnt=1;
		while(deque.size() != 1) {//deque에 원소가 1개가 아닐때
			if(cnt % 2 != 0) { //홀수이면 카드 버리기
				deque.poll();
				cnt++;
			}else {//짝수이면 카드 맨 뒤로 보내기
				int card = deque.poll();
				deque.add(card);
				cnt++;
			}
		}	
		System.out.println(deque.getFirst()); //deque에 원소가 1개이면
	}
}
