class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer>s=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]%k==0){
            s.add(nums[i]);
            }
        }
        int multiple=k;
        for(int i=0;i<s.size();i++){
           if(!s.contains(multiple)){
            return multiple;
           }
           else{
            multiple+=k;
           }
        }
        return multiple;
        
    }
}