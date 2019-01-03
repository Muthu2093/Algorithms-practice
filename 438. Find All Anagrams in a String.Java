/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * The order of output does not matter.
 * Example 1:
 * Input:
 * s: "cbaebabacd" p: "abc"
 * Output:
 * [0, 6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 * Input:
 * s: "abab" p: "ab"
 * Output:
 * [0, 1, 2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
 
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] flag1 = new int[26], flag2 = new int[26];
        char[] str1 = s.toCharArray(), str2 = p.toCharArray();
        List<Integer> result = new ArrayList<>();
        if (str1.length < str2.length){
            return result;
        }
        
        for (int i=0; i<str2.length; i++){
            flag1[str1[i] - 'a']++;
            flag2[str2[i] - 'a']++;
        }
        
        int l=0, r=str2.length;
        
        while (r<str1.length){
            
            if(checkIfAnagram(flag1, flag2)){
                result.add(l);
            }
            flag1[str1[l++] - 'a']--;
            flag1[str1[r++] - 'a']++;
        }
        
        if(checkIfAnagram(flag1, flag2)){
            result.add(l);
        }
        
        return result;
    }
    
    public boolean checkIfAnagram(int[] flag1, int[] flag2){
        boolean flag = true;
        for (int i=0; i<26 && flag;i++){
            if (flag1[i] != flag2[i]){
                flag = false;
            }
        }
        
        return flag;
    }
}
