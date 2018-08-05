/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Given two integers x and y, calculate the Hamming distance.
 * Note:
 * 0 ≤ x, y < 231.
 * Example:
 * Input: x = 1, y = 4
 * Output: 2
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * The above arrows point to positions where the corresponding bits are different.
 */
 
class Solution {
    public int hammingDistance(int x, int y) {
        String X = Integer.toBinaryString(x);
        String Y = Integer.toBinaryString(y);
        int len1 = X.length(), len2 = Y.length();
        int dist=0;
        int i,j;
        for (i=len1-1, j=len2-1; i>=0 && j>=0; i--, j--){
            if(X.charAt(i) != Y.charAt(j)){
                dist += 1;
            }
            
        }
        while (i>=0){
            if(X.charAt(i) == '1'){
                dist+=1;
            }
            i -= 1;
        }
        while (j>=0){
            if(Y.charAt(j) == '1'){
                dist+=1;
            }
            j -= 1;
        }
        return dist;
    }
}
