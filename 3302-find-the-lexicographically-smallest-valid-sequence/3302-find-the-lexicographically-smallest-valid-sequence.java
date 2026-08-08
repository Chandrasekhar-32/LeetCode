class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] last = new int[m];
        Arrays.fill(last, -1);

        // last[j] = earliest/latest position needed to match
        // word2[j...] from the right
        int i = n - 1;
        int j = m - 1;

        while (i >= 0 && j >= 0) {
            if (word1.charAt(i) == word2.charAt(j)) {
                last[j] = i;
                j--;
            }
            i--;
        }

        int[] ans = new int[m];

        boolean mismatch = false;
        j = 0;

        for (i = 0; i < n && j < m; i++) {

            if (word1.charAt(i) == word2.charAt(j)) {
                ans[j] = i;
                j++;
            }
            else if (!mismatch &&
                    (j == m - 1 || i < last[j + 1])) {

                // Use our one allowed mismatch
                ans[j] = i;
                j++;
                mismatch = true;
            }
        }

        if (j != m) {
            return new int[0];
        }

        return ans;
    }
}