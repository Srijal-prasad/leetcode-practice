class Solution {
    HashSet<Pair<Integer,Integer>> set = new HashSet<>();

    public int removeStones(int[][] stones) {
        int n = stones.length;
        Map<Pair, List<Pair<Integer,Integer>>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(new Pair(stones[i][0], stones[i][1]), new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            Pair pair = new Pair(stones[i][0], stones[i][1]);
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                        map.get(pair).add(new Pair(stones[j][0], stones[j][1]));
                    }
                }
            }
        }

        int cluster = 0;
        for (int[] stone : stones) {
            Pair pair = new Pair(stone[0], stone[1]);
            if (!set.contains(pair)) {
                dfs(map, pair);
                cluster++;
            }
        }
        return n - cluster;
    }

    public void dfs(Map<Pair, List<Pair<Integer,Integer>>> map, Pair p) {
        set.add(p);
        if (map.containsKey(p) && map.get(p) != null) {
            for (Pair i : map.get(p)) {
                if (!set.contains(i)) {
                    dfs(map, i);
                }
            }
        }
    }
}