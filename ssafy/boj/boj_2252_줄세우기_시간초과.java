package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * boj_2252 줄세우기
 * 
 * @author 정지원
 * 
 * 1. 만약 이미 list에 존재하는 학생이 있으면 그 앞 or 뒤에 순서대로 넣기 
 * 2. 만약 list에 없으면 그냥 뒤에 순서대로 넣기
 *
 */
public class boj_2252_줄세우기_시간초과 {
	static BufferedReader br;
	static StringTokenizer st;

	static int total; // 학생 수
	static int compareCnt; // 비교한 횟수
	static List<Integer> students = new ArrayList<>(); // 학생 줄선 리스트

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine().trim());
		total = Integer.parseInt(st.nextToken());
		compareCnt = Integer.parseInt(st.nextToken());

		for (int tc = 0; tc < compareCnt; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			int little = Integer.parseInt(st.nextToken());
			int big = Integer.parseInt(st.nextToken());

			if (!students.contains(little) && !students.contains(big)) {
				students.add(little);
				students.add(big);
			} else if (students.contains(little) && !students.contains(big)) {
				students.add(big);
			} else if (!students.contains(little) && students.contains(big)) {
				int index = students.indexOf(big);
				students.add(index, little);
			}
		}
		for (int idx = 0; idx < students.size(); idx++) {
			System.out.print(students.get(idx) + " ");
		}
	}
}
