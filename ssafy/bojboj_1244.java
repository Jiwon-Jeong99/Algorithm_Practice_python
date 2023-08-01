package boj;
/**
 * boj_1244 스위치 켜고 끄기
 * @author 정지원
 *
 * 1. 스위치의 개수를 입력받아 int배열 생성
 * 2. 여자, 남자일 때를 switch문으로 각각의 로직으로 이동
 * 3. 남자는 입력받은 num에 해당하는 인덱스(num-1)를 0->1, 1->0으로 바꿔줌
 * 4. 여자는 입력받은 num에서 양쪽으로 갈 수 있는 최대를 구한 다음, 값이 같은지 비교 1->0, 0->1
 * 5. 출력시, 20개 초과하면 21개부터 다음줄에 출력하도록
 * 에러 요인 : changeSwitchWoman의 switchIdx<maxPoint를 해주어서.
 * maxPoint까지 포함하는 로직을 짜놓고 포함안시킴.
 */
import java.util.Scanner;

public class boj_1244 {
    //남학생일 때 스위치 바꾸는 함수 - 배수
    public static int[] changeSwitchMan(int[] arr, int num) {
        for(int switchIdx=num-1; switchIdx<arr.length; switchIdx += num) {
            arr[switchIdx] = 1 - arr[switchIdx]; //0->1, 1->0
        }
        return arr;
    }
    //여학생일 때 스위치 바꾸는 함수 - 대칭인 곳까지
    public static int[] changeSwitchWoman(int[] arr, int num) {
        // 스위치 배열의 인덱스가 끝으로 갈 때까지 대칭인지 확인
        arr[num-1] = 1-arr[num-1]; // 받은 num에 해당하는 인덱스 스위치 바꾸기

        // 양쪽으로 대칭을 확인할 수 있는 최대 인덱스 범위를 확인하기
        int maxPoint = Math.min(num-1, arr.length-num);

        for(int switchIdx=1; switchIdx<=maxPoint; switchIdx++) {
            if(arr[num-1-switchIdx] == arr[num-1+switchIdx]) {
                arr[num-1-switchIdx] = 1-arr[num-1-switchIdx];
                arr[num-1+switchIdx] = 1-arr[num-1+switchIdx];
            }else break;
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int switchNum = scan.nextInt();//스위치 개수
        int[] switches = new int[switchNum]; //스위치 정보 담을 int배열
        for(int idx=0; idx<switchNum; idx++){
            switches[idx] = scan.nextInt();
        }

        int student = scan.nextInt(); //학생수 입력받기
        scan.nextLine();
        for(int stu=0; stu<student; stu++) {
            int sex = scan.nextInt(); //성별 입력받기
            int num = scan.nextInt(); //숫자 입력받기
            scan.nextLine(); //개행 없애기

            switch(sex) { //성별에 따른 로직 분리 switch
                case 1: switches = changeSwitchMan(switches, num); //남자일때 로직
                    break;
                case 2: switches = changeSwitchWoman(switches, num); //여자일때 로직
                    break;
            }
        }
        for(int finalIdx = 0; finalIdx < switches.length; finalIdx++) {
            System.out.print(switches[finalIdx] + " ");
            if((finalIdx + 1)%20 == 0){
                System.out.println(); //한줄에 20개씩 출력
            }
        }
        scan.close();
    }
}
