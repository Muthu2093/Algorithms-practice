/**
 * Given two binary strings, return their sum (also a binary string).

 * The input strings are both non-empty and contains only characters 1 or 0.

 * Example 1:

 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:

 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
 
// Approach 1 - high time complexity //
class Solution {
    public String addBinary(String a, String b) {
        boolean carry = false;
        int alen = a.length()-1, blen = b.length()-1;
        String output = "";
        
        while(alen>=0 || blen >= 0){
            char aChar = ' ', bChar= ' ';
            if (alen >=0 && blen >=0){
                aChar = a.charAt(alen);
                bChar = b.charAt(blen);
            }
            else if (alen <0){
                System.out.println("here0");
                aChar = '0';
                bChar = b.charAt(blen);
            }
            else if (blen <0){
                System.out.println("here1");
                aChar = a.charAt(alen);
                bChar = '0';
            }
            
            if (aChar == '0' && bChar == '0'){
                if (carry){
                    output = '1' + output;
                    carry = false;
                }
                else{
                    output = '0' + output;
                }
            }
            else if (aChar == '0' && bChar == '1'){
                if (carry){
                    output = '0' + output;
                    carry = true;
                }
                else{
                    output = '1' + output;
                }
            }
            else if (aChar == '1' && bChar == '0'){
                if (carry){
                    output = '0' + output;
                    carry = true;
                }
                else{
                    output = '1' + output;
                }
            }
            else if (aChar == '1' && bChar == '1'){
                if (carry){
                    output = '1' + output;
                    carry = true;
                }
                else{
                    output = '0' + output;
                    carry = true;
                }
            }
            alen--;
            blen--;
        }
        
        if (carry){
            output = '1' + output;
        }
        return output;
    }
}

// Approach 2 - low time - without using Stringbuilder //

class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        int alen = a.length()-1, blen = b.length()-1;
        String output = "";
        
        while(alen>=0 || blen >= 0){
            int sum = 0;
            if (alen >= 0){
                sum += a.charAt(alen) - '0';
            }
            if (blen >= 0) {
                 sum += b.charAt(blen) - '0';
            } 
            sum += carry;
            carry = sum/2;
            sum %=2;
            output = (char) (sum + '0') + output;
            alen--;
            blen--;
        }
        if (carry == 1){
            output = '1' + output;
        }
        
        return output;
    }
}
