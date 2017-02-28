import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

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

        binaryTreePaths(root);
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<String> result = new ArrayList<>();
        binaryTreePaths(root, "", result);
        return result;
    }

    // 借鉴了排列那个程序的思想：递归，输入的参数是：当前节点，已经走过的路径，结果（因为要输出所有路径）
    public static void binaryTreePaths(TreeNode root, String path, List<String> result) {
        if (root.left == null && root.right == null) { // 到达叶子节点
            StringBuilder sb = new StringBuilder(path);
            sb.append(root.val);
            result.add(sb.toString());
        } else {
            StringBuilder sb = new StringBuilder(path); // 这边其实不用StringBuilder，直接加也可以
            sb.append(root.val + "->"); // 加上当前节点以后的路径
            if (root.left != null) {
                binaryTreePaths(root.left, sb.toString(), result); // 去往下一层
            }
            if (root.right != null) {
                binaryTreePaths(root.right, sb.toString(), result);
            }
        }
    }

}
