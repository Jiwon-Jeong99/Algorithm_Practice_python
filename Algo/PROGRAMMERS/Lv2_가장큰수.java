import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] strNums = new String[numbers.length];
        
        //int배열 -> String배열로
        for(int i=0; i<numbers.length; i++){
            strNums[i] = Integer.toString(numbers[i]);
        }
        
        //두 수를 번갈아가며 합친 수 중 큰 값을 앞으로 정렬(내림차순 정렬)
        // Arrays.sort(strNums, Collections.reverseOrder());
        Arrays.sort(strNums, (o1,o2) -> (o2+o1).compareTo(o1+o2));
        
        if(strNums[0].equals("0")){
            return "0";
        }
        
       StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<numbers.length; i++){
            sb.append(strNums[i]);
        }
        
        return sb.toString();
    }
}
