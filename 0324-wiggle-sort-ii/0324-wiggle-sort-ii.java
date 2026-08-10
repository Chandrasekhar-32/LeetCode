class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;

        // Find median
        int median = quickSelect(nums.clone(), (n - 1) / 2);

        // Virtual index
        int left = 0;
        int i = 0;
        int right = n - 1;

        while (i <= right) {
            int vi = virtualIndex(i, n);

            if (nums[vi] > median) {
                swap(nums, virtualIndex(left++, n), vi);
                i++;
            } 
            else if (nums[vi] < median) {
                swap(nums, virtualIndex(right--, n), vi);
            } 
            else {
                i++;
            }
        }
    }

    private int virtualIndex(int i, int n) {
        return (2 * i + 1) % (n | 1);
    }

    private int quickSelect(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int pivot = nums[right];

            int p = left;

            for (int i = left; i < right; i++) {
                if (nums[i] <= pivot) {
                    swap(nums, i, p++);
                }
            }

            swap(nums, p, right);

            if (p == k) {
                return nums[p];
            } else if (p < k) {
                left = p + 1;
            } else {
                right = p - 1;
            }
        }

        return -1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}