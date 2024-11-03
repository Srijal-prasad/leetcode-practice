class Solution {
    public boolean rotateString(String s, String goal) {
        int i;
        String res="";
        for(i=0;i<goal.length();i++){
            res=   goal.substring(i,goal.length())+ goal.substring(0,i);
           // System.out.println(res);
            if(res.equals(s)) return true;
        }
        return false;
    }
}