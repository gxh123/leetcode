import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

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

        inorderTraversal(root);
    }

    // 非递归前序遍历
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode p = root;
        while (p != null || !s.isEmpty()) {
            while (p != null) {
                result.add(p.val);
                s.push(p);
                p = p.left;
            }
            if (!s.empty()) {
                p = s.peek();
                s.pop();
                p = p.right;
            }
        }
        return result;
    }

    // 非递归中序遍历
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode p = root;
        while (p != null || !s.isEmpty()) {
            while (p != null) {
                s.push(p);
                p = p.left;
            }
            if (!s.empty()) {
                p = s.peek();
                result.add(p.val);
                s.pop();
                p = p.right;
            }
        }
        return result;
    }

    // 非递归后序遍历-迭代
    void postorderTraversal(TreeNode root) {
        // 写不出来，有时间再看
    }

    // 递归实现
    public static List<Integer> inorderTraversal2(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    private static void inorderTraversal(TreeNode root, List<Integer> result) {
        if (root.left != null)
            inorderTraversal(root.left, result);
        result.add(root.val);
        if (root.right != null)
            inorderTraversal(root.right, result);
    }

}
