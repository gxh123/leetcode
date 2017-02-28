public class TravelTree {

    // 递归遍历一棵树
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        // int sum[] = new int[1];
        // travel(root, sum);
        // System.out.println(sum[0]);
        System.out.println(travel(root));
    }

    // 核心
    // public static void travel(TreeNode root) {
    // if (root == null)
    // return;
    // travel(root.left);
    // travel(root.right);
    // }

    // public static void travel(TreeNode root, int[] sum) {
    // if (root == null)
    // return;
    // if (root.left != null) {
    // if (root.left.left == null && root.left.right == null) {
    // sum[0] += root.left.val;
    // System.out.println(root.left.val);
    // }
    // }
    // travel(root.left, sum);
    // travel(root.right, sum);
    // }

    public static int travel(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                return root.left.val + travel(root.right);
            }
        }
        return travel(root.left) + travel(root.right);
    }
}
