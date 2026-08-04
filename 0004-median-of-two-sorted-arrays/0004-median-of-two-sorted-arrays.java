class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[] a = new int[n + m];
        int i = 0, j = 0, k = 0;

        while (i < n && j < m) {
            if (nums1[i] < nums2[j]) {
                a[k++] = nums1[i++];
            } else {
                a[k++] = nums2[j++];
            }
        }

        while (i < n) a[k++] = nums1[i++];
        while (j < m) a[k++] = nums2[j++];

       
        int len = a.length;
        if (len % 2 == 1) {
            return a[len / 2];
        } else {
            return (a[len / 2 - 1] + a[len / 2]) / 2.0;
        }
    }
}
