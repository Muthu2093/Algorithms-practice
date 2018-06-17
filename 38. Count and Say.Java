 /** The count-and-say sequence is the sequence of integers with the first five terms as following:

 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth term of the count-and-say sequence.

 * Note: Each term of the sequence of integers will be represented as a string.
 * Example 1:
 * Input: 1
 * Output: "1"
 
 * Example 2:
 * Input: 4
 * Output: "1211"
 */


class Solution {
    public String countAndSay(int n) {
        String value = "1";
        if (n == 1){
            return value;
        }
        for (int i=2; i<=n;i++){
            String temp = value;
            value = "";
            int count = 0;
            for (int j=0;j<temp.length();j++){
                char val = temp.charAt(j);
                if (j==0){
                    count +=1;
                    value = Integer.toString(count) + val;
                    continue;
                }
                if (val == value.charAt(value.length()-1)){
                    count += 1;
                    value = value.substring(0,value.length()-2) + Integer.toString(count) + val;
                }
                else{
                    count = 1;
                    value = value + Integer.toString(count) + val;
                }
            }
        }
        return value;
    }
}
