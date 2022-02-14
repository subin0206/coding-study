import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree_BFS {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(4);
        tree.left.left = new TreeNode(5);
        tree.left.right = new TreeNode(8);
        tree.left.left.left = new TreeNode(7);
        MaximumDepthOfBinaryTree_BFS a = new MaximumDepthOfBinaryTree_BFS();
        System.out.println(a.bfs(tree));
    }

    public int bfs(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            count++;
        }
        return count;
    }
}

