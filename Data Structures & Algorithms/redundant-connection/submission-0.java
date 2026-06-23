class Solution {
    int parent[];
    int rank[];

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (rank[pa] < rank[pb]) {
            parent[pa] = pb;
        } else if (rank[pb] < rank[pa]) {
            parent[pb] = pa;
        } else {
            parent[pb] = pa;
            rank[pa]++;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        parent = new int[n + 1];
        rank = new int[n + 1];

        for(int i = 1; i<=n; i++){
            parent[i] = i;
        }

        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];

            if(find(u) == find(v)) return edge;
            union(u,v);
        }

        return new int[0];
    }
}
