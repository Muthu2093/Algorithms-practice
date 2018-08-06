/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * Example 1:
 * Input: "()"
 * Output: true
 * Example 2:
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 * Input: "(]"
 * Output: false
 * Example 4:
 * Input: "([)]"
 * Output: false
 * Example 5:
 * Input: "{[]}"
 * Output: true
 */
 
 
class Solution {
    public boolean isValid(String s) {
        if (s.length()%2 != 0){
            return false;
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i) == '('){
                sb.append(")");
            }
            else if (s.charAt(i) == '{'){
                sb.append("}");
            }
            else if (s.charAt(i) == '['){
                sb.append("]");
            }
            else if (s.charAt(i) == ')'){
                int j=sb.length()-1;
                if (j>=0 && sb.charAt(j) == ')'){
                    sb.setLength(j);
                }
                else{
                    return false;
                }
            }
            else if (s.charAt(i) == ']'){
                int j=sb.length()-1;
                if (j>=0 && sb.charAt(j) == ']'){
                    sb.setLength(j);
                }
                else{
                    return false;
                }
            }
            else if (s.charAt(i) == '}'){
                int j=sb.length()-1;
                if (j>=0 && sb.charAt(j) == '}'){
                    sb.setLength(j);
                }
                else{
                    return false;
                }
            }
        }
        if (sb.length() != 0){
            return false;
        }
        return true;
    }
}
