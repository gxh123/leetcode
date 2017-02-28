public class SameTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.left.left = new TreeNode(1);
        // root1.left.right = new TreeNode(3);
        root1.right = new TreeNode(7);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(9);

        System.out.print(isSameTree(root, root1));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null)
            return false;
        if (q == null)
            return false;

        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
