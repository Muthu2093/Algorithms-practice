/**
 * Given a string, your task is to count how many palindromic substrings in this string.
 * The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
 * Example 1:
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * Example 2:
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * Note:
 * The input string length won't exceed 1000.
 */


class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        int count = len;
        
        for (int i=1; i<len-1; i++){
            int p=i-1, q=i+1;
            while(p>=0 && q<len && s.charAt(p) == s.charAt(q)){
                count++;
                p--;
                q++;
            }
        }
        
        for (int i=1; i<len; i++){
            int p=i-1, q=i;
            while(p>=0 && q<len && s.charAt(p) == s.charAt(q)){
                count++;
                p--;
                q++;
            }
        }
        
        return count;
    }
}
