/**
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 * Example:
 * Given a binary tree 
 *           1
 *          / \
 *        2   3
 *       / \     
 *       4   5    
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * Note: The length of path between two nodes is represented by the number of edges between them.
 * Seen this question in a real interview before?  
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
    public int diameterOfBinaryTree(TreeNode root) {
        int res[] = new int[2];
        res = diameterRec(root);
        return res[0];
    }
    public int[] diameterRec(TreeNode root){
        int[] res = new int[2];
        if (root == null){
            return res;
        }
        int lheight[] = diameterRec(root.left);
        int rheight[] = diameterRec(root.right);
        res[0] = Math.max(lheight[0], rheight[0]);
        res[0] = Math.max((lheight[1] + rheight[1]), res[0]);
        res[1] = Math.max(lheight[1]+1, rheight[1]+1);
        
        return res;
    }
}
