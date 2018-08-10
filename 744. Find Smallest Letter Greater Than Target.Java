/** 
 * Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, find the smallest element in the list that is larger than the given target.
 * Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.
 * Examples:
 * Input:
 * letters = ["c", "f", "j"]
 * target = "a"
 * Output: "c"
 * Input:
 * letters = ["c", "f", "j"]
 * target = "c"
 * Output: "f"
 * Input:
 * letters = ["c", "f", "j"]
 * target = "d"
 * Output: "f"
 * Input:
 * letters = ["c", "f", "j"]
 * target = "g"
 * Output: "j"
 * Input:
 * letters = ["c", "f", "j"]
 * target = "j"
 * Output: "c"
 * Input:
 * letters = ["c", "f", "j"]
 * target = "k"
 * Output: "c"
 * Note:
 * letters has a length in range [2, 10000].
 * letters consists of lowercase letters, and contains at least 2 unique letters.
 * target is a lowercase letter.
 */
 
 class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int l=0, r = letters.length-1;
        if ((int) target<(int) letters[0] || (int) target>=(int) letters[r]){
            return letters[0];
        }
        int ch = nextGreatLetRec(letters, (int) target, l, r-1);
        return letters[ch];
    }
    public int nextGreatLetRec(char[] letters, int target, int l, int r){
        if (l<=r){
            int m = (l+r)/2;
            if ((int) letters[m] <= target  && (int) letters[m+1] > target){
                return m+1;
            }
            if ((int) letters[m] > target){
                return nextGreatLetRec(letters, target, l, m-1);
            }
            return nextGreatLetRec(letters, target, m+1, r);
        }
        return 0;
    }
}
 
