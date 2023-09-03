package boj;
/**
 * boj_12891 DNA비밀번호
 * 새로운 방법으로 풀기
 *
 * 1. 문제
 * - ACGT - DNA문자열
 * - 문자의 개수가 특정 개수 이상이여야
 * - 등장하는 문자열이 같더라도 순서가 다르면 다른 문자열
 *
 * 2. 문풀
 * 정해진 길이가 있기 때문에 슬라이딩 윈도우 개념 사용(길이가 유동적이라면 투포인터)
 * 정해진 문자열 길이가 주어진 문자개수만큼 있지 않다면 첫번째 문자열을 삭제하고 다음 문자열을 넣어서 다시 비교
 * 문자열 일일이 비교하는것보다 개수를 비교하는게 더 빠름
 * 1. 주어진 길이만큼 잘라서 주어진 문자개수 이상인지 확인
 * 2. 맞다면 count 올리기
 * 3. 다시 첫번째 인덱스 개수 감소시키고 다음 인덱스 char 증가시키기
 * 4. count 반환
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12891_DNA비밀번호 {
    static BufferedReader br;
    static StringTokenizer st;

    static int length; //주어진 문자열 길이
    static int selectLength; //string 길이
    static char[] dnaArr; //주어진 문자열
    static int[] dna; //dna 최소개수 ACGT
    static int[] selectDna; //선택된 dna 개수
    static int count;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine().trim());
        length = Integer.parseInt(st.nextToken());
        selectLength = Integer.parseInt(st.nextToken());

        dnaArr = br.readLine().trim().toCharArray();

        st = new StringTokenizer(br.readLine().trim());
        dna = new int[4];
        selectDna= new int[4];

        //몇이상이어야 하는지
        for(int idx=0; idx<4; idx++){
            dna[idx] = Integer.parseInt(st.nextToken());
        }

        count = 0;

        //처음 선택된 문자열 길이만큼 초기값 넣기
        for(int startIndex=0; startIndex<selectLength; startIndex++){
            if(dnaArr[startIndex] == 'A') selectDna[0]++;
            else if (dnaArr[startIndex] == 'C') selectDna[1]++;
            else if (dnaArr[startIndex] == 'G') selectDna[2]++;
            else if (dnaArr[startIndex] == 'T') selectDna[3]++;
        }

        //만약 초기값이 비밀번호 된다면
        if(isPassword()) count++;

        //선택할 문자열 길이 돌면서 해당 조건에 맞는 문자열이 있는지 확인
        for(int index=selectLength, start = 0; index<length; index++){

            //이전 char 없애기
            if (dnaArr[start] == 'A') selectDna[0]--;
            if (dnaArr[start] == 'C') selectDna[1]--;
            if (dnaArr[start] == 'G') selectDna[2]--;
            if (dnaArr[start] == 'T') selectDna[3]--;

            //다음 char 넣기
            if (dnaArr[index] == 'A') selectDna[0]++;
            if (dnaArr[index] == 'C') selectDna[1]++;
            if (dnaArr[index] == 'G') selectDna[2]++;
            if (dnaArr[index] == 'T') selectDna[3]++;

            start++; //시작지점 카운트 올려주기
            if(isPassword()) count++;
        }
        System.out.println(count);
    }

    //제시한 개수 이상인지 확인하는 메서드
    static boolean isPassword() {
        for(int idx=0; idx<4; idx++){
            if(selectDna[idx] < dna[idx]) return false;
        }
        return true;
    }
}
