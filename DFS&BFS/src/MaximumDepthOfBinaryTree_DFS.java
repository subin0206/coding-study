import com.sun.source.tree.Tree;

import java.util.Stack;

public class MaximumDepthOfBinaryTree_DFS {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(4);
        tree.left.left = new TreeNode(5);
        tree.left.right = new TreeNode(8);
        tree.left.left.left = new TreeNode(7);
        MaximumDepthOfBinaryTree_DFS a = new MaximumDepthOfBinaryTree_DFS();
        System.out.println(a.dfs(tree));
    }

    public int dfs(TreeNode root) {
        if(root==null) return 0;
        Stack<TreeNode> stack = new Stack();
        Stack<Integer> valueStack = new Stack<>();
        stack.push(root);
        valueStack.push(1);//current level
        int max = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int count = valueStack.pop();
            max = Math.max(max,count);
            if (node.left != null) {
                stack.push(node.left);
                valueStack.push(1+count);
            }
            if (node.right != null) {
                stack.push(node.right);
                valueStack.push(1+count);
            }
        }
        return max;
    }
}
