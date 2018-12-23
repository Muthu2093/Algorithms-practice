/** 
 * Given an n-ary tree, return the preorder traversal of its nodes' values.
 * For example, given a 3-ary tree:
 * Return its preorder traversal as: [1,3,5,6,2,4].
 * Note:
 * Recursive solution is trivial, could you do it iteratively?
 */
 
/*
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
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<Node> stack = new Stack<>();
        
        while (!stack.empty() || root != null){
            if (root == null){
                root = stack.pop();
            }
            
            result.add(root.val);
            for (int i=root.children.size()-1; i>0; i--){
                stack.push(root.children.get(i));
            }
            
            if (root.children.size() > 0){
                root = root.children.get(0);
            }
            else{
                root = null;
            }
        }
        
        return result;
    }
}
