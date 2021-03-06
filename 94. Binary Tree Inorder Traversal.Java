/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * Example:
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 * Output: [1,3,2]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();
        
        while(!stack.empty() || root != null){            
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        
        return result;
    }
}
