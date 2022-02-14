import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class sLoc{
    int x,y;
    public sLoc(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class baek3055 {
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    static boolean[][] visited;
    static boolean[][] checked1;
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sr = new StringTokenizer(br.readLine());
        m = Integer.parseInt(sr.nextToken());
        n = Integer.parseInt(sr.nextToken());
        int destX = 0;
        int destY = 0;
        char[][] map = new char[m][n];
        Queue<sLoc> sQueue = new LinkedList<>();
        Queue<sLoc> wQueue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                char s = str.charAt(j);
                map[i][j] = s;
                if(s=='S'){
                    sQueue.offer(new sLoc(i,j));
                }
                if (s == '*') {
                    wQueue.offer(new sLoc(i,j));

                }
            }
        }
        int result = bfs4(map, sQueue, wQueue);
        if (result > 0) {
            System.out.println(result);
        }
        else
            System.out.println("KAKTUS");

    }
    public static int bfs4(char[][]map,Queue<sLoc> sQueue, Queue<sLoc> wQueue ){
        int curX = 0;
        int curY = 0;
        int aX = 0;
        int aY = 0;
        int count = 0;
        while (true) {
            count++;

            int wqSize = wQueue.size();
            for(int wq = 0; wq < wqSize; wq++) {
                sLoc sTemp = wQueue.poll();

                for (int i = 0; i < dir.length; i++) {
                    curX = sTemp.x + dir[i][0];
                    curY = sTemp.y + dir[i][1];
                    if (curX >= m || curX < 0) continue;
                    if (curY >= n || curY < 0) continue;
                    if (map[curX][curY] == '.') {
                        map[curX][curY] = '*';
                        wQueue.offer(new sLoc(curX, curY));
                    }
                }
            }
            if (sQueue.size() == 0) {
                return -1;
            }
            int sqSize = sQueue.size();
            for(int sq = 0; sq <sqSize; sq++){
                sLoc wTemp = sQueue.poll();

                for (int i = 0; i < dir.length; i++) {
                    aX = wTemp.x + dir[i][0];
                    aY = wTemp.y + dir[i][1];
                    if(aX >= m || aX<0) continue;
                    if(aY >= n || aY<0) continue;
                    if (map[aX][aY] == '.') {
                        sQueue.offer(new sLoc(aX, aY));
                        map[aX][aY] = 'S';
                    }
                    if (map[aX][aY] == 'D') {
                        return count;
                    }
                }
        }
        }

    }
}
