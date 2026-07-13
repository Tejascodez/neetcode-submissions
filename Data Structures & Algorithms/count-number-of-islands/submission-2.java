class Solution {
    public void dfs(int r, int c, char[][] grid){
        int row = grid.length;
        int col = grid[0].length;

        if(r < 0 || c < 0 || r >= row || c >= col || grid[r][c] == '0') return;
        grid[r][c] = '0';

        dfs(r+1,c, grid);
        dfs(r-1,c,grid);
        dfs(r,c+1,grid);
        dfs(r,c-1,grid);
    }
    public int numIslands(char[][] grid) {
        int noOfIslands = 0;
        int row = grid.length;
        int col = grid[0].length;


        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(grid[i][j] == '1'){
                    dfs(i,j,grid);
                    noOfIslands++;
                }
            }
        }

        return noOfIslands;
    }
}
