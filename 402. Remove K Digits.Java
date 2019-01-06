/**
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 * Example 1:
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * Example 2:
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 * Example 3:
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 */
 
class Solution {
    public String removeKdigits(String num, int k) {
        char[] ch = num.toCharArray();
        Deque<Character> dq = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        
        for (i=0; i<ch.length; i++){
            if (k == 0){
                while (i < ch.length){
                    dq.offerLast(ch[i++]);
                }
                break;
            }
            
            while(k > 0 && !dq.isEmpty() && dq.peekLast() > ch[i]){
                dq.pollLast();
                k--;
            }
            dq.offerLast(ch[i]);
        }
        
        while (k > 0){
            dq.pollLast();
            k--;
        }
        
        while (!dq.isEmpty()){
            char c = dq.pollFirst();
            if (!(sb.length() == 0 && c == '0')){
                sb.append(c);
            }
        }
        
        return sb.length() == 0 ? new String("0") : sb.toString();
    }
}
