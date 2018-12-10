/**
 * Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.
 * Example 1:
 * Input: S = "loveleetcode", C = 'e'
 * Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 * Note:
 * S string length is in [1, 10000].
 * C is a single character, and guaranteed to be in string S.
 * All letters in S and C are lowercase.
 */

class Solution {
    public int[] shortestToChar(String S, char C) {
        int len = S.length(), val = 100000;
        int[] dp = new int[len];
        for (int i=0; i<len; i++){
            if (S.charAt(i) == C){
                val = 0;
            }
            dp[i] = val;
            val++;
        }
        
        dp[len-1] = S.charAt(len-1) == C ? 0 : dp[len-1];
        for (int i=len-2; i>=0; i--){
            dp[i] = dp[i] == 0 ? 0 : Math.min(dp[i], dp[i+1]+1);
        }
        
        return dp;
    }
}
