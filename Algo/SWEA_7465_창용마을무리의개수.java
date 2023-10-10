package SWEA;

import java.util.ArrayList;
import java.util.Scanner;


public class SWEA_7465_창용마을무리의개수 {
    static int res;
    static int N, M; // N 사람수, M관계수
    static ArrayList<Integer>[] list;
    static int[] v;
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int TC = sc.nextInt();
        for(int t = 1; t <= TC; t++) {
            res = 0;
            N = sc.nextInt();
            M = sc.nextInt();
            //관계표시, 행렬, 리스트
            list = new ArrayList[N+1]; //N명 +1 만큼의 배열크기
            for(int i = 0 ;i <=N; i++) {
                list[i] = new ArrayList<Integer>();
            }
            v = new int[N+1];  //0
            int x,y;
            for(int i =0; i < M; i++) { //관계수
                x = sc.nextInt();
                y = sc.nextInt();    
                list[x].add(y);
                list[y].add(x);
            }//입력 완료
            
            //구현
            for(int i = 1; i <= N; i++) {
                if(v[i] == 1) { //어느무리진 모르지만 다른 집단에 포함된 경우
                    continue;
                }
                res++;
                dfs(i);
            }
            
            //출력
            System.out.println("#"+t + " " + res);
        }

    }
    private static void dfs(int idx) {
        //종료조건
        
        //실행반복호출
        v[idx] = 1;
        for(Integer p : list[idx]) {
            if(v[p] == 1) {
                continue;
            }
            dfs(p);
        }
        
    }

}