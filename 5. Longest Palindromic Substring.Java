/ **
  * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

  * Example 1:

  * Input: "babad"
  * Output: "bab"
  * Note: "aba" is also a valid answer.
  * Example 2:

  * Input: "cbbd"
  * Output: "bb"
*/

public class Solution {
    public String longestPalindrome(String s) {
        int i, startInd = 0, endInd = 1, maxLen = 0;
        char[] ch = s.toCharArray();
        
        for (i=0; i<ch.length-1; i++){
            int countOdd = isPalindrome(ch, i, i), countEven = isPalindrome(ch, i, i+1);
            if (countOdd*2 - 1 > countEven*2){
                if (countOdd*2 - 1 > maxLen){
                    startInd = i - countOdd + 1;
                    endInd = i + countOdd;
                    maxLen = countOdd*2 - 1;
                }
            }
            else if (countEven*2 > maxLen){
                maxLen = countEven*2;
                startInd = i - countEven + 1;
                endInd = i + 1 + countEven;
            }
        }

        return s.equals("") ? "" : s.substring(startInd, endInd);
    }
    
    public int isPalindrome(char[] ch, int i, int j){
        int count = 0;
        while(i >= 0 && j < ch.length && ch[i] == ch[j]){
            i--;
            j++;
            count++;
        }
        
        return count;
    }
}
