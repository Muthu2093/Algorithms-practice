/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * Example:
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
 
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        if (numRows == 0){
            return result;
        }
        temp.add(1);
        result.add(temp);
        if (numRows == 1){
            return result;
        } 
        
        for (int i=1; i<numRows; i++){
            List<Integer> prev_list = result.get(i-1);
            temp = new ArrayList<Integer>();
            for (int j=0; j<prev_list.size()+1; j++){
                if (j==0){
                    temp.add(1);
                }
                else if (j == prev_list.size()){
                    temp.add(1);
                }
                else{
                    temp.add(prev_list.get(j-1) + prev_list.get(j));
                }
            }
            result.add(temp);
        }
        return result;
    }
}
