import java.util.*;

public class baek2606 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int e = s.nextInt();
        int[][] array = new int[n+1][n+1];
        boolean visited[] = new boolean[n+1];
//        LinkedList<Integer>[] adjList = new LinkedList[n+1];
//
//        for (int i = 0; i < n; i++) {
//            adjList[i] = new LinkedList<Integer>();
//        }
        for (int i = 0; i < e; i++) {
            int n1 = s.nextInt();
            int n2 = s.nextInt();
            array[n1][n2] = 1;
            array[n2][n1] = 1;
//            adjList[n1].add(n2);
//            adjList[n2].add(n1);
        }
        System.out.println(bfs(1,array,visited )-1);
    }

    public static int bfs(int v,int[][] array, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[v] = true;
        int n = array.length-1;
        ((LinkedList<Integer>) queue).add(v);
        visited[v] = true;
        int count =0;
        while (!queue.isEmpty()) {
            v = queue.poll();
            for (int i = 1; i <= n; i++) {
                if (array[v][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
            count++;
        }
        return count;
    }
}
