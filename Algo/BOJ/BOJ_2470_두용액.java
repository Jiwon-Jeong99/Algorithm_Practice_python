package study.Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * boj_2470_두용액
 * 1초 128mb
 *
 * 문제
 * 1. 산성 1~10만, 알칼리성 -1~-10만
 * 2. 두용액을 혼합에 0에 가까운 용액을 만들려고 함
 * => 2개의 서로 다른 용액을 혼합하여 특성값이 0에 가장 가까운 용액 만들기
 * => 오름차순으로 출력, 아무것이나 하나 출력
 *
 * 문풀
 * 1. 입력값이 10만+10만=20만이기 때문에 계속 순회하면 시간초과 백퍼남
 * 2. 일단 크기순으로 정렬
 * 3. 0과 가장 가까운 용액을 아무거나 출력하면 되니까 -> 양끝부터 안쪽으로 차례대로 비교해나간다.
 * 4. 0과의 차이를 비교하면서(이분탐색)
 *      if) 0보다 작을때는, left+1
 *      if) 0보다 클때는, right-1
 * 5. 0이 되면 탐색 종료 -> 출력
 * 6. 아니라면, left와 right가 만나기 전까지 0과의 차이가 가장 작은 두 값 출력
 *
 */

public class BOJ_2470_두용액 {
    static BufferedReader br;
    static StringTokenizer st;

    static int[] liquid;
    static int gap; //0과의 차이
    static int sum, absGap; //두 용액의 합, 절댓값 차

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine().trim());
        liquid = new int[num];

        //용액 배열에 담기
        st = new StringTokenizer(br.readLine().trim());
        for(int idx=0; idx<num; idx++){
            liquid[idx] = Integer.parseInt(st.nextToken());
        }

        //배열 정렬하기
        Arrays.sort(liquid);

        //투포인터 설정
        int left = 0;
        int right = liquid.length-1;

        //두 용액의 값
        int water1 = 0;
        int water2 = 0;

        gap = Integer.MAX_VALUE;

        //left와 right가 차이가 있을때
        while(left < right){
            sum = liquid[left] + liquid[right];
            absGap = Math.abs(sum); //0과의 절댓값 차이
            if(absGap < gap){ //0과의 차이가 더 작으면
                //업데이트
                gap = absGap;
                water1 = liquid[left];
                water2 = liquid[right];
            }

            //만약 두 용액의 합이 0보다 크면
            if(sum > 0) right--; //오른쪽 포인터를 왼쪽으로 이동

            //만약 두 용액의 합이 0보다 작으면
            else left++; //왼쪽 포인터를 오른쪽으로 이동
        }

        System.out.println(water1+" "+water2);
    }
}
