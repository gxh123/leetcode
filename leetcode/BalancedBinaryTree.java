public class BalancedBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(6);

        root.right.right.right = new TreeNode(9);
        // root.right.right.right.right = new TreeNode(9);
        // root.right.right.right.right.right = new TreeNode(9);

        System.out.println(isBalanced(root));
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int leftDepth = computeDepth(root.left);
        int rightDepth = computeDepth(root.right);
        return Math.abs(leftDepth - rightDepth) <= 1 && isBalanced(root.left)
                && isBalanced(root.right);
    }

    public static int computeDepth(TreeNode root) {
        if (root == null)
            return 0;
        int leftDepth = computeDepth(root.left);
        int rightDepth = computeDepth(root.right);
        return leftDepth >= rightDepth ? (leftDepth + 1) : (rightDepth + 1);
    }

    // 用DFS做，从下往上，时间复杂度更低
    int dfsHeight(TreeNode root) {
        if (root == null)
            return 0;

        int leftHeight = dfsHeight(root.left);
        if (leftHeight == -1)
            return -1;
        int rightHeight = dfsHeight(root.right);
        if (rightHeight == -1)
            return -1;

        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    boolean isBalanced2(TreeNode root) {
        return dfsHeight(root) != -1;
    }

}
