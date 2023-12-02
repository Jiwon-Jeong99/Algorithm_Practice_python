package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * boj_팀빌딩
 * 1초 1024mb
 *
 * 문제
 * 1. 개발자 2명이 반드시 모여야 함.
 * 2. 능력치 : (개발자 A와 B 사이에 존재하는 다른 개발자 수) x min(개발자 A의 능력치, 개발자 B의 능력치)
 *
 * output : 팀 능력치의 최댓값
 *
 * 문풀
 * 1. 조합으로 2개씩 뽑는다 -> 10만이기 때문에 시간초과
 * 2. 투포인터
 *      - Math.min을 곱하므로 투포인터 중 작은 값을 가지는 포인터를 이동시키면서 진행했을 때 최댓값을 구할 수 있다.
 */

public class BOJ_22945_팀빌딩 {
    static BufferedReader br;
    static StringTokenizer st;

    static int total; //전체 개발자수
    static int[] people; //개발자 배열

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        total = Integer.parseInt(br.readLine().trim());
        people = new int[total+1];

        st = new StringTokenizer(br.readLine().trim());

        //개발자 배열 받기
        for(int idx=1; idx<=total; idx++){
            people[idx] = Integer.parseInt(st.nextToken());
        }

        System.out.println(towPointer());
    }

    //투포인터
    static int towPointer() {
        int left = 1;
        int right = total;
        int result = 0;

        while(left<=right) {
            int min = Math.min(people[left], people[right]);
            result = Math.max(min * (right - left - 1), result);
            if(people[left] < people[right]){
                left++;
            }else right--;
        }
        return result;
    }
}
