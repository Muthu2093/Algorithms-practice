/**
 * On a N * N grid, we place some 1 * 1 * 1 cubes.
 * Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).
 * Return the total surface area of the resulting shapes. 
 * Example 1:
 * Input: [[2]]
 * Output: 10
 * Example 2:
 * Input: [[1,2],[3,4]]
 * Output: 34
 * Example 3:
 * Input: [[1,0],[0,2]]
 * Output: 16
 * Example 4:
 * Input: [[1,1,1],[1,0,1],[1,1,1]]
 * Output: 32
 * Example 5:
 * Input: [[2,2,2],[2,1,2],[2,2,2]]
 * Output: 46
 * Note:
 * 1 <= N <= 50
 * 0 <= grid[i][j] <= 50
 */
 
class Solution {
    public int surfaceArea(int[][] grid) {
        int N = grid.length;
        int SA = 0;
        for (int i=0; i<N; i++){
            SA += grid[0][i] + grid[i][0] + grid[i][N-1] + grid[N-1][i];
            if(grid[i][N-1] != 0){
                SA += 2;
            }
        }
        //System.out.println(SA);
        for (int i=0; i<N; i++){
            for(int j=0; j<N-1; j++){
                //System.out.println(grid[i][j] + "-" + grid[i][j+1]);
                //System.out.println(grid[j][i] + "-" + grid[j+1][i]);
                SA += Math.abs(grid[i][j] - grid[i][j+1]);
                SA += Math.abs(grid[j][i] - grid[j+1][i]);
                if (grid[i][j] != 0){
                    SA += 2;
                }
            }
        }
        return SA;
    }
}
