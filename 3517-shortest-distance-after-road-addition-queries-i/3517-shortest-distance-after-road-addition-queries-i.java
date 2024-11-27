class Node{
    int node,distance;
    Node(int node,int distance){
        this.node = node;
        this.distance = distance;
    }
}
class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] res = new int[queries.length];
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int i=0; i<n-1; i++) adj.get(i).add(i+1);
        for(int i=0; i<queries.length; i++){
            Queue<Node> q = new LinkedList<>();
            boolean vis[] = new boolean[n];
            q.add(new Node(0,0));
            int minDist = n+1;
            adj.get(queries[i][0]).add(queries[i][1]);
            while(!q.isEmpty()){
                Node curNode = q.poll();
                int node = curNode.node;
                int distance = curNode.distance;
                if(node == n-1){
                    minDist = Math.min(minDist,distance);
                    break;
                }
                for(int adjNode: adj.get(node)){
                    if(!vis[adjNode]){
                        q.add(new Node(adjNode,distance+1));
                        vis[adjNode] = true;
                    }
                }
            }
            res[i] = minDist;
        }
        return res;
    }
}