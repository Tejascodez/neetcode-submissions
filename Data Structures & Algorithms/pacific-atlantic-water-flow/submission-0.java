class Solution {
    int[][] dirs = {{-1,0} , {1,0} ,{0,-1} ,{0,1}};

    public void bfs(int heights[][], Queue<int[]> queue, boolean[][] visited){
        int m  = heights.length;
        int n = heights[0].length;

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int r  = curr[0];
            int c  = curr[1];


            for(int[] d : dirs){
                int newR = r + d[0];
                int newC = c + d[1];


                if(newR >= 0 && newR < m && newC >=0 && newC < n && !visited[newR][newC] && heights[newR][newC] >= heights[r][c]){
                    visited[newR][newC] = true;
                    queue.offer(new int[]{newR,newC});
                }
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        List<List<Integer>> result = new ArrayList<>();

        if(heights == null || heights.length == 0){
            return result;
        }

        boolean[][] pacificVisited = new boolean[m][n];
        boolean[][] atlanticVisited = new boolean[m][n];
        Queue<int[]> pqueue = new LinkedList<>();
        Queue<int[]> aqueue = new LinkedList<>();


        //step 1 Intialize the oceans at the borders

        for(int i = 0 ;i<m; i++){
            pqueue.offer(new int[]{i,0});
            pacificVisited[i][0] = true;

            aqueue.offer(new int[]{i,n-1});
            atlanticVisited[i][n-1] = true;
        }

        for(int j = 0; j<n; j++){
            pqueue.offer(new int[]{0,j});
            pacificVisited[0][j] = true;

            aqueue.offer(new int[] {m-1,j});
            atlanticVisited[m-1][j] = true;
        }

        bfs(heights,pqueue,pacificVisited);
        bfs(heights,aqueue,atlanticVisited);

        for(int i  = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(pacificVisited[i][j] && atlanticVisited[i][j]){
                    result.add(Arrays.asList(i,j));
                }
            }
        }


 return result;


    }
}
