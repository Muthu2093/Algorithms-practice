/**
 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
 * Example:
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * Restrictions:
 * The string consists of lower English letters only.
 * Length of the given string and k will in the range [1, 10000]
 */
 
class Solution {
    public String reverseStr(String s, int k) {
        StringBuilder result = new StringBuilder();
        int len = s.length();
        for (int i=0; i<len; i += 2*k){
            int lim = Math.min(i+k, len);
            StringBuilder subStr = new StringBuilder(s.substring(i,lim));
            subStr.reverse();
            result.append(subStr);
            if (lim < len){
                lim = Math.min(i+k+k, len);
                subStr = new StringBuilder(s.substring(i+k, lim));
                result.append(subStr);
            }
        }
        
        return result.toString();
    }
}
