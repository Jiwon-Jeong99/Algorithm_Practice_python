package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author sahong.pak
 *
 * 1. 테스트 케이스 개수를 입력받는다.
 * 2. 각 테스트 케이스마다 농장의 크기와 농작물의 가치가 주어진다.
 * 3. 마름모 모양의 범위를 계산한다.
 *    3-1. 마름모 모양의 범위를 계산할때에는 (농장의 크기 / 2)를 기준으로,
 *         임의의 두 좌표의 거리를 구하는 식을 이용해서 계산한다.
 *         |X2 - X1| + |Y2 - Y1| 식으로 계산한다.
 *
 */
public class swea_2805_RETRY {
    static BufferedReader br; // 입력을 위해 사용.
    static StringBuilder sb; // 출력을 위해서 사용.
    static int mapSize;
    static int distance;
    static int totalProfit; // 항상 주의

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        // 1. 테스트 케이스 개수를 입력받는다.
        int testCase = Integer.parseInt(br.readLine().trim());

        // 2. 테스트 케이스 개수만큼 반복한다.
        for(int tc = 1; tc <= testCase; tc++) {
            // 0. 초기화
            totalProfit = 0;

            // 3. 농작물의 크기를 입력받는다.
            mapSize = Integer.parseInt(br.readLine().trim());
            distance = mapSize >> 1; // 절반으로 나누기.

            // 4. 농작물의 가치를 입력받는다.
            for(int rowIdx = 0; rowIdx < mapSize; rowIdx++) {

                // 한 줄을 입력받는다.
                String line = br.readLine().trim();

                for(int colIdx = 0; colIdx < mapSize; colIdx++) {
                    // 한 줄에서 하나의 농작물 가치를 가져와야하는데,,,
                    // line.charAt(colIdx); // 이 상태에서는 하나의 값이 어떤 형태? char
                    // 우리가 실제로 필요한 값은? 정수형태.
                    // int tmp = line.charAt(colIdx) - '0';
                    // map[rowIdx][colIdx] = tmp;

                    // 바로 거리를 계산해서 값을 더해주자.
                    // |X2 - X1| + |Y2 - Y1|
                    if(Math.abs(rowIdx - distance) + Math.abs(colIdx - distance) <= distance) {
                        totalProfit += line.charAt(colIdx) - '0';
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(totalProfit).append("\n");
        }

        System.out.println(sb);

    }
}