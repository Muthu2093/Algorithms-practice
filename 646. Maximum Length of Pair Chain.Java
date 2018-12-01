/**
 * You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.
 * Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed in this fashion.
 * Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs. You can select pairs in any order.
 * Example 1:
 * Input: [[1,2], [2,3], [3,4]]
 * Output: 2
 * Explanation: The longest chain is [1,2] -> [3,4]
 * Note:
 * The number of given pairs will be in the range [1, 1000].
 */
 
class Solution {
    public int findLongestChain(int[][] pairs) {
        
        if (pairs.length == 0 || pairs[0].length == 0){
            return 0;
        }
        
        Arrays.sort(pairs, new Comparator<int[]>(){
            // @Override
            public int compare(int[] a, int[] b){
                return a[1]-b[1];
            }
        });
        
        int chainLen = 1;
        int prev = pairs[0][1];
        
        for (int i=0; i<pairs.length; i++){
            System.out.println(pairs[i][0] + ":" + pairs[i][1]);
            if (pairs[i][0] > prev){
                chainLen++;
                prev = pairs[i][1];
            }
        }
        
        return chainLen;
    }
}
