class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int count=words.length;
        int arr[]=new int[26];
        for(int i=0;i<allowed.length();i++)
        {
            arr[allowed.charAt(i)-'a']++;
        }
        for(String str:words)
        {
            for(char ch:str.toCharArray())
            {
              if(arr[ch-'a']<=0)
              {
              count--;
              break;
              }
            }
            
        }
        return count; 
    }
}