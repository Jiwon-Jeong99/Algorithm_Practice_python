package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * swea_1233 사칙연산유효성검사
 * @author 정지원
 *
 * 유효성이 통과되면 1, 불통이면 0
 * 유효성이 통과되기 위한 조건
 * 1. 노드의 개수 nodesCnt -> 2n+1 홀수여야 한다.(그래야 부모 노드 양쪽이 다 채워짐)
 * 2. 단말노드를 제외한 모든 노드의 노드 연결점이 2n, 2n+1이 존재하여야 한다.
 * 3. 노드 2n, 2n+1이 있는 노드 n이라면 숫자가 아닌 알파벳이어야 한다.
 * 4. 단말 노드에는 정수만 존재해야 한다.
 */
public class swea_1233 {
	static BufferedReader br;
	static StringTokenizer st;
	
	static int nodesCnt; //노드 개수
	static int nodeNum; //노드 번호
	static String nodeValue; //노드 정보
	static int leftNode; //좌측 노드
	static int rightNode; //우측 노드
	
	public static void main(String[] args) throws IOException, NumberFormatException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			int answer = 1; //유효성 세팅
			nodesCnt = Integer.parseInt(br.readLine().trim()); //노드 개수

			for(int nd=1; nd<=nodesCnt; nd++) {
				st = new StringTokenizer(br.readLine().trim());
				nodeNum = Integer.parseInt(st.nextToken()); //노드 번호
				String nodeValue = st.nextToken(); //노드 정보
				//좌, 우측 노드는 노드 상황에 따라 선택적이므로
				if(st.hasMoreTokens()) { //단말노드가 아닐 때
					if(nodeValue.charAt(0) >= 48) answer=0; //아스키코드 숫자라면 유효성 불통
				}else {//단말 노드 일때
					if(nodeValue.charAt(0) < 48) answer=0; //아스키코드 연산자라면 유효성 불통
				}
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
}
