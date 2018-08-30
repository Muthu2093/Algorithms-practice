/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
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
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null){
            return result;
        }
        List<Integer> temp = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode marker = new TreeNode(0);
        queue.add(root);
        queue.add(marker);
        
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            temp.add(curr.val);
            if (curr.left != null){
                queue.add(curr.left);
            }
            if (curr.right != null){
                queue.add(curr.right);
            }
            
            if (queue.peek() == marker){
                queue.poll();
                result.add(0, temp);
                if (queue.peek() != null){
                    temp = new ArrayList<Integer>();
                    queue.add(marker);
                }
            }
        }
        
        return result;
    }
}
