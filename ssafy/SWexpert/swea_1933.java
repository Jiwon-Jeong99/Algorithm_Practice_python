package swea;
/**
 * 1. 입력받은 정수 이하의 정수 중 나눴을 때 나머지가 0인 정수를 구한다.
 * 2. 해당 정수들을 배열에 넣고 sort한다. (길이가 몇일지 모르니 ArrayList사용)
 */

import java.util.*;

public class swea_1933 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();
        List<Integer> yaksus = new ArrayList<>();
        for(int idx=1; idx<=num; idx++){ // ArrayList에 약수 추가
            if(num % idx == 0){
                yaksus.add(idx);
            }
        }
        Collections.sort(yaksus); // ArrayList 오름차순 정렬
        for(int len = 0; len<yaksus.size(); len++){ //숫자만 출력해야 하므로
            System.out.print(yaksus.get(len)+" ");
        }
    }
}
