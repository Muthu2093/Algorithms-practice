/**
 * Implement int sqrt(int x).
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 * Example 1:
 * Input: 4
 * Output: 2
 * Example 2:
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since 
 *              the decimal part is truncated, 2 is returned.
 */
 
 
class Solution {
    public int mySqrt(int x) {
        if(x==0 || x==1) {
            return x;
        }
        return (int) recurse(x,1,(long) x/2+1);
    }
    public long recurse(int x, long l, long r){
        if (l<=r){
            long m = l + (r-l)/2;
            if (m*m == x){
                return m;
            }
            if (m*m > x){
                return recurse(x, l, m-1);
            }
            return recurse(x, m+1, r);
        }
        return l*l<x ? l: l-1;
    }
}
