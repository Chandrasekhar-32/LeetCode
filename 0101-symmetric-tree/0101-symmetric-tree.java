class Solution {

    static boolean sym(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        return (p.val == q.val)
                && sym(p.left, q.right)
                && sym(p.right, q.left);
    }

    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        return sym(root.left, root.right);
    }
}