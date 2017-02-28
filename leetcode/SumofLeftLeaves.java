import java.util.LinkedList;
import java.util.Queue;

public class SumofLeftLeaves {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.print(sumOfLeftLeaves(root));
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int sum = 0;
        while (!q.isEmpty()) {
            int length = q.size();
            for (int i = 0; i < length; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.offer(node.left);
                    if (node.left.left == null && node.left.right == null) {
                        sum += node.left.val;
                    }
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }
        return sum;
    }

}
