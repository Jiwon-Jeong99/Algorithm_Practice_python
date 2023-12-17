package study.Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * boj_1976_여행가자
 * 2초 128mb
 *
 * 문제
 * 1. 도시 N개, 길이 있을수도-없을수도
 * 2. 다른 도시 경유 가능
 * 3. 같은 도시 여러번 방문 가능
 * 4. 1:연결, 0:비연결
 * => 여행계획에 따라 여행이 가능한지
 *
 * 문풀
 * 어떤 노드가 서로 연결되어 있는지 => 유니온파인드(부모노드가 같은지 확인하면 된다.)
 * https://steady-coding.tistory.com/109 => 플로이드와샬, 유니온파인드
 * 1. 인접행렬로 풀었다.
 * 2. 연결되어 있으면 true, 아니면 false
 */

public class BOJ_1976_여행가자 {
    static BufferedReader br;
    static StringTokenizer st;

    static int[][] graph; //인접행렬
    static int totalCity, planCity; //총도시개수, 계획도시개수
    static boolean[] visited; //방문배열
    static int[] planning; //여행계획
    static boolean flag; //여행가능여부

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        totalCity = Integer.parseInt(br.readLine().trim());
        planCity = Integer.parseInt(br.readLine().trim());

        flag = true;

        visited = new boolean[totalCity];
        graph = new int[totalCity][totalCity];
        planning = new int[planCity];

        //인접행렬 만들기
        for(int idx=0; idx<totalCity; idx++){
            st = new StringTokenizer(br.readLine().trim());
            for(int j=0; j<totalCity; j++){
                graph[idx][j] = Integer.parseInt(st.nextToken());
            }
        }

        //여행계획 배열에 담기
        st = new StringTokenizer(br.readLine().trim());
        for(int idx=0; idx<planCity; idx++){
            planning[idx] = Integer.parseInt(st.nextToken());
        }

        dfs(planning[0] - 1);

        //여행계획가능여부 판단
        for(int plans: planning){
            //실제 도시이고, 방문되지 않았는지 확인
            if(plans > 0 && !visited[plans-1]){
                flag = false; //방문되지 않았다면 false
                break;
            }
        }

        //flag가 true면 가능
        if(flag) System.out.println("YES");
        else System.out.println("NO");
    }

    //dfs로 도시끼리 연결되었는지 확인
    static void dfs(int num){
        visited[num] = true; //방문처리

        for(int idx=0; idx<totalCity; idx++){
            if(graph[num][idx] == 1 && !visited[idx]){ //연결되어 있고, 아직 방문하지 않았으면
                dfs(idx);
            }
        }
    }
}
