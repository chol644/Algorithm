package week04;

// TreeNode2 정의
class TreeNode2 {
    int val;
    TreeNode2 left;
    TreeNode2 right;

    TreeNode2(int x) {
        val = x;
    }
}

// LCA를 구하는 로직
class lowestAncestor {
    public TreeNode2 lowestAncestor(TreeNode2 root, TreeNode2 p, TreeNode2 q) {
        if (root == null || root == p || root == q) return root;

        TreeNode2 left = lowestAncestor(root.left, p, q);
        TreeNode2 right = lowestAncestor(root.right, p, q);

        if (left != null && right != null) return root;
        return left != null ? left : right;
    }
}
