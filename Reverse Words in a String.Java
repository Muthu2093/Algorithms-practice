/**
 * Given an input string, reverse the string word by word.
 * Example:  
 * Input: "the sky is blue",
 * Output: "blue is sky the".
 * Note:
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in the reversed string.
 * Follow up: For C programmers, try to solve it in-place in O(1) space.
 */
 
 
public class Solution {
    public String reverseWords(String s) {
        int len = s.length();
        StringBuilder rev = new StringBuilder(s.length());
        s = s.trim() + ' ';
        boolean flag = false;
        for (int i=0; i<s.length(); i++){
            StringBuilder temp = new StringBuilder();
            while(s.charAt(i) != ' '){
                temp.append(s.charAt(i));
                i++;
                flag = true;
            }
            if (flag){
                temp.append(' ');
                rev.insert(0,temp);
                flag = false;
            }
        }
        return rev.toString().trim();
    }
}
