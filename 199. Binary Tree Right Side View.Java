/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * Example:
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> dq = new LinkedList<>();
        if (root != null){
            dq.offerLast(root);
        }
        
        while (!dq.isEmpty()){
            result.add(dq.peekLast().val);
            int size = dq.size();
            for (int i=0; i<size; i++){
                root = dq.pollFirst();
                if (root.left != null){
                    dq.offer(root.left);
                }
                if (root.right != null){
                    dq.offer(root.right);
                }
            }
        }
        
        return result;
    }
}
