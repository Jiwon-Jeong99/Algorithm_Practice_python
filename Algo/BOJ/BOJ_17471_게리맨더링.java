package SAMSUNG;

/**
 * boj_17471 게리맨더링
 * 0.5초 512mb
 *
 * 문제
 * 1. n개의 구역. 1~n까지의 번호
 * 2. 2개의 선거구로 나눠야 한다.
 * 3. 각 구역은 2개 중 하나에는 꼭 포함되어야 한다.
 * 4. 한 선거구에 포함되어 있는 구역은 모두 연결되어야 한다.
 * 5. 2개의 선거구에 포함된 인구의 차이를 최소로 하려고 한다.
 *
 * 선거구를 나눌 수 없으면 -1
 *
 * input :
 * - 첫째줄 : 구역의 개수
 * - 둘째줄 : 1~n까지의 인구수
 * - 셋째줄 ~ n개 : 인접한 구역 개수, 구역 개수만큼 (구역 번호)
 * output : 두 선거구의 인구 차이의 최솟값
 *
 * 문풀
 * 1. 선거구수+1로 배열을 만든다.
 * 2. 선거구를 2개의 선거구로 나누는 부분집합
 * 3. bfs 혹은 dfs로 해당 선거구끼리 이어져 있는지 확인
 * 4. 만약 최소값이라면 갱신
 *
 * 5. 간선이 이어진 것끼리 인접행렬을 만들어서 연결
 *
 * 인접행렬
 * 부분집합으로 2개로 나눔
 * 연결되어 있는지 확인
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17471_게리맨더링 {
    static BufferedReader br;
    static StringTokenizer st;

    static int group; //선거구 수
    static int[] people; //선거구별 인구수
    static int[][] map; //인접행렬
    static int answer = Integer.MAX_VALUE;
    static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        group = Integer.parseInt(br.readLine().trim());

        //선거구+1로 1번부터 시작되는 선거구에 맞춘다.
        people = new int[group+1]; //인구수
        map = new int[group+1][group+1]; //인접행렬

        st = new StringTokenizer(br.readLine().trim());
        for(int idx=1; idx<=group; idx++) {
            people[idx] = Integer.parseInt(st.nextToken());
        }

        //인접행렬 입력
        for(int idx=1; idx<=group; idx++) {
            st = new StringTokenizer(br.readLine().trim());

            int num = Integer.parseInt(st.nextToken());
            for(int i=0; i<num; i++) {
                int node = Integer.parseInt(st.nextToken());

                map[idx][node] = map[node][idx] = 1;
            }
        }

        //2개 지역구 부분집합 구하기
        isSelected = new boolean[group+1];
        subset(1); //1부터 시작하니까

        //팀을 만들 수 없을 때는 -1 출력
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    //부분집합 메서드
    static void subset(int cnt) {
        if(cnt == group+1){ //인구수를 모두 선택해서 부분집합을 만들었을 때

            //두 팀이 각각 모두 연결되어 있는지 확인
            if(checkConnect(true) && checkConnect(false)){
                answer = Math.min(answer, gap());
            }
            return;
        }

        //부분집합에 포함
        isSelected[cnt] = true;
        subset(cnt+1); //다음 원소

        //부분집합에 불포함
        isSelected[cnt] = false;
        subset(cnt+1); //다음 원소
    }

    //bfs 메서드 - 연결되어 있는지 확인
    static boolean checkConnect(boolean flag) {
        boolean[] visited = new boolean[group+1];
        Queue<Integer> queue = new ArrayDeque<>();

        //시작점 찾기
        for(int idx=1; idx<=group; idx++){

            //부분집합 - 선택된거는 한팀, 선택 안된거는 자동으로 다른팀
            if(isSelected[idx] == flag){
                queue.offer(idx);
                visited[idx] = true;
                break;
            }
        }

        //연결되어 있는지 확인
        while(!queue.isEmpty()){
            int num = queue.poll();

            for(int index=1; index<=group; index++){

                //시작점 이거나 flag와 다른 팀이면 pass
                if(visited[index] || flag != isSelected[index]) continue;

                //연결되어 있다면
                if(map[num][index] == 1) {
                    queue.offer(index);

                    //또다른 시작점이 되는거니까
                    visited[index] = true;
                }
            }
        }

        //같은 flag팀인데 연결되지 않았다면 false
        for(int idx=1; idx<=group; idx++){

            //같은 flag인데 방문하지 않았다면 모든 정점이 연결되지 않은 것
            if(isSelected[idx] == flag && !visited[idx])
                return false;
        }

        return true;
    }

    //두팀의 인구수 차이 확인하는 메서드
    static int gap() {
        int groupA = 0;
        int groupB = 0;

        for(int idx=1; idx<=group; idx++){
            if(isSelected[idx]){ //부분집합에 포함된 팀
                groupA += people[idx];
            }else {
                groupB += people[idx];
            }
        }

        return Math.abs(groupA - groupB);
    }
}