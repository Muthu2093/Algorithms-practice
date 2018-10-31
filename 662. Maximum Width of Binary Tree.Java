/**
 * Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.
 * The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.
 */
 
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int maxWidth = 1, n=0;
        queue.offer(root);
        
        while(!queue.isEmpty()){
            root = queue.peek();
            int levelWidth = 1, i = 0;
            boolean flag = false;
            // System.out.println("here");
            while(i < Math.pow(2,n)){
                // System.out.println("there");
                root = queue.poll();
                if (root != null){
                    flag = true;
                    queue.offer(root.left);
                    queue.offer(root.right);
                    maxWidth = Math.max(maxWidth, levelWidth);
                }
                else{
                    queue.offer(null);
                    queue.offer(null);
                }
                
                if (flag){
                    levelWidth++;
                }
                i++;
            }
            if (levelWidth == 1){
                break;
            }
            n++;
        }
        return maxWidth;
    }
}
