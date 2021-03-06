/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 * Example 1:
 * Input: 
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * Output: 
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * Example 2:
 * Input: 
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * Output: 
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 * Follow up:
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 */
 
class Solution {
    public void setZeroes(int[][] matrix) {
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[0].length; j++){
                if (matrix[i][j] == 0){
                    for (int k=0; k<matrix[0].length; k++){
                        matrix[i][k] = matrix[i][k] == 0 ? 0 : Integer.MIN_VALUE+100;
                    }            
                    break;
                }
            }
        }
        for (int j=0; j<matrix[0].length; j++){
            for (int i=0; i<matrix.length; i++){
                if (matrix[i][j] == 0){
                    for (int k=0; k<matrix.length; k++){
                        matrix[k][j] = matrix[k][j] == 0 ? 0 : Integer.MIN_VALUE+100;
                    }         
                    break;
                }
            }
        }
        
        
        for (int i=0;i<matrix.length; i++){
            for (int j=0; j<matrix[0].length; j++){
                matrix[i][j] = matrix[i][j] == Integer.MIN_VALUE+100 ? 0 : matrix[i][j]; 
            }
        }
        
    }
}
