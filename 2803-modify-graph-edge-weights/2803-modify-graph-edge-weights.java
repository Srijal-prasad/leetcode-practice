import java.util.*;

class Pair{
    int val;
    long wt;
    Pair(int v, long w){
        val = v;
        wt = w;
    }
}
class Solution {
    long inf = 1000000007;
    public HashMap<Integer, List<Pair>> getAdj(int edges[][]){
        HashMap<Integer, List<Pair>> map = new HashMap<Integer, List<Pair>>();
        for(int edge[]: edges){
            if(edge[2]==-1) continue;
            if(map.get(edge[0])==null) map.put(edge[0], new ArrayList<Pair>());
            if(map.get(edge[1])==null) map.put(edge[1], new ArrayList<Pair>());
            map.get(edge[0]).add(new Pair(edge[1], edge[2]));
            map.get(edge[1]).add(new Pair(edge[0], edge[2]));
        }

        return map;
    }
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        HashMap<Integer, List<Pair>> adj = getAdj(edges);
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((Pair p1, Pair p2)->(int)p1.wt-(int)p2.wt);
        long dist[] = new long[n];

        //              _____FIRST___PART_____
        Arrays.fill(dist, inf);

        dist[source] = 0;
        pq.add(new Pair(source, 0));
        
        while(!pq.isEmpty()){
            int node = pq.poll().val;

            if(adj.get(node)==null) continue;
            for(Pair p: adj.get(node)){
                long d = dist[node] + p.wt;
                if(d<dist[p.val]){
                    dist[p.val] = d;
                    pq.add(new Pair(p.val, d));
                }
            }
        }

        if(dist[destination]<target) return new int[0][0];

        if(dist[destination]==target){
            for(int edge[]: edges){
                if(edge[2]==-1) edge[2] = 1000000005;
            }
            
            return edges;
        }

        // ___CHECK__IF__-1___EXIST 
        boolean in = false;

        //                _______SECOND______PART________
        for(int edge[]: edges){
            if(edge[2]==-1){
                in = true;
                if(adj.get(edge[1])==null) adj.put(edge[1], new ArrayList<Pair>());
                if(adj.get(edge[0])==null) adj.put(edge[0], new ArrayList<Pair>());
                adj.get(edge[0]).add(new Pair(edge[1], 1));
                adj.get(edge[1]).add(new Pair(edge[0], 1));
                Arrays.fill(dist, inf);
                dist[source] = 0;
                pq.add(new Pair(source, 0));

                while(!pq.isEmpty()){
                    int node = pq.poll().val;

                    if(adj.get(node)==null) continue;
                    for(Pair p: adj.get(node)){
                        long d = dist[node] + p.wt;
                        if(d<dist[p.val]){
                            dist[p.val] = d;
                            pq.add(new Pair(p.val, d));
                        }
                    }
                }
              
                if(dist[destination]<=target){
                    edge[2] = (int)((long)target - (long)dist[destination] + 1 );
                }

                if(edge[2]==-1) edge[2] = 1;
            }
        }
        
        //________IF__SHORTEST_SRC_TO_DEST__DISTANCE_>_TARGET____3RD__EDGE_CASE__
        // What if even after modifying edges with wt == -1 dist[src->dest] > target
        if(dist[destination]>target) return new int[0][0]; // we can't get dist[src->dest] == target
        
        //_____IF__-1__NOT_EXIST_RETURN__EMPTY__ARR___ELSE___MODIFIED__EDGES____
        return !in? new int[0][0]: edges;
    }
}