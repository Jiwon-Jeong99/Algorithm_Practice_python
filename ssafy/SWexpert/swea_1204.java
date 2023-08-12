package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * swea_1204 최빈수 구하기
 *
 *
 */
public class swea_1204 {
    static BufferedReader br;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine().trim()); //테스트케이스 입력받기
        for(int tc=1; tc<=testCase; tc++){
            br.readLine(); //테스트케이스 정보는 필요없음

            int[] arr = new int[101]; //빈도 입력받을 배열
            st = new StringTokenizer(br.readLine().trim());
            //빈도수 체크
            for(int idx=0; idx<1000; idx++){
                arr[Integer.parseInt(st.nextToken())]++; //입력받을 수를 빈도 배열에 추가하기
            }

            int max = 0;
            int index = 0;
            //최빈값 구하기
            for(int num=0; num<101; num++){
                if(arr[num] >= max){
                    max = arr[num];
                    index = num;
                }
            }
            System.out.println("#"+tc+" "+index);
        }
    }
}
