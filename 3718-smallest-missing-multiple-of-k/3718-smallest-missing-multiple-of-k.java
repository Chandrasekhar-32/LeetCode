class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> s = new HashSet<>();

        for (int num : nums) {
            if (num % k == 0) {
                s.add(num);
            }
        }

        int multiple = k;

        while (s.contains(multiple)) {
            multiple += k;
        }

        return multiple;
    }
}