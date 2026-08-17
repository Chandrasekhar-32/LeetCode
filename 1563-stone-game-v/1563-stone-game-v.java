class Solution {
    int[][] dp;
    int[] prefix;

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;

        prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }

        dp = new int[n][n];

        for (int[] row : dp) {
            java.util.Arrays.fill(row, -1);
        }

        return dfs(stoneValue, 0, n - 1);
    }

    private int dfs(int[] stones, int i, int j) {

        // Only one stone
        if (i == j) {
            return 0;
        }

        // Already calculated
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = 0;

        for (int k = i; k < j; k++) {

            int leftSum = prefix[k + 1] - prefix[i];
            int rightSum = prefix[j + 1] - prefix[k + 1];

            if (leftSum < rightSum) {

                // Right is removed
                ans = Math.max(
                    ans,
                    leftSum + dfs(stones, i, k)
                );

            } else if (leftSum > rightSum) {

                // Left is removed
                ans = Math.max(
                    ans,
                    rightSum + dfs(stones, k + 1, j)
                );

            } else {

                // Equal -> Alice can choose either side
                ans = Math.max(
                    ans,
                    Math.max(
                        leftSum + dfs(stones, i, k),
                        rightSum + dfs(stones, k + 1, j)
                    )
                );
            }
        }

        return dp[i][j] = ans;
    }
}