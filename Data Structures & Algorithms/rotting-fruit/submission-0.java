class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshfruits  = 0;
        int minutes = 0;


        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[] {i,j});
                }else if(grid[i][j] == 1){
                    freshfruits ++;
                }
            }
        }

        int[][] dirs = {{-1,0} , {1,0}, {0,-1}, {0,1}};

        while(!queue.isEmpty() && freshfruits > 0){
            int levelSize = queue.size();

            for(int i = 0; i<levelSize; i++){
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];

                for(int[] d : dirs){
                    int newR = r + d[0];
                    int newC = c + d[1];
        
                if(newR >= 0 && newR < m && newC >= 0 && newC < n && grid[newR][newC] == 1){
                    grid[newR][newC] = 2;
                    queue.offer(new int[] {newR,newC});
                    freshfruits--;
                }
                }
            }
            minutes++;
        }

        return freshfruits == 0 ? minutes : -1;
    }
} 