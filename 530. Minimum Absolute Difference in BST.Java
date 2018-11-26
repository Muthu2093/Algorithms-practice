/**
 * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
 * Example:
 * Input:
 *    1
 *     \
 *      3
 *     /
 *    2
 * Output:
 * 1
 * Explanation:
 * The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 * Note: There are at least two nodes in this BST.
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
    int minVal;
    int prev;
    public int getMinimumDifference(TreeNode root) {
        minVal = +100000;
        prev = -100000;
        
        getMinimumDifferenceRec(root);
        return minVal;
    }
    
    public void getMinimumDifferenceRec(TreeNode root){
        if (root == null){
            return;
        }
        
        getMinimumDifferenceRec(root.left);
        
        minVal = Math.min(minVal, Math.abs(root.val - prev));
        prev = root.val;
        
       getMinimumDifferenceRec(root.right);
    }
}
