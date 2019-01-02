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
    Map<Integer,Integer> map;
    public int[] findFrequentTreeSum(TreeNode root) {
        map = new HashMap<>();
        freqSum(root);
        List<Integer> list = new ArrayList<>();
        int sum = Integer.MIN_VALUE;
        
        for (Map.Entry<Integer, Integer> entry: map.entrySet()){
            if (entry.getValue() > sum){
                sum = entry.getValue();
                list = new ArrayList<>();
                list.add(entry.getKey());                
            }
            else if (entry.getValue() == sum){
                list.add(entry.getKey());
            }
        }
        int[] result = new int[list.size()];
        for (int i=0; i<list.size(); i++){
            result[i] = list.get(i);
        }
        return result;
    }
    
    public int freqSum(TreeNode root){
        if (root == null){
            return 0;
        }
        
        int l = freqSum(root.left), r = freqSum(root.right), sum = l + r + root.val;
        map.put(sum, map.getOrDefault(sum,0) + 1);
        
        return sum;
    }
}
