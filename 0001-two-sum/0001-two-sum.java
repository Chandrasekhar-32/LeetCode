class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> a = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int ele = target - nums[i];

            if (a.containsKey(ele)) {
                return new int[]{a.get(ele), i};
            }

            a.put(nums[i], i);
        }

        return new int[]{};
    }
}