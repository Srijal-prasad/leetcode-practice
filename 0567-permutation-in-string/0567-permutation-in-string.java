class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[26];
        for(int i=0;i<s1.length();i++){
            freq[s1.charAt(i)-'a']++;
        }
        int start=0;
        int end=0;
        while(end<s2.length()){

            freq[s2.charAt(end)-'a']--;
            while(freq[s2.charAt(end)-'a']<0){
                freq[s2.charAt(start)-'a']++;
                start++;
            }
            boolean flag = true;
            for(int i=0;i<26;i++){
                if(freq[i]!=0){
                    flag = false;
                    break;
                }
            }
            if(flag && end-start+1==s1.length()) return true;
            end++;
        }
        return false;

    }
}