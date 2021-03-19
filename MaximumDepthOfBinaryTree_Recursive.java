import jdk.nashorn.api.tree.Tree;

public class MaximumDepthOfBinaryTree_Recursive {
    public static void main(String[] args) {
        // 1. left, right 호출 (null까지)
        // 2. Math.max(leftMax, rightMax) 를 이용한다
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(4);
        tree.left.left = new TreeNode(5);
        tree.left.right = new TreeNode(8);
        tree.left.left.left = new TreeNode(7);
        MaximumDepthOfBinaryTree_Recursive a =new MaximumDepthOfBinaryTree_Recursive();
        System.out.println(a.maxDepth(tree));
    }
    public int maxDepth(TreeNode root){
        if(root==null) return 0;

        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        return Math.max(leftMax,rightMax)+1;
    }
}
