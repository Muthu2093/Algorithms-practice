/**
 * Given a binary tree, find the leftmost value in the last row of the tree.
 * Example 1:
 * Input:
 *     2
 *    / \
 *   1   3
 * Output:
 * 1
 * Example 2: 
 * Input:
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 * Output:
 * 7
 * Note: You may assume the tree (i.e., the given root node) is not NULL.
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
    
    public int findBottomLeftValue(TreeNode root) {
        int height =  findHeight(root, 0);
        //System.out.println(height);
        return findBottomRecurse(root, 0, height);
    }
    
    public int findHeight(TreeNode root, int level){
        if (root == null){
            return --level;
        }
        
        int lheight = findHeight(root.left, level+1);
        int rheight = findHeight(root.right, level+1);
        
        return lheight > rheight ? lheight: rheight;
    }
    
    public int findBottomRecurse(TreeNode root, int level, int height){
        if (root == null){
            return -999; // some random value
        }
        if (level == height){
            return root.val;
        }
        int val = findBottomRecurse(root.left, level+1, height);
        if (val == -999){
            return findBottomRecurse(root.right, level+1, height);
        }
        return val;
    }
}
