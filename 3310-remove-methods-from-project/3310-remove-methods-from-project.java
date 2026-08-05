class Solution {

    public void dfs(int k, List<Integer>[] a, boolean[] b) {
        b[k] = true;

        for (int x : a[k]) {
            if (!b[x]) {
                dfs(x, a, b);
            }
        }
    }

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        List<Integer> ans = new ArrayList<>();

        List<Integer>[] a = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            a[i] = new ArrayList<>();
        }

        int n1 = invocations.length;

        for (int i = 0; i < n1; i++) {
            a[invocations[i][0]].add(invocations[i][1]);
        }

        boolean[] b = new boolean[n];

        // Mark all suspicious methods
        dfs(k, a, b);

        // Check if any non-suspicious method calls a suspicious one
        for (int i = 0; i < n1; i++) {
            if (!b[invocations[i][0]] && b[invocations[i][1]]) {
                for (int j = 0; j < n; j++) {
                    ans.add(j);
                }
                return ans;
            }
        }

        // Add remaining methods
        for (int i = 0; i < n; i++) {
            if (!b[i]) {
                ans.add(i);
            }
        }

        return ans;
    }
}