/**
 * You are given a binary tree in which each node contains an integer value.
 * Find the number of paths that sum to a given value.
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 * Example:
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 * Return 3. The paths that sum to 8 are:
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
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
    int count; 
    
    public int pathSum(TreeNode root, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        return pathSum(root, target, map, 0); 
    }
    
    public int pathSum(TreeNode root, int target, HashMap<Integer, Integer> map, int currSum){
        if (root == null){
            return 0;
        }
        
        int count = 0;
        currSum += root.val;
        if (map.containsKey(currSum - target)){
            count += map.get(currSum-target);
        }
        
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        
        count += pathSum(root.left, target, map, currSum);
        count += pathSum(root.right, target, map, currSum);
        map.put(currSum, map.get(currSum)-1);
        
        return count;
    }
    
}
