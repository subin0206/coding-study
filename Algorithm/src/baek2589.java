import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class loc{
    int x, y,z;
    public loc(int x,int y,int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
public class baek2589 {

    static boolean[][] visited;
//    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int size1;
    static int size2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        size1 = Integer.parseInt(st.nextToken());
        size2 = Integer.parseInt(st.nextToken());
        char[][] map = new char[size1][size2];
        visited = new boolean[size1][size2];
        for (int i = 0; i < map.length; i++) {
            String str = br.readLine();
            for (int j = 0; j < size2; j++) {
                char ch = str.charAt(j);
                map[i][j] = ch;
            }
        }
        int max = 0;
        int bfsCount = 0;
        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size2; j++) {
                if (map[i][j] == 'L') {
                    visited = new boolean[size1][size2];
                    bfsCount = bfs3(map, i,j);
                    max = Math.max(max, bfsCount);
                }
            }
        }
       System.out.println(max);

    }
    public static int bfs3(char[][] map, int x, int y){
        Queue<loc> queue = new LinkedList<>();
        visited[x][y] = true;
        ((LinkedList<loc>) queue).add(new loc(x,y,0));

        int curX = 0;
        int curY = 0;
        int maxCount = 0;
        while (!queue.isEmpty()) {
            int x1 = queue.peek().x;
            int y1 = queue.peek().y;
            loc temp = queue.poll();
            for (int i = 0; i < 4; i++) {
                curX = x1 + dx[i];
                curY = y1 + dy[i];
                if (curX < size1 && curX >= 0 && curY < size2 && curY >= 0) {
                    if (map[curX][curY] == 'L' && visited[curX][curY] == false) {
                        visited[curX][curY] = true;
                        System.out.println(temp.z);
                        ((LinkedList<loc>) queue).offer(new loc(curX, curY, temp.z + 1));
                        maxCount = Math.max(maxCount, temp.z + 1);

                    }
                }
            }
        }
        return maxCount;
    }

}
