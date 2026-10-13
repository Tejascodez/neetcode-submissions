class Solution {
    public void dfs(int r, int c, char grid[][]){
        int m = grid.length;
        int n = grid[0].length;

        if(r < 0 || c < 0 || r >= m || c >=n || grid[r][c] == '0') return;

        grid[r][c] = '0';
        dfs(r+1,c,grid);
        dfs(r-1,c,grid);
        dfs(r,c+1,grid);
        dfs(r,c-1,grid);
    }
    public int numIslands(char[][] grid) {
        int ans = 0;

        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    dfs(i,j,grid);
                    ans++;
                }
            }
        }

        return ans;
    }
}
