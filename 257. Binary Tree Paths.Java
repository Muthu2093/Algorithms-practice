/**
 * Given a binary tree, return all root-to-leaf paths.
 * Note: A leaf is a node with no children.
 * Example:
 * Input:
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 * Output: ["1->2->5", "1->3"]
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        String curr = "";
        result = binaryTreePathsRec(root, curr);
        return result;
    }
    public List<String> binaryTreePathsRec(TreeNode root, String curr) {
        List<String> result = new ArrayList<String>();
        if (root == null){
            return result;
        }
        curr = curr + "->" + Integer.toString(root.val);
        result.addAll(binaryTreePathsRec(root.left, curr));
        result.addAll(binaryTreePathsRec(root.right, curr));
        if (root.left == null && root.right == null){
            curr = curr.substring(2,curr.length());
            result.add(curr);
        }
        return result;
    }
    
}
