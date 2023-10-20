import java.util.*;
import java.io.*;

//stringBuilder는 string으로 반환하려면 toString()해주어야 한다.

class Solution {
    static StringTokenizer st;
    static StringBuilder sb;
    static int maxVal = Integer.MIN_VALUE;
    static int minVal = Integer.MAX_VALUE;
    static int num;
    
    public String solution(String s) {
        String[] stringList = s.split(" ");
        for (String num : stringList){
            maxVal = Math.max(maxVal, Integer.parseInt(num));
            minVal = Math.min(minVal, Integer.parseInt(num));
        }
        //System.out.println(stringList.length);

        sb = new StringBuilder();
        sb.append(minVal).append(" ").append(maxVal);
        
        //System.out.println(sb);
        return sb.toString();
    }
}
