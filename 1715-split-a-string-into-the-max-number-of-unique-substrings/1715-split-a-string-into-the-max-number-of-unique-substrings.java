class Solution {
    private int backtrack(String s, int start, Set<String> seen) {
        if (start == s.length()) {
            return 0;
        }
        
        int maxSplits = 0;
        for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);
            if (!seen.contains(substring)) {
                seen.add(substring);
                // Continue with the next possible split
                maxSplits = Math.max(maxSplits, 1 + backtrack(s, end, seen));
                // Backtrack by removing the substring from the set
                seen.remove(substring);
            }
        }
        return maxSplits;
    }
    public int maxUniqueSplit(String s) {
        //backtracking
        //try to get substring of length 1 --> since to have maximal split
        return backtrack(s, 0, new HashSet<>());
    }
}