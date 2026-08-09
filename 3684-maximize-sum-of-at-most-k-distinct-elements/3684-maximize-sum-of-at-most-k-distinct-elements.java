class Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        Arrays.sort(nums);

        int n = nums.length;
        int[] ans = new int[Math.min(k, n)];
        int j = 0;

        for (int i = n - 1; i >= 0 && j < k; i--) {

            // Skip duplicate values
            if (i < n - 1 && nums[i] == nums[i + 1]) {
                continue;
            }

            ans[j++] = nums[i];
        }

        return Arrays.copyOf(ans, j);
    }
}