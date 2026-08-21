class Solution {
    public boolean isValidBST(TreeNode root) {
        return validBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    static boolean validBST(TreeNode root, long min_val, long max_val) {
        if (root == null) return true;

        if (root.val <= min_val || root.val >= max_val) {
            return false;
        }

        return validBST(root.left, min_val, root.val) &&
               validBST(root.right, root.val, max_val);
    }
}