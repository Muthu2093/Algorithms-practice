/**
 * S and T are strings composed of lowercase letters. In S, no letter occurs more than once.
 * S was sorted in some custom order previously. We want to permute the characters of T so that they match the order that S was sorted. More specifically, if x occurs before y in S, then x should occur before y in the returned string.
 * Return any permutation of T (as a string) that satisfies this property.
 * Example :
 * Input: 
 * S = "cba"
 * T = "abcd"
 * Output: "cbad"
 * Explanation: 
 * "a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a". 
 * Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda" are also valid outputs.
 */ 

/**
 * Note:
 * S has length at most 26, and no character is repeated in S.
 * T has length at most 200.
 * S and T consist of lowercase letters only.
 */
 
class Solution {
    
    public String customSortString(String S, String T) {
        int[] charS = new int[26];
        int len = S.length();
        
        for (int i=0; i<len; i++){
            int temp = S.charAt(i) - 'a';
            charS[temp] = i;
        }
    
        String[] charT = new String[26];
        len = T.length();
        
        for (int i=0; i<len; i++){
            int temp = T.charAt(i) - 'a';
            if (charT[charS[temp]] != null){
                charT[charS[temp]] += T.charAt(i);
            }
            else{
                charT[charS[temp]] = String.valueOf(T.charAt(i));
            }
        }
        
        String str = "";
        for (int i=0; i<26; i++){
            if (charT[i] != null){
                str += charT[i];
            }
        }
        return str;
    }
}
