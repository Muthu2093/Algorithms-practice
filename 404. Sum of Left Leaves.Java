/**
 * Find the sum of all left leaves in a given binary tree.
 * Example:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
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
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)){
            return 0;
        }
        int sum = 0;
        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);
        if (root.left == null){
            return sum;
        }
        if (root.left.left == null && root.left.right == null){
            sum += root.left.val;
        }
        return sum;
    }
}
