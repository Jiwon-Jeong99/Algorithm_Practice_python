import java.util.Arrays;
import java.util.Scanner;

public class Solution_1983 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, k, a, b, c;
		double[] scores;
		String[] credit = {"D0", "C-", "C0", "C+", "B-", "B0", "B+", "A-", "A0", "A+"}; 
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {	
			n = sc.nextInt();
			k = sc.nextInt();
			scores = new double[n];
			for (int i = 0; i < n; i++) {
				a = sc.nextInt();
				b = sc.nextInt();
				c = sc.nextInt();
				scores[i] = 0.35*a + 0.45*b + 0.2*c;
			}
			
			String ans = "";
			double goal = scores[k-1];
			Arrays.sort(scores);
			for (int i = 0; i < n; i++) {
				if (goal == scores[i]) {
                    ans = credit[i/(n/10)];
                    break;
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
		sc.close();
	}
}
