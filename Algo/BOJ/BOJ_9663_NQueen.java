package boj;
/**
 * boj_9663 NQueen
 * 10초 128mb
 *
 * 백트래킹
 *
 * 문제
 * 1. nxn 체스판 위에 퀸 n개를 서로 공격할 수 없게 놓아라
 * 2. n이 주어졌을때, 퀸을 놓는 방법의 수를 구하라
 *
 * 문풀
 * 1. 퀸은 같은 행, 열, 대각선으로 움직일 수 있다.
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9663_NQueen {
    static BufferedReader br;

    static int size; //맵의 사이즈
    static int[] arr; //2차원 배열을 1차원 배열로 압축
    static int cnt = 0; //총가짓수

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        size = Integer.parseInt(br.readLine().trim());

        arr = new int[size];

        dfs(0);
        System.out.println(cnt);
    }

    //dfs
    public static void dfs(int depth) {

        //주어진 퀸의 개수를 다 놓았다면
        if(depth == size){
            cnt++; //경우의 수 추가
            return;
        }

        //[0,0,0,0] 각 인덱스는 행이고, 각 인덱스의 값은 퀸이 위치한 열의 인덱스가 된다.
        for(int idx=0; idx<size; idx++){
            arr[depth] = idx;

            if(isPosstible(depth)){
                System.out.println("arr[depth]" + arr[depth]);
                System.out.println("depth" + depth);

                //각 행에 놓인 인덱스의 값(열)에 따라 달라지는
                //[0~~] -> [1~~] -> [2~~]
                dfs(depth+1); //퀸 놓는게 가능하면 다음 행으로 이동
//                System.out.println("depth" + depth);
            }
        }
    }

    //퀸을 해당 장소에 놓는게 가능한지 판별하는 메서드
    public static boolean isPosstible(int col) {
        for(int idx=0; idx<col; idx++){
            //열이 일치하는게 있는지 판별
            if(arr[idx] == arr[col]){
                return false;
            }
            //대각선에 일치하는게 있는지 판별
            else if(Math.abs(col-idx) == Math.abs(arr[col] - arr[idx])) {
                return false;
            }
            System.out.print(arr[idx]+" ");
            System.out.print(arr[col]);
            System.out.println("idx : "+idx);
        }

        return true;
    }
}
