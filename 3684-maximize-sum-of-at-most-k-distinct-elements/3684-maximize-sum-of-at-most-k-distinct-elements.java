class Solution {
    public int[] maxKDistinct(int[] nums, int k) {

        Set<Integer> set = new HashSet<>();

        // Store distinct elements
        for (int num : nums) {
            set.add(num);
        }

        // Convert Set to array
        Integer[] arr = set.toArray(new Integer[0]);

        // Sort in descending order
        Arrays.sort(arr, Collections.reverseOrder());

        // Take at most k elements
        int size = Math.min(k, arr.length);
        int[] ans = new int[size];

        for (int i = 0; i < size; i++) {
            ans[i] = arr[i];
        }

        return ans;
    }
}