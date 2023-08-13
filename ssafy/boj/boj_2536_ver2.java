package boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class boj_2536_ver2 {
    // 색종이 수
    static int confettiCount;
    static int[][] paper;
    static final int confettiSize = 10;
    static final int paperSize = 100;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        confettiCount = Integer.parseInt(br.readLine());
        paper = new int[paperSize][paperSize];

        for(int count = 0; count<confettiCount; count++) {
            st = new StringTokenizer(br.readLine());

            // 색종이의 왼쪽 변과 도화지의 왼쪽 변 사이의 거리
            int leftDiff = Integer.parseInt(st.nextToken());

            // 색종이의 아래쪽 변과 도화지의 아래쪽 변 사이의 거리
            int downDiff = Integer.parseInt(st.nextToken());

            for(int row=downDiff; row<downDiff+confettiSize; row++) {
                for(int col=leftDiff; col<leftDiff+confettiSize; col++) {
                    paper[row][col] = 1;
                }
            }
        }

        // 색종이 칠한 부분 구하기
        int answer = 0;
        for(int row=0; row<paperSize; row++) {
            for(int col=0; col<paperSize; col++) {
                if(paper[row][col] == 1) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
