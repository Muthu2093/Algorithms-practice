/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 * Each letter in the magazine string can only be used once in your ransom note.
 * Note:
 * You may assume that both strings contain only lowercase letters.
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ranCount = new int[26];
        int[] magCount = new int[26];
        
        for (Character ch: ransomNote.toCharArray()){
            ranCount[ch - 'a'] += 1;
        }
        
        for (Character ch: magazine.toCharArray()){
            magCount[ch - 'a'] += 1;
        }
        
        for (int i=0; i<26; i++){
            if(ranCount[i] > magCount[i]){
                return false;
            }
        }
        
        return true;
    }
}
