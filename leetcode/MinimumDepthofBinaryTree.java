import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthofBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        // root.left = new TreeNode(4);
        // root.left.left = new TreeNode(11);
        // // root.left.right = new TreeNode(3);
        // root.right = new TreeNode(8);
        // root.right.left = new TreeNode(13);
        // root.right.left.left = new TreeNode(13);
        // root.right.right = new TreeNode(4);
        //
        // root.left.left.left = new TreeNode(7);
        // root.left.left.right = new TreeNode(2);
        //
        // root.right.right.right = new TreeNode(1);

        System.out.println(minDepth(root));
    }

    public static int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        int depth = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left == null && node.right == null)
                    return depth;
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
        }
        throw new RuntimeException();
    }

}
