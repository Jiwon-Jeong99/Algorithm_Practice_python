package swea;
/**
 * swea_1208 Flatten;
 * @author 정지원
 *
 * 1. 입력받은 상자의 높이 수를 리스트에 넣는다.(전체 길이를 모르므로 ArrayList)
 * 2. 리스트를 오름차순으로 sort
 * 3. 마지막 인덱스에서 0번째 인덱스로 덤프하고, 숫자 바꾸기
 * 4. 카운팅하기
 * 5. 덤프가 모두 완료 되었을 때, 마지막 인덱스와 첫번째 인덱스의 차 출력
 *
 */
import java.util.Scanner;
import java.util.Arrays;

public class swea_1208 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        for(int tc=1; tc<=10; tc++) {
            int dump = scan.nextInt(); //덤프횟수 입력
            scan.nextLine(); //개행문자 처리

            String boxSize = scan.nextLine();//박스높이들 입력
            String[] string = boxSize.split(" ");
            int[] nums = new int[string.length];
            // String배열 -> int배열
            for(int idx=0; idx<string.length; idx++) {
                nums[idx] = Integer.parseInt(string[idx]);
            }

            int maxSize = 0;//최고 높이
            int minSize = 0;//최저 높이

            // 덤프 횟수가 0이상일 때,
            while(dump >= 0) {
                Arrays.sort(nums); //배열 정렬을 한 후에
                maxSize = nums[nums.length-1];//마지막 인덱스가 최고높이
                minSize = nums[0];//첫번째 인덱스가 최저높이

                //만약 차이가 1이하면 탈출
                if (maxSize - minSize <= 1) {
                    break;
                }

                nums[nums.length - 1]--;//최고높이에서 최저에 덤프
                nums[0]++;//상자 받아서 높아짐
                dump--;//덤프횟수 차감
            }
            Arrays.sort(nums);//마지막 배열 정렬
            System.out.println(String.format("#%d %d", tc, (maxSize - minSize)));
        }

    }
}
