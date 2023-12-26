/**
n편 중, h번 이상 인용된 논문 - h편 이상
h번 이하 인용 - h의 최댓값

- 인용횟수를 담은 배열 citations
- h번 이상 인용된 논문 h편 이상 -> 이것 중 최댓값

문풀
1. 오름차순 정렬
2. index에서 전체 개수 빼서 count
*/

import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        //오름차순 정렬
        Arrays.sort(citations);
        
        //배열의 전체 길이
        int total = citations.length;
        
        //순회하면서 최댓값 찾기(total - idx) - 이상인거
        for(int idx=0; idx<total; idx++){
            int hindex = total - idx;
            
            if(citations[idx] >= hindex){
                answer = hindex;
                break;
            }
        }
        
        return answer;
    }
}
