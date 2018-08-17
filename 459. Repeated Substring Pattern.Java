/**
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 * Example 1:
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 * Example 2:
 * Input: "aba"
 * Output: False
 * Example 3:
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */
 
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int i=0,len = s.length();
        boolean flag = false;
        for (int j=1; j<len-1/2; j++){
            if (len%(j) != 0){
                continue;
            }
            flag = true;
            String temp = s.substring(0,j);
            i=j;
            while(i+j <= len){
                if (!temp.equals(s.substring(i,i+j))){
                    flag = false;
                    break;
                }
                i += j;
            }
            if (flag){
                return true;
            }
        }
        return false;
    }
}
