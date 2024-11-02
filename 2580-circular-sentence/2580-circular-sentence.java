class Solution {
    public boolean isCircularSentence(String sentence) {
        if (sentence.charAt(0) != sentence.charAt(sentence.length() - 1))
            return false;
        int k = sentence.indexOf(" ");
        if (k == -1)
            return true;
        String s[] = sentence.split(" ");
        for(int i = 0; i < s.length - 1; i++) {
            if(s[i].charAt(s[i].length() - 1) != s[i + 1].charAt(0)) {
                return false;
            }
        }
        return sentence.charAt(0) == sentence.charAt(sentence.length()-1);
    }
}