/*
 * Given an n-ary tree, return the postorder traversal of its nodes' values.
 * For example, given a 3-ary tree:
 * Return its postorder traversal as: [5,6,3,2,4,1].
 * Note:
 * Recursive solution is trivial, could you do it iteratively?
 */

// Using Recursion //
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    List<Integer> result;
    public List<Integer> postorder(Node root) {
        result = new ArrayList<Integer>();
        recurse(root);
        return result;
    }
    
    public void recurse(Node root){
        if (root == null){
            return;
        }
        for (Node child: root.children){
            recurse(child);
        }
        
        result.add(root.val);
        return;
    }
}
