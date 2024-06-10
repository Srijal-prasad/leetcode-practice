class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n=nums.length;
        List<Integer> ans=new ArrayList<>();
        List<Integer> arr=new ArrayList<>();
        for(int i:nums)
        {
            arr.add(i);
        }
        Collections.sort(arr);
        for(int i=0;i<n;i++)
        {
            int index=bs(arr,nums[i]);
            ans.add(index);
            arr.remove(index);
        }
        return ans;
    }
    public int bs(List<Integer>arr, int target)
    {
        int start=0,end=arr.size()-1;
        int mid=0;
        while(start<=end)
        {
            mid=start+(end-start)/2;
            int val=arr.get(mid);
            if(val<target)
              start=mid+1;
            else
              end=mid-1;
        }
        if(arr.get(start)==target)
          return start;
        return mid;
    }
}