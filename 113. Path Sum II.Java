/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * Note: A leaf is a node with no children.
 * Example:
 * Given the below binary tree and sum = 22,
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * Return:
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
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
    List<List<Integer>> result;
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<List<Integer>>();
        List<Integer> currPathList= new ArrayList<Integer>();
        pathSumRec(root, sum, 0, currPathList);
        
        return result;
    }
    
    public void pathSumRec(TreeNode root, int sum, int currPathSum, List<Integer> currPathList){
        List<Integer> temp = new ArrayList(currPathList);
        if (root == null){
            return;
        }
        
        currPathSum += root.val;
        temp.add(root.val);
        
        pathSumRec(root.left, sum, currPathSum, temp);
        pathSumRec(root.right, sum, currPathSum, temp);
        
        if (root.left == null && root.right == null && sum == currPathSum){
            result.add(temp);
        }
        
        return;
    }
}
