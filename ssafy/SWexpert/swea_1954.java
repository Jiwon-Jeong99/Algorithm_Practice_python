package exercise;
/**
 * swea_1954 달팽이 숫자
 * @author 정지원
 *
 * 1. 테스트케이스 입력받기
 * 2. 테스트케이스 수만큼 반복하여 N 받기
 * 3. N 입력받기
 * 4. 맵 틀 안에서 상하좌우로 좌표이동
 * 5. 맵 바깥에 나가거나 이미 거쳐간 곳이면 다시 빠꾸
 * 6. stringbuilder초기화해서 새로운 변수 넣을 수 있도록
 */
import java.util.Scanner;

public class swea_1954 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        StringBuilder sb = new StringBuilder();
        int testCase = scan.nextInt(); //테스트케이스 입력받기

        //우하좌상
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        for(int tc=1; tc<=testCase; tc++) { //테스트케이스 수만큼 반복

            int N = scan.nextInt(); //N 입력받기

            int[][] arr = new int[N][N]; //달팽이 형식으로 출력한 이차원 배열 생성

            int num=1;
            int x=0, y=0;//시작좌표
            int dir=0;//현재 방향 인덱스
            StringBuilder sb = new StringBuilder();
            while (num <= (N * N)) { // 해당 맵 틀안에서
                arr[y][x] = num++; // 수 추가
                int nextX = x + dx[dir];
                int nextY = y + dy[dir];

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N || arr[nextY][nextX] != 0) { // 배열 끝 or 이미 채워진 부분 만났을 때
                    dir = (dir + 1) % 4; // 방향 바꿔주기
                }
                x += dx[dir];
                y += dy[dir]; // 다음 좌표 이동
            }
            System.out.println(String.format("#%d", tc));
            //출력
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    System.out.print(arr[i][j]+ " ");
                }
                System.out.println();

  
            }


        }

    }
}

