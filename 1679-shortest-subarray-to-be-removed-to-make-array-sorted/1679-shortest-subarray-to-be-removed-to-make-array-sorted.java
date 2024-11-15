import java.util.Arrays;  

class Solution {  
    public int findLengthOfShortestSubarray(int[] arr) {  
        int n = arr.length;  
        int left = 0;  
        int right = n - 1;  

        // Find the first element from the left that is out of order  
        while (left + 1 < n && arr[left] <= arr[left + 1]) {  
            left++;  
        }  

        // If the array is already sorted, return 0  
        if (left == n - 1) {  
            return 0;  
        }  

        // Find the first element from the right that is out of order  
        while (right - 1 >= left && arr[right] >= arr[right - 1]) {  
            right--;  
        }  

        int ans = Math.max(n - right, left + 1);  
        int i = 0, j = right;  
        while (i <= left && j < n) {  
            if (arr[i] <= arr[j]) {  
                ans = Math.max(ans, i + 1 + (n - j));  
                i++;  
            } else {  
                j++;  
            }  
        }  

        return n - ans;  
    }  
}