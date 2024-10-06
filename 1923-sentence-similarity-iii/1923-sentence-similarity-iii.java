class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] firstTokens = sentence1.split(" ");
        String[] secondTokens = sentence2.split(" ");
        
        int minTokens = Math.min(firstTokens.length, secondTokens.length);
        
        //Count similar tokens at beginning
        int prefixCount = 0;
        for(int i = 0; i < minTokens; i++){
            if(firstTokens[i].equals(secondTokens[i]))
                prefixCount++;
            else 
                break; // Stop at first mismatch
        }

        //Count similar tokens at end
        int suffixCount = 0;
        int end1 = firstTokens.length-1;
        int end2 = secondTokens.length-1;
        while(end1 >= 0 && end2 >= 0){
            if(firstTokens[end1--].equals(secondTokens[end2--]))    
                suffixCount++;
            else 
                break;// Stop at first mismatch
        }

        // Check if enough tokens match to cover the shorter sentence
        return (prefixCount+suffixCount >= minTokens);
    }
}