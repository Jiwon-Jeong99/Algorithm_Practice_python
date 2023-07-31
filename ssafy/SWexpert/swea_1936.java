package swea;
import java.util.Scanner;
public class swea_1936 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int aRoll = scan.nextInt();
        int bRoll = scan.nextInt();

        if(aRoll == 1){
            if(bRoll == 2) System.out.println("B");
            else System.out.println("A");
        } else if(aRoll == 2){
            if(bRoll == 3) System.out.println("B");
            else System.out.println("A");
        } else if (aRoll == 3) {
            if(bRoll == 1) System.out.println("B");
            else System.out.println("A");
        }
    }
}
