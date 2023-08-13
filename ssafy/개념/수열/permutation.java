package 실습;

public class permutation {
    static final int n = 3;
    static final int r = 2;

    static int[] numList;
    static boolean[] visited;
    static int[] selectList;

    public static void permutation(int depth){
        if(depth == r){
            for(int idx=0; idx<r; idx++){
                System.out.print(selectList[idx]+" ");
            }
            System.out.println();
            return;
        }
        for(int num=0; num<n; num++){
            if(visited[num]){
                continue;
            }
            visited[num] = true;
            selectList[depth] = numList[num];
            permutation(depth+1);
            visited[num] = false;
        }
    }
    public static void main(String[] args) {
        numList = new int[] {1,2,3};
        visited = new boolean[n];
        selectList = new int[r];
        permutation(0);
    }
}
