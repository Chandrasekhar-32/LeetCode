class Solution {

    public String longestPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }

        // Transform string
        StringBuilder t = new StringBuilder();

        t.append("#");

        for (char c : s.toCharArray()) {
            t.append(c);
            t.append("#");
        }

        int n = t.length();

        int[] p = new int[n];

        int center = 0;
        int right = 0;

        int maxLen = 0;
        int centerIndex = 0;

        for (int i = 0; i < n; i++) {

            int mirror = 2 * center - i;

            // Use previously computed palindrome
            if (i < right) {
                p[i] = Math.min(right - i, p[mirror]);
            }

            // Expand around center
            int left = i - (1 + p[i]);
            int r = i + (1 + p[i]);

            while (
                left >= 0 &&
                r < n &&
                t.charAt(left) == t.charAt(r)
            ) {
                p[i]++;
                left--;
                r++;
            }

            // Update center and right boundary
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }

            // Find maximum
            if (p[i] > maxLen) {
                maxLen = p[i];
                centerIndex = i;
            }
        }

        // Extract answer
        int start = (centerIndex - maxLen) / 2;

        return s.substring(start, start + maxLen);
    }
}