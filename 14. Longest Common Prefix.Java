/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".

 * Example 1:
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:

 * All given inputs are in lowercase letters a-z.
 */


class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return new String("");
        }
        int i=0;
        while (i<strs[0].length()){
            char ch = strs[0].charAt(i);
            for (int j=1; j<strs.length; j++){
                if (i == strs[j].length()){
                    return strs[j];
                }
                
                if (strs[j].charAt(i) != ch){
                    return strs[j].substring(0, i);
                }
            }
            i++;
        }
        
        return strs[0];
    }
}
