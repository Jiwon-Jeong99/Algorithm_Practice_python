/**
문제
1. 삼각형의 맨 위에서 아래까지의 합이 최대값 return
2. 오른쪽 or 왼쪽으로만 이동 가능

문풀
DP - BottomUp
최대/최소의 경우의 수를 구하고, 부분 문제들이 반복하여 나타나기 때문

> 풀이1
    1. 맨 위에서부터 내려오면서 둘 중 더 큰 값을 선택하면서 배열을 순회한다.
    -> 이렇게 풀 경우
        1) 왼오 중 큰 값을 가더라도 오히려 작은 값을 갔을 때, 합이 더 크다면?
        2) 왼오의 값이 같다면?
> 풀이2
    1. 각 경우의 수의 합을 dp라는 삼각형(이차원 배열)에 할당
    2. 마지막에 dp[triangle.length-1] 중에서 가장 큰 값을 return
*/

import java.util.*;

class Solution {
    static int[][] dp; //누적합 dp 정수삼각형(이차원배열)
    
    public int solution(int[][] triangle) {
        System.out.println(triangle.length);
        dp = new int[triangle.length][triangle.length];
        
        dp[0][0] = triangle[0][0]; //초기값 세팅
        
        //배열 순회 - dp 정수삼각형 구현
        for(int idx=1; idx<triangle.length; idx++){
            //왼쪽 가장자리
            dp[idx][0] = triangle[idx-1][0] + triangle[idx][0];
            System.out.println(dp[idx][0]);
            
            //오른쪽 가장자리
            dp[idx][triangle.length-1] = triangle[idx-1][triangle.length-1] + triangle[idx][triangle.length-1];
            System.out.println(dp[idx][triangle.length-1]);
            
            //중간 자리 -> idx-1개수만큼 존재
            for(int center=1; center<=idx-1; center++){
                int max = Math.max(dp[idx-1][center], dp[idx-1][center-1]);
                dp[idx][center] = triangle[idx][center] + max;
                
                System.out.println(dp[idx][center]);
            }
        }
        
        int answer = 0;
        
        //마지막 누적합 중 최댓값 구하기
        for(int idx=0; idx<triangle.length; idx++){
            answer = Math.max(answer, dp[triangle.length-1][idx]);
        }
        
        return answer;
    }
}
