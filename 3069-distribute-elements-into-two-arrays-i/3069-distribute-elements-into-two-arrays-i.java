class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;

        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();

        a.add(nums[0]);
        b.add(nums[1]);

        for (int i = 2; i < n; i++) {
            if (a.get(a.size() - 1) > b.get(b.size() - 1)) {
                a.add(nums[i]);
            } else {
                b.add(nums[i]);
            }
        }

        int index = 0;

        for (int x : a) {
            nums[index++] = x;
        }

        for (int x : b) {
            nums[index++] = x;
        }

        return nums;
    }
}