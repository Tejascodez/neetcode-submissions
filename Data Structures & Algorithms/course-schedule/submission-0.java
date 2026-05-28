class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        int inDegree[] = new int[numCourses];
        for(int pre[] : prerequisites){
            int course = pre[0];
            int prereq = pre[1];
            adj.get(prereq).add(course);
            inDegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i<numCourses; i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }

        int coursesTaken = 0;
        while(!queue.isEmpty()){
            int current = queue.poll();
            coursesTaken++;

            for(int neigbour : adj.get(current)){
                inDegree[neigbour]--;
                if(inDegree[neigbour] == 0) queue.offer(neigbour);
            }

            
        }

        return numCourses == coursesTaken;
    }
}
