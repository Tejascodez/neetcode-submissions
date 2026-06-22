class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1)
            return false;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(0);
        visited.add(0);
        while (!queue.isEmpty()) {

            int node = queue.poll();

            for(int neigbour : adj.get(node)){
                if(!visited.contains(neigbour)){
                    visited.add(neigbour);
                    queue.offer(neigbour);
                }
            }
        }

        return visited.size() == n;
    }
}
