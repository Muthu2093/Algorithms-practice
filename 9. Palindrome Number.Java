/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * Example 1:
 * Input: 121
 * Output: true
 * Example 2:
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 */

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        int y = x, a, b;
        int length = 0;
        while (y !=0){
            y = y/10;
            length++;
        }
        //System.out.println(length);
        while (x != 0){
            a = x /((int) (Math.pow(10, length - 1)));
            b = x%10;
            if (a != b){
                return false;
            }
            
            x = x %((int) (Math.pow(10, length -1)));
            x = x/10;
            length = length - 2;
            
        }
        return true;
    }
}
