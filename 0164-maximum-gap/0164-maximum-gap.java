class Solution {
    public int maximumGap(int[] nums) {
        int n=nums.length;
     if(n<2) return 0;
     Arrays.sort(nums);
     int minLen=0;
     for(int i=1;i<n;i++){
        int a=(nums[i]-nums[i-1]);
        minLen=Math.max(a,minLen);
     }
     return minLen;
        
    }
}