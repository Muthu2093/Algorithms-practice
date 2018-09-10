/**
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital if it has more than one letter, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 * Example 1:
 * Input: "USA"
 * Output: True
 * Example 2:
 * Input: "FlaG"
 * Output: False
 * Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 */
 
class Solution {
    public boolean detectCapitalUse(String word) {
        int len = word.length();
        boolean firstCap = false, allSmall = false;
        for (int i=0; i<len; i++){
            boolean temp = word.charAt(i) > 96 && word.charAt(i) < 123;
            if (!(firstCap || allSmall) || (i == 1 && firstCap)){
                if (temp){
                    allSmall = true;
                    firstCap = false;
                }
                else{
                    firstCap = true;
                }
            }
            else if (firstCap){
                if (temp){
                    return false;
                }
            }
            else{
                if (!temp){
                    return false;
                }
            }
        }
        return true;
    }
}
