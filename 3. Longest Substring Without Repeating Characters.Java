/**
 * Given a string, find the length of the longest substring without repeating characters.
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */    
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s.length() == 1){
            return s.length();
        }
        int length = 0;
        HashMap <Character, Integer> flag = new HashMap<>();
        for(int i=0,j=0; j<s.length(); j++){
            if(flag.containsKey(s.charAt(j))){
                i = Math.max(flag.get(s.charAt(j)), i);
            }
            flag.put(s.charAt(j),j+1);
            length = Math.max(length,j-i+1);
        }
        return length;
    }
}
