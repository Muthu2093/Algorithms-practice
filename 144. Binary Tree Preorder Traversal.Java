/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * Example:
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 * Output: [1,2,3]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
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
 
//Iterative//
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        if (root == null){
            return nodes;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            while (curr != null){
                stack.push(curr.right);
                nodes.add(curr.val);
                curr = curr.left;
            }
        }
        return nodes;
    }
}

// Recursive //
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        if (root == null){
            return nodes;
        }
        nodes.add(root.val);
        nodes.addAll(preorderTraversal(root.left));
        nodes.addAll(preorderTraversal(root.right));
        return nodes;
    }
}
