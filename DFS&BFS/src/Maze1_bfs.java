import java.util.LinkedList;
import java.util.Queue;

public class Maze1_bfs {
    public static void main(String[] args) {
        int[][] maze= {
                {0,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {1,1,0,1,1},
                {0,0,0,0,0}
        };
        int[] start= {0,4};
        int[] dest = {4,4};
//		int[] dest = {3,2};
        Maze1_bfs a= new Maze1_bfs();
        System.out.println(a.solve(maze, start,dest ));
    }
    int[][] dirs = {{-1,0}, {1,0}, {0,-1},{0,1}};
    int m,n;
    public boolean solve(int[][] maze, int[] start, int[] dest) {
        m = maze.length;
        n = maze[0].length;
        if(start[0]==dest[0] && start[1]==dest[1])
            return true;
        boolean[][] visited = new boolean[m][n];
        visited[start[0]][start[1]] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {start[0], start[1]});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : dirs) {
                int x = cur[0];
                int y = cur[1];
                while (x >= 0 && y >= 0 && x < m && y < n && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                }
                x -= dir[0];
                y -= dir[1];
                if(visited[x][y]) continue;
                visited[x][y] = true;
                if(x==dest[0] && y== dest[1]) return true;
                queue.offer(new int[]{x,y});
            }
        }
        return false;
    }
}
