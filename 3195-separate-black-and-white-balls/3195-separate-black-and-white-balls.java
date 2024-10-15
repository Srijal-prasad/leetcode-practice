class Solution {
    public long minimumSteps(String s) {
        int n = s.length();
        long operations = 0, countBlack = 0;
        for(int i=0; i<n; i++){
            if(s.charAt(i) == '0'){
                operations += countBlack; 
            }
            else{
                countBlack++;
            }
        }
        return operations;
    }
}