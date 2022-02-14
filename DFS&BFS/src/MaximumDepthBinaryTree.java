import com.sun.source.tree.Tree;

class TreeNode{
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        this.val = x;
    }
}
public class MaximumDepthBinaryTree {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(4);
        tree.left.left = new TreeNode(5);
        tree.left.right = new TreeNode(8);
        tree.left.left.left = new TreeNode(7);
        MaximumDepthBinaryTree a = new MaximumDepthBinaryTree();
        System.out.println(a.maxDepth(tree));
    }

    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        return Math.max(leftMax, rightMax) +1;
    }
}
