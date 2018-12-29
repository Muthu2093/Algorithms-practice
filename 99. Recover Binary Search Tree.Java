/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 * Example 1:
 * Input: [1,3,null,null,2]
 *    1
 *   /
 *  3
 *   \
 *    2
 * Output: [3,1,null,null,2]
 *    3
 *   /
 *  1
 *   \
 *    2
 * Example 2:
 * Input: [3,1,4,null,null,2]
 *   3
 *  / \
 * 1   4
 *    /
 *   2
 * Output: [2,1,4,null,null,3]
 *   2
 *  / \
 * 1   4
 *    /
 *   3
 * Follow up:
 * A solution using O(n) space is pretty straight forward.
 * Could you devise a constant space solution?
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
    TreeNode prev, left, right;
    public void recoverTree(TreeNode root) {
        left = null;
        right = null;
        prev = null;
        
        recoverTreeRec(root);
        if (left != null && right != null){
            left.val += right.val;
            right.val = left.val - right.val;
            left.val = left.val - right.val;
        }
    }
    
    public void recoverTreeRec(TreeNode root){
        if (root == null){
            return;
        }
        recoverTreeRec(root.left);
        if (prev != null && prev.val > root.val){
            if (left == null){
                left = prev;
                right = root;
            }
            else{

                right = root;
                return;
            }
        }
        prev = root;
        recoverTreeRec(root.right);
    }
}
