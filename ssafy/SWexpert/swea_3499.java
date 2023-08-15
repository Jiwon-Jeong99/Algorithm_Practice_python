package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * swea_3499
 *
 * 1. 카드 내용을 배열에 split으로 저장한다.
 * 2. 카드 개수가 짝수) 개수/2까지 배열 하나, 그 이후 배열하나를 만든다.
 * 3. 카드 개수가 홀수) ~개수/2인덱스+1 배열하나, 그 이후 배열 하나를 만든다.
 * 4.               먼저 한개를 sb에 추가한 다음에 for문을 돌며 차례대로 하나씩 추가한다.
 */
public class swea_3499 {
    static BufferedReader br;
    static StringBuilder sb;

    static int size; //카드의 개수
    static String[] cards; //카드를 담은 배열
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine().trim());
        for(int tc=1; tc<=testCase; tc++){
            sb = new StringBuilder();
            size = Integer.parseInt(br.readLine().trim()); //카드 개수
            cards = br.readLine().trim().split(" "); //카드 담은 배열

            sb.append("#").append(tc).append(" ");
            shuffle(size);

            System.out.println(sb);
        }
    }
    //카드 반환하는 메서드
    public static void shuffle(int size) {
        if(size % 2 == 0){ //카드 개수가 짝수라면
            String[] even1 = Arrays.copyOfRange(cards, 0, size/2); //인덱스 자르기
            String[] even2 = Arrays.copyOfRange(cards, size/2, size);

            for(int idx=0; idx<even1.length; idx++){ //for문을 돌면서 index에 맞게 순차적으로 sb에 추가
                sb.append(even1[idx]).append(" ").append(even2[idx]).append(" ");
            }
        }else{ //카드 개수가 홀수라면
            String[] odd1 = Arrays.copyOfRange(cards, 0, (size/2)+1);
            String[] odd2 = Arrays.copyOfRange(cards, size/2+1, size);

            sb.append(odd1[0]).append(" "); //첫번째 원소를 먼저 출력하고
            for(int index=0; index< odd2.length; index++){ //for문을 돌면서 index에 맞게 순차적으로 sb에 추가
                sb.append(odd2[index]).append(" ").append(odd1[index+1]).append(" ");
            }
        }
    }
}
