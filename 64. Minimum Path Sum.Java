class Solution {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] path_matrix = new int[m][n];
        path_matrix[0][0] = grid[0][0];
        for (int i=1; i<n; i++){
            path_matrix[0][i] = path_matrix[0][i-1] + grid[0][i];
        }
        for (int i=1; i<m; i++){
            path_matrix[i][0] = path_matrix[i-1][0] + grid[i][0];
        }
        for (int i=1; i<m; i++){
            for (int j=1; j<n; j++){
                path_matrix[i][j] = Math.min(path_matrix[i-1][j], path_matrix[i][j-1]) + grid[i][j];
            }
        }
        return path_matrix[m-1][n-1];
    }
}
