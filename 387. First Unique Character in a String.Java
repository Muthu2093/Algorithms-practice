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
        int[] flag = new int[26];
        
        int len = s.length();
        for (int i=0; i<len; i++){
            int index = (int)(s.charAt(i) - 'a');
            flag[index]++;
        }
        
        for (int i=0; i<len; i++){
            int index = (int)(s.charAt(i) - 'a');
            if (flag[index] == 1){
                return i;
            }
        }
        
        return -1;
    }
}
