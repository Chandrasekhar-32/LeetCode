class Solution {
    static List<Integer> inorder(TreeNode root, List<Integer> a) {
        if (root == null) {
            return a;
        }

        inorder(root.left, a);
        a.add(root.val);
        inorder(root.right, a);

        return a;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> a = new ArrayList<>();
        inorder(root, a);
        return a;
    }
}