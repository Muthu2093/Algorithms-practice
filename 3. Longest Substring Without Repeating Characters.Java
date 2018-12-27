/**
 * Given a string, find the length of the longest substring without repeating characters.
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */ 


// Using Hash table //
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hash = new HashMap<>();
        char[] ch = s.toCharArray();
        int maxLen = 0;
        int startLen = 0;
        
        for (int i=0; i<ch.length; i++){
            if (hash.containsKey(ch[i])){
                startLen = Math.max(hash.get(ch[i]) + 1, startLen);
            }
            hash.put(ch[i], i); 
            maxLen = Math.max(maxLen, i-startLen+1);
        }
        
        return maxLen;
    }
}


// Using Two Pointers //
class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] index = new boolean[128];
        char[] ch = s.toCharArray();
        int i = 0, j=0, maxLen = 0;
        
        while(i < ch.length && j<ch.length){
            if (!index[ch[j]]){
                index[ch[j]] = true;
            }
            else{
                while (i<j && ch[i] != ch[j]){
                    index[ch[i++]] = false;
                }
                i++;
            }
            
            maxLen = Math.max(maxLen, ++j-i);
        }
        
        return maxLen;
    }
}
