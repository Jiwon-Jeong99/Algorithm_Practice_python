package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * boj_20299 3대 측정
 *
 * vip클럽에 가입할 수 있는 조건을 체크하는 메서드를 만들어 확인하고 조건에 부합하면 sb에 추가한다.
 */
public class boj_20299 {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;

    static int totalTeam; //팀의 수
    static int threeClub; //3명합에 대한 클럽 가입 조건
    static int oneClub; //개인 클럽 가입 조건
    static int clubNum; //vip클럽 팀 수
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        //팀수, 팀원3명합, 1명당 최소조건 입력
        st = new StringTokenizer(br.readLine().trim());
        totalTeam = Integer.parseInt(st.nextToken());
        threeClub = Integer.parseInt(st.nextToken());
        oneClub = Integer.parseInt(st.nextToken());

        sb = new StringBuilder(); //답 출력
        clubNum = 0; //vip클럽 팀 수 초기화

        for(int tc=0; tc<totalTeam; tc++){ //팀의 수만큼 반복
            st = new StringTokenizer(br.readLine().trim());
            int person1 = Integer.parseInt(st.nextToken());
            int person2 = Integer.parseInt(st.nextToken());
            int person3 = Integer.parseInt(st.nextToken());
            checkVip(person1, person2, person3);
        }
        System.out.println(clubNum);
        System.out.print(sb);
    }

    //vip클럽에 해당하는 팀을 추가하는 메서드
    private static void checkVip(int person1, int person2, int person3) {
        if(person1+person2+person3 >= threeClub && person1 >= oneClub && person2 >= oneClub && person3 >= oneClub){
            clubNum++;
            sb.append(person1).append(" ").append(person2).append(" ").append(person3).append(" ");
        }
    }
}
