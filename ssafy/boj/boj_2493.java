package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * boj_2493 탑
 * @author 정지원
 *
 *1. 탑을 스택에 하나씩 넣으면서 진행
 *2. 스택이 비어있다면 정답 배열에 0추가
 *3. if) 넣으려고 하는 탑 > 스택상단에 있는 탑 : 스택에 있는 탑 pop
 *		 넣으려고 하는 탑 < 스택상단에 있는 탑 : 스택에 있는 탑의 번호 정답 배열에 추가
 */

public class boj_2493 {
    static BufferedReader br;
    static StringTokenizer st;
    static int total; //탑 총 개수
    static Stack<Integer> towers; //탑의 높이를 담은 큐
    static int[] towersCnt; //탑 별 정보를 담을 배열
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        total = Integer.parseInt(br.readLine().trim()); //탑 총 개수 입력

        towers = new Stack<>();
        towersCnt = new int[total+1]; //번호를 담을 배열

        int[] arr = new int[total+1]; //탑 정보를 담을 배열
        st = new StringTokenizer(br.readLine().trim());
        for(int index=1; index<=total; index++){
            arr[index] = Integer.parseInt(st.nextToken());
        }

        for(int idx=1; idx<=total; idx++) { //레이저 맞은 탑 비교하기
            while(towers.size()>0){
                if(arr[towers.peek()] >= arr[idx]){ //스택상단에 있는 탑이 더 클 때
                    towersCnt[idx] = towers.peek();
                    break;
                }else{
                    towers.pop(); //넣으려고 하는 탑이 더 클때
                }
            }
            towers.push(idx);
        }
        sb = new StringBuilder();
        for(int ansIdx=1; ansIdx<=total; ansIdx++){
            sb.append(towersCnt[ansIdx]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
