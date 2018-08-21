/**
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 *  * Example 1:
 * Input:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Output: [3, 14.5, 11]
 * Explanation:
 * The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 * Note:
 * The range of node's value is in the range of 32-bit signed integer.
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
 
// My Solution //
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averages = new ArrayList<Double>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode dummy = new TreeNode(0);
        TreeNode temp = root;
        double sum = 0;
        int count= 0;
        queue.add(dummy);
        
        while (temp != null){
            sum += temp.val;
            count += 1;
            if (temp.left != null){
                queue.add(temp.left);
            }
            if (temp.right != null){
                queue.add(temp.right);
            }
            temp = queue.poll();
            if (temp == dummy){
                sum /= count;
                averages.add(sum);
                sum = 0;
                count = 0;
                temp = queue.poll();
                if(temp != null){
                    queue.add(dummy);
                }
            }
        }
        
        return averages;
    }
}

// Another Similiar Java Solution copied for reference //
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        double sum;
        TreeNode cur;
        while (!queue.isEmpty()) {
            sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                sum += cur.val;
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            res.add(sum / size);
        }
        return res;  
    }
}
