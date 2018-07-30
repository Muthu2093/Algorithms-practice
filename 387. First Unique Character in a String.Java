/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * Examples:
 * s = "leetcode"
 * return 0.
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 */
 
class Solution {
    public int firstUniqChar(String s) {
        if (s.length() == 0){
            return -1;
        }
        if (s.length() == 1 || !s.substring(1,s.length()).contains(s.charAt(0)+"")){
            return 0;
        }
        int i = 1;
        while (i<s.length()){
            char c = s.charAt(i);
            if (!s.substring(0,i).contains(c+"") && !s.substring(i+1,s.length()).contains(c+"")){
                return i;
            }

            i++;
        }
        return -1;
        
    }
}
