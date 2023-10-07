package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * boj_13458 시험감독
 * 2초 512mb
 *
 * 문제
 * 1. n개의 시험장마다 응시자 존재
 * 2. 시험장마다 총감독관은 오직 1명만, 부감독관은 여러명 가능
 * 3. 총감독관은 감시할 수 있는 응시자 B, 부감독관은 감시할 수 있는 응시자 C
 * 4. 모든 응시자들을 감시해야 한다.
 *
 * input : 시험장 개수, 응시자수, B/C
 * output : 필요한 감독관 수의 최솟값
 *
 * 문풀
 * 1. 시험장 별 응시자수에서 총감독이 감시할 수 있는 응시자 수를 뺀다.
 * => 값의 크기를 조심할 것!! int인지 long인지
 */

public class BOJ_13458_시험감독 {
    static BufferedReader br;
    static StringTokenizer st;

    static int totalClass; //시험장 개수
    static int[] students; //응시자수
    static int main, sub; //총감독관 감시가능 응시자수, 부감독관 감시가능 응시자수
    static long total = 0; //필요한 총 감독수

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));

        totalClass = Integer.parseInt(br.readLine().trim());

        students = new int[totalClass];

        st = new StringTokenizer(br.readLine().trim());
        for(int idx=0; idx<totalClass; idx++){
            students[idx] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine().trim());
        main = Integer.parseInt(st.nextToken());
        sub = Integer.parseInt(st.nextToken());

        //부감독 수를 센다.
        for(int idx=0; idx<totalClass; idx++){
            //총감독은 1명씩 필요하니까
            students[idx] -= main;
            total++;

            //부감독
            if(students[idx] > 0){
                if(students[idx] % sub == 0){
                    total += students[idx] / sub;
                }else{
                    total += students[idx] / sub + 1;
                }
            }
        }

        System.out.println(total);

    }
}
