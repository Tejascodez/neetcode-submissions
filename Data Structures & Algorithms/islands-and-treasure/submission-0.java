class Solution {
    public void islandsAndTreasure(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return;

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 0) queue.offer(new int[]{i,j});
            }
        }
// Directions representing up, down, left, right
        int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

            while(!queue.isEmpty()){
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];


                for(int dirs[] : directions){
                    int newRow = row + dirs[0];
                    int newCol = col + dirs[1];


                    if(newRow >=0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == Integer.MAX_VALUE){
                        grid[newRow][newCol] = grid[row][col]+1;
                        queue.offer(new int[] {newRow,newCol});
                    }
                }
            }
    }
}
