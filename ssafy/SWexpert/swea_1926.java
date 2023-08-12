package swea;
/**
 * 1. 숫자를 string으로 바꿔서 3,6,9를 포함하면 -로 replace
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_1926 {
    static BufferedReader br;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine().trim());

        for(int nums=1; nums<=num; nums++){
            String strNum = Integer.toString(nums);
            if(strNum.contains("3") ||strNum.contains("6") ||strNum.contains("9")){
                strNum = strNum.replace("3","-"); //3,6,9는 -로 replace
                strNum = strNum.replace("6","-");
                strNum = strNum.replace("9","-");
                strNum = strNum.replace("0","");
                strNum = strNum.replace("1","");
                strNum = strNum.replace("2","");
                strNum = strNum.replace("4","");
                strNum = strNum.replace("5","");
                strNum = strNum.replace("7","");
                strNum = strNum.replace("8","");
            }
            System.out.print(strNum+" ");
        }
    }
}
