class Solution {
    public int dfs(int r, int c, int grid[][]){
        int m = grid.length;
        int n = grid[0].length;

        if(r < 0 || c < 0 || r >= m || c >=n ) return 1;

        if(grid[r][c] == 0) return 1;
        if(grid[r][c] == 2) return 0;

        grid[r][c] = 2;

        return dfs(r+1,c,grid) +
                dfs(r-1,c,grid) + 
                dfs(r,c+1,grid) + 
                dfs(r,c-1,grid);

    }
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 1) return dfs(i,j,grid);
            }
        }
        return 0;
    }
}