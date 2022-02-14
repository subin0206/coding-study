import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.*;

public class baek2667 {
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int n,m;
        int[][] map= new int[size][size];
        ArrayList<Integer> result = new ArrayList();
        for (int i = 0; i < map.length; i++) {
            String[] st = br.readLine().split("");
            for (int j = 0; j < st.length; j++) {
                map[i][j] = Integer.parseInt(st[j]);
            }
        }
        visited = new boolean[size][size];
        int resultCount = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    resultCount++;
                    result.add(bfs2(i,j,map,visited));
                }
            }
        }
        result.sort(Comparator.naturalOrder());
        System.out.println(resultCount);
        for (int i : result) {
            System.out.println(i);
        }
    }
    public static int bfs2(int x, int y, int[][] array, boolean visited[][]){
        Queue<Point> q = new LinkedList<>();
        ((LinkedList<Point>) q).push(new Point(x,y));
//        ((LinkedList<HashMap<Integer, Integer>>) q).add();
        visited[x][y] = true;
        int curX = 0;
        int curY = 0;
        int n = array.length-1;
        int count =0;
        while (!q.isEmpty()) {
            int x1 = q.peek().x;
            int y1 = q.peek().y;
            q.poll();
            for (int i = 0; i < dir.length; i++) {
                curX = x1 + dir[i][0];
                curY = y1 + dir[i][1];
                if(curX >= array.length || curX<0) continue;
                if(curY >= array.length || curY<0) continue;
                if (array[curX][curY] == 1 && visited[curX][curY] == false) {
//                    ((LinkedList<Point>) q).add(new Point(curX,curY));
                    ((LinkedList<Point>) q).push(new Point(curX, curY));
                    visited[curX][curY] = true;
                }
            }
            count++;
        }
        return count;
    }
}
