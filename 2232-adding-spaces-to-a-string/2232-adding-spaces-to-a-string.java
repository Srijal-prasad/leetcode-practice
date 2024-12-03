class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder(s);
        int n = spaces.length;
        for(int i=0;i<n;i++){
            sb.insert(spaces[i] + i,' ');
        }
        return sb.toString();
    }
}