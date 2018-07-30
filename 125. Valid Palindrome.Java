/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 * Example 1:
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * Example 2:
 * Input: "race a car"
 * Output: false
 */
 
class Solution {
    public boolean isPalindrome(String s) {
        //s = s.toLowerCase();
        for (int i=0, j=s.length()-1; i<j; i++,j--){
            while(i<s.length() && !(Character.isLetterOrDigit(s.charAt(i)))){
                i++;
            }
            while(j>0 && !(Character.isLetterOrDigit(s.charAt(j)))){
                j--;
            }
            if (i>j){
                break;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                return false;
            }
        }
        return true;
        
    }
}
