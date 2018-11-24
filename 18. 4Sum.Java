/**
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * Note:
 * The solution set must not contain duplicate quadruplets.
 * Example:
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */
 
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> result = new ArrayList<>();
        Set<Integer> visitedI = new HashSet<>();
        
        for (int i=0; i<nums.length; i++){
            if (!visitedI.contains(nums[i])){
                Set<Integer> visitedJ = new HashSet<>();
                for (int j=i+1; j<nums.length; j++){
                    if (!visitedJ.contains(nums[j])){
                        int l=j+1, r=nums.length-1;
                        int sum = nums[i] + nums[j];
                        while (l<r){
                            if (sum + nums[l] + nums[r] == target){
                                List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                                result.add(temp);
                                while (l < r && nums[l] == nums[l+1]){
                                    l++;
                                }
                                while (l < r && nums[r] == nums[r-1]){
                                    r--;
                                }
                                l++;
                            }
                            else if (sum + nums[l] + nums[r] < target){
                                l++;
                            }
                            else{
                                r--;
                            }
                        }
                        visitedJ.add(nums[j]);
                    }
                }
                visitedI.add(nums[i]);
            }
        }
        
        return result;
    }
}
