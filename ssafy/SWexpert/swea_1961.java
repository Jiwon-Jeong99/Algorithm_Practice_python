package swea;

import java.util.Scanner;

public class swea_1961 {
    static int[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for(int tc = 1; tc <= testCase; tc++) {
            int size = sc.nextInt();
            int[][] a = new int[size][size];
            for(int idx = 0; idx < size; idx++) {
                for(int id = 0; id < size; id++) {
                    a[idx][id] = sc.nextInt();
                }
            }
            System.out.println("#" + tc + " ");
            for(int i = 0; i < size; i++) {
                for(int j = 0; j < size; j++) {
                    System.out.print(a[size-j-1][i]);
                }
                System.out.print(" ");
                for(int j = 0; j < size; j++) {
                    System.out.print(a[size-i-1][size-j-1]);
                }
                System.out.print(" ");
                for(int j = 0; j < size; j++) {
                    System.out.print(a[j][size-1-i]);
                }
                System.out.println();
            }
        }
    }
}