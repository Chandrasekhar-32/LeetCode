class Solution {
    public int missingMultiple(int[] nums, int k) {
        Arrays.sort(nums);
        int num=1;
        for(int i=0;i<nums.length;i++){
            if(num*k==nums[i]){
                num++;
            }
            else if(num*k<nums[i]){
                return num*k;
            }
        }
        return num*k;
        
    }
}