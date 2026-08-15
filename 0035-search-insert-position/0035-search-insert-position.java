class Solution {
    public int searchInsert(int[] nums, int x) {
     
       int low=0;
       int high=nums.length-1;
       int ans=nums.length;
       while(low<=high){
        int mid=(low+high)/2;
        if(nums[mid]>=x){
            high=mid-1;
            ans=mid;
        }
        else{
            low=mid+1;

        }
       }
        return ans;
    }
}