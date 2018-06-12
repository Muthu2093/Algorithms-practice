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
        if (strs.length == 1){
            return strs[0];
        }
        if (strs.length == 0 || strs[0].length() == 0){
            return "";
        }
        int i=0,j=0;
        boolean flag=false;
        
        for (i=0;i<strs[0].length() && flag == false;i++){
            for (j=1; j< strs.length; j++){
                String s = strs[j];
                if (s.length() <= i){
                    if (j == strs.length - 1){
                        j = j -1;
                    }
                    flag = true;
                    break;
                }
                if (s.charAt(i) != strs[0].charAt(i)){
                    if (j == strs.length - 1){
                        j = j -1;
                    }
                    flag = true;
                    break;
                }
            }
        }
        if (flag == false){
            return strs[0];
        }
        return (strs[1].substring(0,i-1));
    }
}
