class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int arr1[] = new int[arr.length];
        HashMap<Integer, Integer> a = new HashMap<>();
        
        // Step 1: Copy the array
        for (int i = 0; i < arr.length; i++) {
            arr1[i] = arr[i];
        }

        // Step 2: Sort the copied array
        Arrays.sort(arr1);

        // Step 3: Assign ranks to the elements
        int c = 1;
        for (int i = 0; i < arr.length; i++) {
            if (!a.containsKey(arr1[i])) {
                a.put(arr1[i], c++);
            }
        }

        // Step 4: Replace original array with ranks
        for (int i = 0; i < arr.length; i++) {
            arr[i] = a.get(arr[i]);
        }
        
        return arr;
    }
}