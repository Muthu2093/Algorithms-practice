/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean flag = true;
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        
        if (root != null){
            queue.offer(root);
        }
        
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i=0; i<size; i++){
                root = queue.poll();
                if (root.left != null){
                    queue.offer(root.left);
                }
                if (root.right != null){
                    queue.offer(root.right);
                }
                list.add(root.val);
            }
            if (flag){
                result.add(list);
            }
            else {
                Collections.reverse(list);
                result.add(list);
            }
            
            flag = !flag;
        }
        
        return result;
    }
}
