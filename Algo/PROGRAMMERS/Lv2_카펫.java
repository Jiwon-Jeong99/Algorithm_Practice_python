/**
문제
1. 테두리 1줄 - 갈색, 중간 - 노란색
=> 가로, 세로 크기를 배열에 담아 return

문풀
1. 가로 x, 세로 y 
    갈색 : 2(x+y) - 4
    노란색 : (x-2) * (y-2)
*/

import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int x = 0;
        int y = 0;

        for (x = 3; x <= (brown + 4) / 2; x++) {
            y = ((brown + 4) / 2) - x;

            if ((x - 2) * (y - 2) == yellow && x >= y) {
                break;
            }
        }
        System.out.println(x);
        System.out.println(y);
        int[] answer = {x, y};
        return answer;
    }
}
