package LeetCode;

import java.util.Stack;

public class isBST {
    public static void main(String[] args) {
        TreeNode a = TreeNode.stringToTreeNode("[1,2,2,3,4,4,3]");
        System.out.println(isSymmetric2(a));
    }

    private static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.left == null || root.right == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root.left);
        stack.add(root.right);
        while (!stack.isEmpty()) {
            TreeNode left = stack.pop();
            TreeNode right = stack.pop();
            assert right != null;
            if (left.val != right.val)
                return false;
            if (left.left != null && right.right != null) {
                stack.add(left.left);
                stack.add(right.right);
            } else if (!(left.left == null && right.right == null))
                return false;
            if (left.right != null && right.left != null) {
                stack.add(left.right);
                stack.add(right.left);
            } else if (!(left.right == null && right.left == null))
                return false;
        }
        return true;
    }

    private static boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        return judge(root.left, root.right);
    }

    private static boolean judge(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (judge(left.left, right.right) && judge(left.right, right.left))
            return left.val == right.val;
        return false;
    }
}