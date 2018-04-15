/ **
  * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
  * P   A   H   N
  * A P L S I I G
  * Y   I   R
  * And then read line by line: "PAHNAPLSIIGYIR"

  * Write the code that will take a string and make this conversion given a number of rows:
  * string convert(string text, int nRows);
  * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/

class Solution {
    public String convert(String s, int numRows) {
        if (s.length() <= numRows || numRows == 1){
            return s;
        }
        char[][] zigZag = new char[numRows][((int)(s.length()/2 + 1))];
        boolean cross = false;
        int row,col;
        int strlength = s.length();
        for (row=0, col=0; s.length()>0; s = s.substring(1,s.length())){
            if (cross == false){
                zigZag[row][col] = s.charAt(0);
                row = row + 1;
            }
            if (cross == true){
                row = row - 1;
                col = col + 1;
                zigZag[row][col] = s.charAt(0);
                
            }
            if (row == numRows){
                row = row - 1;
                cross = true;
            }
            if (row == 0){
                cross = false;
                row = 1;
            }      
        }
        for (row=0; row<numRows; row++){
            for (col=0; col<strlength/2 + 1; col++){
                if (zigZag[row][col] != '\0'){
                    s = s + zigZag[row][col];
                }
                
            }
        }
        return s;   
    }
}


