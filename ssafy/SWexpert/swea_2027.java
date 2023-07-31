package swea;

/**
 * 1. StringBuilder를 이용해서 가변 문자열을 만든다.
 * 2. charAt을 이용해서 해당 위치 문자열을 바꾼다. (setCharAt)
 */
public class swea_2027 {
    public static void main(String[] args) {
        for(int idx=0; idx<5; idx++){
            StringBuilder sb = new StringBuilder("+++++");
            sb.setCharAt(idx, '#');
            System.out.println(sb.toString());
        }
    }
}
