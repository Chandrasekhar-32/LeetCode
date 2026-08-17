class Solution {
    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        return inorder(root, k);
    }

    int inorder(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }

        // Left
        int left = inorder(root.left, k);
        if (left != -1) {
            return left;
        }

        // Root
        count++;
        if (count == k) {
            return root.val;
        }

        // Right
        return inorder(root.right, k);
    }
}