/**
 * Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * For example, given a 3-ary tree:
 * We should return its level order traversal:
 * [
 *      [1],
 *      [3,2,4],
 *      [5,6]
 * ]
 * Note:
 * The depth of the tree is at most 1000.
 * The total number of nodes is at most 5000.
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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        if (root != null){
            queue.offer(root);   
        }
        
        while (!queue.isEmpty() || root != null){
            List<Integer> currLevel = new ArrayList<>();
            int size = queue.size();
            for (int i=0; i<size; i++){
                root = queue.poll();
                currLevel.add(root.val);
                for (Node child: root.children){
                    queue.offer(child);
                }
                if(root.children.size() == 0){
                    root = null;
                }
            }
            
            result.add(currLevel);
        }
        
        return result;
    }
}
