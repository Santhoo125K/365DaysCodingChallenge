class Solution {
    private final long inf = (1L<<62);
    private final int MOD = 1000000007;
    
    public int countPaths(int n, int[][] roads) {
        Map<Integer, List<Integer>> edges = new HashMap<>();
        Map<Integer, List<Integer>> costs = new HashMap<>();
        
        for(int i=0;i<n;i++){
            edges.putIfAbsent(i, new ArrayList<Integer>());
            costs.putIfAbsent(i, new ArrayList<Integer>());
        }
        
        for(int[] road : roads){
            edges.get(road[0]).add(road[1]);
            edges.get(road[1]).add(road[0]);
            costs.get(road[0]).add(road[2]);
            costs.get(road[1]).add(road[2]);
        }
        
        long dis[] = new long[n];
        Arrays.fill(dis, inf);
        dis[0]=0;
        
        int paths[] = new int[n];
        paths[0]=1;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            return (int)(dis[a]-dis[b]);
        });
        pq.add(0);
        
        while(!pq.isEmpty()){
            int u = pq.poll();
            // System.out.println(u);
            for(int vi=0;vi<edges.get(u).size();vi++){
                int v = edges.get(u).get(vi);
                int c = costs.get(u).get(vi);
                
                if(dis[u]+c<dis[v]){
                    dis[v]=dis[u]+c;
                    paths[v]=paths[u];
                    pq.remove(v); // I was getting WA because of not removing the older one
                    pq.add(v);
                }
                else if(dis[u]+c==dis[v]){
                    paths[v]=(paths[v]+paths[u])%MOD;
                }
            }
        }
        
        return paths[n-1];
    }
}