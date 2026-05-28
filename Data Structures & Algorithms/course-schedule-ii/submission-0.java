class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];
        for(int pre[] : prerequisites){
            int course = pre[0];
            int prereq = pre[1];
            adj.get(prereq).add(course);
            inDegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i =0; i<numCourses; i++){
            if(inDegree[i] == 0) queue.offer(i);
        }
        int result[] = new int[numCourses];
        int index = 0;

        while(!queue.isEmpty()){
            int node = queue.poll();
            result[index++] = node;


            for(int neigbour : adj.get(node)){
               inDegree[neigbour]--;

               if(inDegree[neigbour] == 0) queue.offer(neigbour);


            }

        }

        if(index != numCourses) return new int[0];

        return result;
    }
}
