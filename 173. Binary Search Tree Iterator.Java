/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 */
 
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    
    Stack<TreeNode> stack;
    TreeNode root;
    
    public BSTIterator(TreeNode curr) {
        stack = new Stack<>();
        root = curr;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (!stack.empty() || root != null);
    }

    /** @return the next smallest number */
    public int next() {
        int val = -1;
        while(root != null){
            stack.push(root);
            root = root.left;
        }
        if (!stack.empty()){
            root = stack.pop();
            val = root.val;
            root = root.right;
        }
        
        return val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
