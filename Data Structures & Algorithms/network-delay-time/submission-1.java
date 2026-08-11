class Solution {
    class Pair {
        int cost;
        int node;

        Pair(int cost, int node) {
            this.cost = cost;
            this.node = node;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Pair>> graph = new HashMap<>();

        for (int edge[] : times) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if (!graph.containsKey(u)) {
                graph.put(u, new ArrayList<>());
            }

            graph.get(u).add(new Pair(w,v));
        }

        int dist[] = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);

        dist[k] = 0;
        pq.offer(new Pair(0,k));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            if (curr.cost > dist[curr.node]) {
                continue;
            }

            for (Pair neigbour : graph.getOrDefault(curr.node, new ArrayList<>())) {
                int nextNode = neigbour.node;
                int edgeWeight = neigbour.cost;

                int newDist = curr.cost + edgeWeight;

                if (newDist < dist[nextNode]) {
                    dist[nextNode] = newDist;
                    pq.offer(new Pair(newDist,nextNode));
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
                      ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}
