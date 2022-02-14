import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Loc{
    int x,y,z;

    public Loc(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
public class baek7576 {
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    static boolean[][] visited;
    static boolean[][] checked1;
    static int n,m;
    static int days;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] tomatoes= new int[m][n];
        visited = new boolean[m][n];
        checked1 = new boolean[m][n];
        ArrayList<Integer> result = new ArrayList();
        Queue<Loc> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                tomatoes[i][j] = Integer.parseInt(st.nextToken());
                if (tomatoes[i][j] == 1) {
//                    visited[i][j] = true;
//                    checked1[i][j] = true;
//                    bfs4(tomatoes,i,j);
                    visited[i][j] = true;
                    queue.offer(new Loc(i,j,0));
                }
            }
        }
        System.out.println(Arrays.deepToString(tomatoes));
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (tomatoes[i][j] == 1 ) {
////                    checked1[i][j] = true;
//                    visited[i][j] = true;
//                    days++;
//
//                }
//            }
//        }
        bfs4(queue,tomatoes);
        System.out.println(Arrays.deepToString(tomatoes));
    }
    public static void bfs4(Queue<Loc> queue,int[][] tomatoes){
        int curX = 0;
        int curY = 0;
        int day = 0;
        int count = 0;
//        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int x1 = queue.peek().x;
            int y1 = queue.peek().y;
            Loc temp = queue.poll();
            days = temp.z;
            for (int i = 0; i < dir.length; i++) {
                curX = x1 + dir[i][0];
                curY = y1 + dir[i][1];
                if(curX >= m || curX<0) continue;
                if(curY >= n || curY<0) continue;
                if (tomatoes[curX][curY] == 0) {
                    queue.offer(new Loc(curX, curY, temp.z+1));
                    tomatoes[curX][curY] = 1;
                    count = temp.z+1;
//                    System.out.println(count);
                    day = Math.max(day, count);

                }
                else if (tomatoes[curX][curY] == -1 && !visited[curX][curY]) {
                    visited[curX][curY] =true;
                }
            }
        }
        for (int i = 0; i < tomatoes.length; i++) {
            for (int j = 0; j < tomatoes[0].length; j++) {
                if(tomatoes[i][j]==0){
                    day = -1;
                }
            }
        }
        System.out.println(day);
    }
}
