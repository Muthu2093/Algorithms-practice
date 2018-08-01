/** Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * Note: Do not use any built-in library function such as sqrt.
 * Example 1:
 * Input: 16
 * Returns: True
 * Example 2:
 * Input: 14
 * Returns: False
 * Credits:
 * Special thanks to @elmirap for adding this problem and creating all test cases.
 */
 
class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1){
            return true;
        }
        int l=1;
        int r = num;
        while (l<r){
            int m = l + (r-l)/2;
            if (m == num/m && num%m==0){
                return true;
            }
            else if (num/m < m){
                r = m-1;
            }
            else{
                l=m+1;
            }
        }
        return l == num / l && num % l == 0;
    }
}
