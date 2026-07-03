class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

            List<List<Integer>> adjmatrix = new ArrayList<>();

            for(int i = 0; i<numCourses; i++){
                    adjmatrix.add(new ArrayList<>());
            }

            int indegree[] = new int[numCourses];

            for(int pre[] : prerequisites){
                int course = pre[0];
                int prereq  = pre[1];

                adjmatrix.get(prereq).add(course);
                indegree[course]++;
            }

            Queue<Integer> queue = new LinkedList<>();
            for(int i = 0; i<numCourses; i++){
                if(indegree[i] == 0) queue.offer(i);
            }
            
            int taken = 0;
            while(!queue.isEmpty()){
                int current = queue.poll();
                taken++;

                for(int neigbour : adjmatrix.get(current)){
                    indegree[neigbour]--;
                    if(indegree[neigbour] == 0) queue.offer(neigbour);
                }
            }

            return numCourses == taken;
    }
}
