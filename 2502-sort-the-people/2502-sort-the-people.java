class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int numOfPeople = names.length;

        TreeMap<Integer, String> heightToNameMap = new TreeMap<>();

        for(int i = 0; i < numOfPeople; i++) {
            heightToNameMap.put(heights[i], names[i]);
        }

        String sortedNames[] = new String[numOfPeople];

        int curr = numOfPeople - 1;

        for(int height : heightToNameMap.keySet()) {
            sortedNames[curr] = heightToNameMap.get(height);
            curr--;
        }
        return sortedNames; 
    }
}