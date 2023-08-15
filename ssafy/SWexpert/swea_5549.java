package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_5549 {
    static BufferedReader br;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine().trim());
        for(int tc=1; tc<=testCase; tc++){
            String[] num = br.readLine().trim().split("");

            if(num[num.length-1].equals("1") || num[num.length-1].equals("3") || num[num.length-1].equals("5") || num[num.length-1].equals("7") ||num[num.length-1].equals("9")){
                System.out.println("#"+tc+" "+"Odd");
            }else{
                System.out.println("#"+tc+" "+"Even");
            }
        }
    }
}
