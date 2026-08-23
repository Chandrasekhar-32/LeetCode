class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();

        if (root == null) return ans;

        path(root, "", ans);

        return ans;
    }

    static void path(TreeNode root, String s, List<String> ans) {

        if (root == null) {
            return;
        }

        // Add current node to path
        s += root.val;

        // Leaf node → complete path
        if (root.left == null && root.right == null) {
            ans.add(s);
            return;
        }

        // Add arrow before going to next node
        s += "->";

        if (root.left != null) {
            path(root.left, s, ans);
        }

        if (root.right != null) {
            path(root.right, s, ans);
        }
    }
}