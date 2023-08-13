package 실습;

public class combination {
    static final int n = 3;
    static final int r = 2;

    static int[] numList;
    static int[] selectList;

    public static void combination(int start, int depth){
        if(depth == r){
            for(int idx=0; idx<r; idx++){
                System.out.print(selectList[idx]+" ");
            }
            System.out.println();
            return;
        }
        if(start == 3){
            return;
        }

        selectList[depth] = numList[start];
        combination(start+1, depth+1);

        selectList[depth] = 0;
        combination(start+1, depth);
    }
    public static void main(String[] args) {
        numList = new int[] {1,2,3};
        selectList = new int[r];
        combination(0,0);
    }
}
