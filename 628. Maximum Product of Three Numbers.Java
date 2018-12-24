/**
 * Given an integer array, find three numbers whose product is maximum and output the maximum product.
 * Example 1:
 * Input: [1,2,3]
 * Output: 6
 * Example 2:
 * Input: [1,2,3,4]
 * Output: 24
 * Note:
 * The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
 * Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
 */

class Solution {
    public int maximumProduct(int[] nums) {
        
        Comparator<Integer> comparator = new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                return b.compareTo(a);
            }
        };
        
        PriorityQueue<Integer> pqSmallest = new PriorityQueue<>(nums.length);
        PriorityQueue<Integer> pqLargest = new PriorityQueue<>(nums.length, comparator);
        for (Integer elem: nums){
            pqLargest.add(elem);
            pqSmallest.add(elem);
        }
        
        int l1 = pqLargest.poll();
        return Math.max(l1*pqLargest.poll()*pqLargest.poll(), l1*pqSmallest.poll()*pqSmallest.poll());        
    }
}
