public class PathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        // root.left.right = new TreeNode(3);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.right.right = new TreeNode(1);

        System.out.println(hasPathSum(root, 18));

    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        return hasPathSum(root, 0, sum);
    }

    // 必须要到叶子节点
    public static boolean hasPathSum(TreeNode root, int currentSum, int targetSum) {
        // if (root == null)
        // return currentSum == targetSum;
        if (root.left == null && root.right == null)
            return (currentSum + root.val) == targetSum;
        currentSum += root.val;
        boolean left = false, right = false;
        if (root.left != null) {
            left = hasPathSum(root.left, currentSum, targetSum);
        }
        if (root.right != null) {
            right = hasPathSum(root.right, currentSum, targetSum);
        }
        return left || right; // 直接写会空指针
        // return (currentSum == targetSum) || hasPathSum(root.left, currentSum, targetSum)
        // || hasPathSum(root.right, currentSum, targetSum);
    }

}
