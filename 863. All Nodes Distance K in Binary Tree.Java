/**
 * We are given a binary tree (with root node root), a target node, and an integer value K.
 * Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.
 * Example 1:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 * Output: [7,4,1]
 * Explanation: 
 * The nodes that are a distance 2 from the target node (with value 5)
 * have values 7, 4, and 1.
 * Note that the inputs "root" and "target" are actually TreeNodes.
 * The descriptions of the inputs above are just serializations of these objects.
 * Note:
 * The given tree is non-empty.
 * Each node in the tree has unique values 0 <= node.val <= 500.
 * The target node is a node in the tree.
 * 0 <= K <= 1000.
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
    HashMap<TreeNode,Integer> hash= new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res= new ArrayList<>();
        if (K==0){
            res.add(target.val);
            return res;
        }
        res.addAll(distanceLeaves(target, K));
        int distance = disBelow(root,target)-1;
        while(root != target){
            //System.out.println(root.val + ":" + distance);
            if (distance == K){
                res.add(root.val);
                distance -= 1;
                if (root.right == target){
                    root = root.right;
                }
                else if (root.left == target){
                    root = root.left;
                }
                else{
                    root = hash.get(root.right) == null ? root.left: root.right;
                }
            }
            else if (distance < K){
                if (root.right == target || hash.get(root.right) != null){
                    res.addAll(distanceLeaves(root.left, K-distance-1));
                    root = root.right;
                }
                else if (root.left == target || hash.get(root.left) != null){
                    res.addAll(distanceLeaves(root.right, K-distance-1));
                    root = root.left;
                }
                distance -= 1;
            }
            else{
                root = hash.get(root.right) == null ? root.left: root.right;
                distance -= 1;
            }
        }
        return res;
    }
    
    public List<Integer> distanceLeaves(TreeNode root, int k){
        List<Integer> leaves= new ArrayList<>();
        if (root == null || k < 0){
            return leaves;
        }
        if (k == 0){
            leaves.add(root.val);
            return leaves;
        }
        leaves.addAll(distanceLeaves(root.left, k-1));
        leaves.addAll(distanceLeaves(root.right, k-1));
        return leaves;
    }
    
    public int disBelow(TreeNode root, TreeNode target){
        if (root == null){
            return -1;
        }
        if (root == target){
            return 1;
        }
        int dist = 0;
        dist = disBelow(root.left, target);
        if (dist != -1){
            hash.put(root, dist);
            return dist+1;
        }
        dist = disBelow(root.right, target);
        if (dist != -1){
            hash.put(root, dist);
            return dist+1;
        }
        return dist;
        
    }
}
