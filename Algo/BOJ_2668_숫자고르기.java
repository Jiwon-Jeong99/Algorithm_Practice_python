package BOJ;

/**
 * boj_2668 숫자고르기
 * 1초 128mb
 * 
 * 문제
 * 1. 
 * 
 * output : 뽑힌 정수 개수 출력, 다음 줄 부터 뽑힌 정수들을 오름차순으로 출력
 * 
 * 문풀
 * 1. 1~n까지의 정수가 있는 배열을 만든다.
 * 2. 순서대로 주어진 대로 새로운 배열에 넣는다.
 * 3. 조합으로 주어진 index를 뽑고 sub 배열에서 해당 index의 숫자가 뽑히면
 * 		-> 이 두 개를 sort해서 for문으로 비교
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BOJ_2668_숫자고르기 {
	static BufferedReader br;
	
	static int total; //뽑힌 
	static int[] mainArr; //순서대로 수가 적힌 배열
	static int[] sub; //주어진 배열
	
	static int size; //중복되지 않은 수의 개수
	static int[] selectArr1; //선택된 배열
	static int[] selectArr2; //선택된 배열
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		total = Integer.parseInt(br.readLine().trim());
		
		mainArr = new int[total];
		sub = new int[total];
		
		Set<Integer> set = new HashSet<>();
		
		//각각 배열에 숫자 넣기
		for(int idx=0; idx<total; idx++) {
			mainArr[idx] = idx+1;
			int num = Integer.parseInt(br.readLine().trim());
			sub[idx] = num;
			set.add(num);
		}
		
		//주어진 숫자들의 중복되지 않는 총 수
		size = set.size();
		
		//size부터 1씩 줄여가면서 부분집합 만들기
		for(int index=size; index>0; index--) {
			selectArr1 = new int[size];
			selectArr2 = new int[size];
			combi(0,0,size);
		}
		
	}
	
	//조합 배열
	static boolean combi(int start, int depth, int pick) {
		if(depth == pick) {
			boolean flag = true;
			Arrays.sort(selectArr1);
			Arrays.sort(selectArr2);
			for(int idx=0; idx<pick; idx++) {
				if(selectArr1[idx] != selectArr2[idx]) {
					flag = false;
					break;
				}
			}
			return flag;
		}
		
		if(start == total) return;
		
		selectArr1[depth] = mainArr[start];
		selectArr2[depth] = sub[start];
		combi(start+1, depth+1, pick);
		
		selectArr1[depth] = 0;
		selectArr2[depth] = sub[start];
		combi(start+1, depth, pick);
	}
	
}
