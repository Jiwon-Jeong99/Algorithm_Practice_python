package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 */
public class swea_2005_파스칼의삼각형 {
    static BufferedReader br;
    static int size; //삼각형의 사이즈
    static int[][] pascal; //파스칼의 삼각형 이차원 배열
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine().trim());
        for(int tc=1; tc<=testCase; tc++){
            size = Integer.parseInt(br.readLine().trim());
            pascal = new int[size][size];

            for(int row=0; row<size; row++){
                for(int col=0; col<=row; col++){
                    if(row == col) { //한줄의 가장 마지막
                        pascal[row][col] = 1;
                    }else if(col == 0){ //한줄의 가장 첫번째
                        pascal[row][col] = 1;
                    }else{
                        pascal[row][col] = pascal[row-1][col-1] + pascal[row-1][col];
                    }
                }
            }

            System.out.println("#"+tc);
            for(int i=0; i<size; i++){
                for(int j=0; j<=i; j++){
                    System.out.print(pascal[i][j]+" ");
                }
                System.out.println();
            }
        }
    }
}
