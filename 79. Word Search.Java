/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * Example:
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */
 
class Solution {
    public boolean exist(char[][] board, String word) {
        char[] ch = word.toCharArray();
        boolean[][] flag = new boolean[board.length][board[0].length];
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                flag[i][j] = true;
                if (ch[0] == board[i][j] && (dfs(board, ch, i+1, j, 1, flag) || 
                                         dfs(board, ch, i-1, j, 1, flag) || 
                                         dfs(board, ch, i, j+1, 1, flag) || 
                                         dfs(board, ch, i, j-1, 1, flag))){
                    return true;
                }
                flag[i][j] = false;
            }
        }
        
        return false;
    }
    
    public boolean dfs(char[][] board, char[] word, int i, int j, int ind, boolean[][] flag){
        if (ind == word.length){
            return true;
        }
        
        if (i >= board.length || j >= board[0].length || i < 0 || j < 0 || flag[i][j]){
            return false;
        }
        
        // System.out.println(i +":" + j);
        if (board[i][j] == word[ind]){
            flag[i][j] = true;
            if(dfs(board, word, i+1, j, ind+1, flag) || (dfs(board, word, i, j+1, ind+1, flag)) || dfs(board, word, i-1, j, ind+1, flag) || dfs(board, word, i, j-1, ind+1, flag)){
                return true;
            }
            flag[i][j] = false;
        }
        
        return false;
    }
}

