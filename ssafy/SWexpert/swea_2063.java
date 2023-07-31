package swea;

/**
 * 1. 입력받는 수를 배열에 집어넣는다.
 * 2. 배열을 크기 순으로 정렬한다.
 * 3. (배열크기+1) /2 -1 인덱스에 위치한 놈이 중간값이다. -> but, 어차피 인덱스 0부터 시작이기 때문에 배열크기/2
 */

import java.util.Arrays;
import java.util.Scanner;

public class swea_2063 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCase = scan.nextInt();

        int[] nums = new int[testCase]; //입력받는 수를 넣을 배열
        for(int tc=0; tc<testCase; tc++){ //O(N)
            nums[tc] = scan.nextInt();
        }
        Arrays.sort(nums);
        System.out.println(nums[testCase/2]);
    }
}
