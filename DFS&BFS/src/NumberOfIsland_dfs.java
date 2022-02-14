public class NumberOfIsland_dfs {
    public static void main(String[] args) {
        char[][] grid = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '1', '1' } };

//		char[][] grid = {
//				{ '1', '0' },
//				{ '1', '1'}};

        NumberOfIsland_dfs a = new NumberOfIsland_dfs();
        System.out.println(a.solve(grid));
    }
    int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    int m, n;
    int dfsCount = 0;
    int count =0;
    public int solve(char[][] grid){
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        m = grid.length; //4
        n = grid[0].length;//5

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i,j);
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid, int i, int j){
        //error check
        if (i >= 0 && j >= 0 && i < m && j < n && grid[i][j] == '1')
            return;
        grid[i][j] = 'X';//visited
        for (int[] dir : dirs) {
            dfs(grid, i+dir[0], j+dir[1]);
            //dfs(grid, i=1, j)
        }

    }
}
