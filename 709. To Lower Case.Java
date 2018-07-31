/**Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
 * Example 1:
 * Input: "Hello"
 * Output: "hello"
 * Example 2:
 * Input: "here"
 * Output: "here"
 * Example 3:
 * Input: "LOVELY"
 * Output: "lovely"
 */
 
class Solution {
    public String toLowerCase(String str) {
        String low = "";
        for (int i=0; i<str.length(); i++){
            int c = str.charAt(i);
            if (c >= 'A' && c <= 96){
                c = c + 32;
            }
            low = low + (char) c;
        }
        return low;
    }
}
