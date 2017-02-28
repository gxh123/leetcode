public class SymmetricTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetric(root.left, root.right);
    }

    // 直接在一棵树上递归遍历是不对的，只能访问一个子树，要同时遍历左右两个子树才能判断是否镜像
    public static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null)
            return false;
        if (right == null)
            return false;
        return (left.val == right.val) && isSymmetric(left.left, right.right)
                && isSymmetric(left.right, right.left);
    }

}
