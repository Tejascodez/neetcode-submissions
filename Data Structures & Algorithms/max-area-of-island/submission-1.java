class Solution {
    public int dfs(int[][] grid, int r, int c) {
        int m = grid.length;
        int n = grid[0].length;

        if (r < 0 || c < 0 || r >= m || c >= n || grid[r][c] == 0)
            return 0;
        grid[r][c] = 0;

        return 1 + dfs(grid, r + 1, c) + dfs(grid, r - 1, c)
            + dfs(grid, r, c + 1) + dfs(grid, r, c - 1);
    }
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxarea = 0;
        boolean visited[][] = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j);
                    maxarea = Math.max(area, maxarea);
                }
            }
        }
        return maxarea;
    }
}
