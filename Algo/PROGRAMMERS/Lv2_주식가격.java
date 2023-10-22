/**
초단위 주식가격이 담긴 배열 prices
가격이 떨어지지 않은 기간은 몇초인가
*/

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int idx=0; idx<prices.length-1; idx++){
            //현재 요소보다 뒤에 있는 요소들 check
            for(int i=idx+1; i<prices.length; i++){
                answer[idx]++;
                if(prices[idx] > prices[i]) break;
            }
        }
 
        return answer;
    }
}
