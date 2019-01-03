/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 * Example:
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
 
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        result.add(new ArrayList<>());
        subsets(nums, new ArrayList<>(), 0);
        return result;
    }
    
    public void subsets(int[] nums, List<Integer> list , int index){
        if (index == nums.length){
            return;
        }
        
        for (int i=index; i<nums.length; i++){
            List<Integer> temp = new ArrayList(list);
            temp.add(nums[i]);
            result.add(temp);
            subsets(nums, temp, i+1);
        }
    }
}
