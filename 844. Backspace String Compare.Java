/** 
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 * Example 1:
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * Example 2:
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * Example 3:
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 * Example 4:
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 * Note:
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S and T only contain lowercase letters and '#' characters.
 * Follow up:
 * Can you solve it in O(N) time and O(1) space?
 */
 
class Solution {
    public boolean backspaceCompare(String S, String T) {
        int len = S.length();
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        for (int i=0; i<len; i++){
            char c = S.charAt(i);
            if (c != '#'){
                s1.append(c);
            }
            else if(!s1.equals("")){
                s1 = s1.deleteCharAt(s1.length()-1);
            }
        }
        len = T.length();
        for (int i=0; i<len; i++){
            char c = T.charAt(i);
            if (c != '#'){
                s2.append(c);
            }
            else if(!s2.equals("")){
                s2 = s2.deleteCharAt(s2.length()-1);
            }
        }
        return (s1.equals(s2));
    }
}
