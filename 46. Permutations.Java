/**
 * Given a collection of distinct integers, return all possible permutations.
 * Example:
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
 
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        Set<Integer> flag = new HashSet<>();
        permute(nums, 0, new ArrayList<>(), flag);
        
        return result;
    }
    
    public void permute(int[] nums, int index, List<Integer> list, Set<Integer> flag){
        if(index == nums.length){
            result.add(list);
            return;
        }
        
        for (int i=0; i<nums.length; i++){
            List<Integer> tempList = new ArrayList<>(list);
            Set<Integer> tempSet = new HashSet<>(flag);
            
            if (!tempSet.contains(nums[i])){
                tempSet.add(nums[i]);
                tempList.add(nums[i]);
                permute(nums, index+1, tempList, tempSet);
            }
        }
    }
}
