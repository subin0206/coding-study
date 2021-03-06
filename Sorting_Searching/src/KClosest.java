import java.util.PriorityQueue;
import java.util.Queue;

public class KClosest {
    public static void main(String[] args) {
        KClosest a = new KClosest();
        int[][] points = { { 1, 3 }, { -2, 2 } };
        int k = 1;
//		int[][] points = {{3,3},{5,-1},{-2,4}};
//		int k =2;

        int[][] result = a.solve(points, k);
        a.print(result);
    }

    public int[][] solve(int[][] points, int k) {
        //1 ds
        Queue<int[]> pq = new PriorityQueue<>((a,b)->
                (a[0]*a[0]+a[1]*a[1])-(b[0]*b[0]+b[1]*b[1]));
        int [][] res = new int[k][2]; // k==1, 1행 2열

        //2 for
        for (int[] p : points) {
            pq.offer(p);
        }
        int index = 0;
        while(index<k){
            res[index] = pq.poll();
            index++;
        }
        return res;
    }
    public void print(int[][] result) {
        int m = result.length;
        int n = result[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(" [" + i + "][" + j + "] " + result[i][j]);
            }
            System.out.println();
        }
    }
}
