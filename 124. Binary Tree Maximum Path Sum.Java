/**
 * Given a non-empty binary tree, find the maximum path sum.
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 * Example 1:
 * Input: [1,2,3]
 *        1
 *       / \
 *      2   3
 * Output: 6
 * Example 2:
 * Input: [-10,9,20,null,null,15,7]
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Output: 42
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
    
    static int max;
    
    public int maxPathSum(TreeNode root) {
        
        max = Integer.MIN_VALUE;
        maxPathSumRec(root);
        
        if (max == Integer.MIN_VALUE){
            max = 0;
        }
        
        return max;
    }
    public int maxPathSumRec(TreeNode root){

        if (root == null){
            return 0;
        }
        
        int left = maxPathSumRec(root.left);
        int right = maxPathSumRec(root.right);
        
        int curr_max = root.val;
        if (left >= 0 && right >=0){
            curr_max += Math.max(left,right);
        }
        else if (right >= 0){
            curr_max += right;
        }
        else if (left >= 0){
            curr_max += left;
        }
        
        max = Math.max(max, curr_max);
        max = Math.max(max, root.val + left + right);
        
        return curr_max;
    }
}
