class Solution {

    class Pair{
        int node;
        int cost;
        int stops;

        Pair(int node, int cost, int stops){
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<int[]>> graph = new ArrayList<>();

        for(int i = 0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for(int flight[] : flights){
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];

            graph.get(from).add(new int[]{to,price});
        }

        int dist[] = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);

        dist[src] = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(src,0,0));


        while(!q.isEmpty()){
            Pair curr = q.poll();

            int node = curr.node;
            int cost = curr.cost;
            int stops = curr.stops;


            if(stops > k) continue;

            for(int edge[] : graph.get(node)){
                int nxtNode = edge[0];
                int price = edge[1];

                int newcost = cost + price;


                if(newcost < dist[nxtNode]){
                    dist[nxtNode] = newcost;
                    q.offer(new Pair(nxtNode,newcost,stops+1));
                }
            }
        }


        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
