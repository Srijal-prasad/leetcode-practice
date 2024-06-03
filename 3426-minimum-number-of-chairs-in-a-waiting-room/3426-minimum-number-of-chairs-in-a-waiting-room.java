class Solution {
    public int minimumChairs(String s) {
        int min = 0,taken=0;
        for(char action: s.toCharArray())
        {
            if(action=='E')
               ++taken;
            else if(action=='L')
                --taken;
            
            min=Math.max(min,taken);
        }
        return min;
    }
}