class Solution {
    public int minLength(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        int i=0;
        while(true){
            n = sb.length();
            if(n==0){
                break;
            }
            if(sb.charAt(i)=='A'){
                if(i+1<n && sb.charAt(i+1)=='B'){
                    sb.deleteCharAt(i);
                    sb.deleteCharAt(i);
                    i=0;
                    continue;
                }
            }
            if(sb.charAt(i)=='C'){
                if(i+1<n && sb.charAt(i+1)=='D'){
                    sb.deleteCharAt(i);
                    sb.deleteCharAt(i);
                    i=0;
                    continue;
                }
            }
            i++;
            if(i==n){
                break;
            }
        }
        return n;
    }
}