import java.util.*;

class TreeNode{
    int val;
    TreeNode left,right;
    TreeNode(int x){
        this.val = x;
    }
}

public class BinaryTree {
    public static void main(String[] args) {
        //input 1 > 3
        //      2  4 5
        //      3 6 7

        //out [[3],[4,5],[6,7]]

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(7);
        System.out.println( solve(root));
    }

    public static List<List<Integer>> solve(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if(root==null)
            return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);


        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new LinkedList<>();
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                list.add(node.val);
                if(node.left !=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
            }

            result.add(list);
        }
        return result;


    }
}
