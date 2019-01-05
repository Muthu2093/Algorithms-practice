/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
 * Example:
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7] 
 * Explanation: 
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
 * Follow up:
 * Could you solve it in linear time?
 */

// Two pass - O(n) solution - using priority queue// 
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0){
            return new int[0];
        }
        int[] left_max = new int[nums.length];
        int[] right_max = new int[nums.length];
        int[] result = new int[nums.length-k+1];
        
        for (int i=0; i<nums.length; i++){
            left_max[i] = (i == 0 || i%k == 0) ? nums[i] : Math.max(nums[i], left_max[i-1]);
        }

        for (int i=nums.length-1; i>=0; i--){
            right_max[i] = (i == nums.length-1 || i%k == k-1) ? nums[i] : Math.max(nums[i], right_max[i+1]);
        }

        for (int i=0, j=0; i+k-1<nums.length; i++,j++){
            result[i] = Math.max(right_max[i], left_max[i+k-1]);
        }
        
        
        return result;
    }
}

// Single pass - O(n*logn) solution

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0){
            return new int[0];
        }
        int[] result = new int[nums.length-k+1];
        
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(new Comparator<List<Integer>>(){
            @Override
            public int compare(List<Integer> a, List<Integer> b){
                return b.get(0).compareTo(a.get(0));
            }
        });
                
        for (int i=0; i<k-1; i++){
            List<Integer> entry = new ArrayList<>();
            entry.add(nums[i]);
            entry.add(i);
            pq.offer(entry);
        }
        
        for (int i=k-1; i<nums.length;i++){
            List<Integer> entry = new ArrayList<>();
            entry.add(nums[i]);
            entry.add(i);
            pq.offer(entry);
                
            entry = pq.poll();
            while (entry.get(1)<i-k+1){
                entry = pq.poll();
            }
            if (entry.get(1) > i-k+1){
                pq.offer(entry);
            }
            result[i-k+1] = entry.get(0);            
        }
        
        return result;
    }
}
