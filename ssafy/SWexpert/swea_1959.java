package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * swea_1959
 * @author 정지원
 *
 */
public class swea_1959 {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;

    static int aSize; //a문자열의 길이
    static int bSize; //b문자열의 길이
    static int[] aArr; //a문자열
    static int[] bArr; //b문자열

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine().trim());
        for(int tc=1; tc<=testCase; tc++){
            st = new StringTokenizer(br.readLine().trim());
            aSize = Integer.parseInt(st.nextToken());
            bSize = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine().trim());
            aArr = new int[aSize];
            for(int aIdx=0; aIdx<aSize; aIdx++){
                aArr[aIdx] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine().trim());
            bArr = new int[bSize];
            for(int bIdx=0; bIdx<bSize; bIdx++){
                bArr[bIdx] = Integer.parseInt(st.nextToken());
            }
            int answer = multiple();
            System.out.println("#"+tc+" "+answer);

        }
    }

    static int multiple() {
        int sum = 0;
        if(aSize > bSize){
            for(int idx=0; idx<aSize-bSize+1; idx++){
                int max = 0;
                for(int jdx=0; jdx<bSize; jdx++){
                    max += aArr[idx+jdx] * bArr[jdx];
                }
                sum = Math.max(sum, max);
            }
            return sum;
        }else if(aSize < bSize){
            for(int idx=0; idx<bSize-aSize+1; idx++){
                int max = 0;
                for(int jdx=0; jdx<aSize; jdx++){
                    max += bArr[idx+jdx] * aArr[jdx];
                }
                sum = Math.max(sum, max);
            }
            return sum;
        }else{
            for(int i=0; i<aSize; i++){
                sum += aArr[i]*bArr[i];
            }
            return sum;
        }
    }
}