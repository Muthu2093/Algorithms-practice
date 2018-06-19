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

class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1){
            return s;
        }
        boolean flag = true;
        String lonPalSS = s.substring(0,1);
        for (int i=1; i< s.length()-1; i++, flag = true){
            int p=i-1, q=i+1;
            while(p>=0 && q<s.length() && flag == true){
                if (s.charAt(p) == s.charAt(q)){
                    if (s.substring(p,q+1).length() > lonPalSS.length()){
                        lonPalSS = s.substring(p,q+1);
                    }
                }
                else{
                    flag = false;
                }
                p-=1;
                q+=1;
            }
        }
        for (int i=1; i< s.length(); i++, flag = true){
            int p=i-1, q=i;
            while(p>=0 && q<s.length() && flag == true){
                if (s.charAt(p) == s.charAt(q)){
                    if (s.substring(p,q+1).length() > lonPalSS.length()){
                        lonPalSS = s.substring(p,q+1);
                    }
                }
                else{
                    flag = false;
                }
                p-=1;
                q+=1;
            }
        }
        return lonPalSS;
    }
}
