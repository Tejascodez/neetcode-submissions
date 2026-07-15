class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return  0;
        Queue<int[]> queue = new LinkedList<>();
        int freshfruits = 0;
        int minutes = 0;

        int m = grid.length;
        int n = grid[0].length;


        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                }else if(grid[i][j] == 1){
                    freshfruits++;
                }
            }
        }

        int dirs[][] = {{1,0}, {-1,0}, {0,1},{0,-1}};

        while(!queue.isEmpty() && freshfruits > 0){
            int levlsize =  queue.size();


            for(int i = 0; i<levlsize; i++){
                int curr[] = queue.poll();
                int r = curr[0];
                int c = curr[1];

                for(int d[] : dirs){
                    int newr = r + d[0];
                    int newc = c + d[1];


                    if(newr >= 0 && newc >= 0 && newr < m && newc < n && grid[newr][newc] == 1){
                        grid[newr][newc] = 2;
                        queue.offer(new int[]{newr,newc});
                        freshfruits--;
                    }
                }
            }
            minutes++;

        }

        return freshfruits == 0 ? minutes : -1;

    }
}
