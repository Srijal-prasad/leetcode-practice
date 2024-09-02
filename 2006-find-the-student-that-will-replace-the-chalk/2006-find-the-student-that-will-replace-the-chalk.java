class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long x = 0;
        for(int c: chalk){
            x += c;
        }
        k = (int)(k%x);
        int total = 0;
        int i = 0;
        while(total<=k){
            total += chalk[i];
            i += 1;
        }
        return i-1;
    }
}