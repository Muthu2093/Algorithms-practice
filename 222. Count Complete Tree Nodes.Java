/**
 * Given a complete binary tree, count the number of nodes.
 * Note:
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 * Example:
 * Input: 
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 * Output: 6
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
    public static boolean flag = false;
    public static int depth = 0;
    public int countNodes(TreeNode root) {
        int count = countNodesRec(root);
        if (flag){
            count += countLeavesRec(root, -1);
        }
        return count;
    }
    public int countNodesRec(TreeNode root){
        int count = 0;
        if (root == null){
            return count;
        }
        if (root.left != null) {
            count += (int) Math.pow (2,depth);
            depth++;
            count += countNodesRec(root.left);
        }
        else{
            flag = true;
        }
        return count;
    }
    public int countLeavesRec(TreeNode root,int curDepth){
        curDepth++;
        if (root == null){
            return 0;
        }
        if (curDepth == depth){
            if (root.left == null && root.right == null){
                return 1;
            }
            else {
                return 0;
            }
        }
        int leafLength = 0;
        leafLength += countLeavesRec(root.left, curDepth);
        leafLength += countLeavesRec(root.right, curDepth);
        return leafLength;
    }
}
