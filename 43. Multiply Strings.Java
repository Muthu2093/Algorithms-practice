/**
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 * Example 1:
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * Example 2:
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 * Note:
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contain only digits 0-9.
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
 
class Solution {
    public String multiply(String num1, String num2) {
        if ((num1.length() == 1 && num1.charAt(0) == '0') || (num2.length() == 1 && num2.charAt(0) == '0')){
            return "0";
        }
        int j = num2.length()-1;
        int i = num1.length()-1;
        int[] sum = new int[i+j+2];
        int sum1=0, sum2=0;
        while (j>=0){
            i = num1.length()-1;
            while(i>=0){
                sum2 = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                sum2 += sum[i+j+1];
                sum[i+j+1] = sum2%10;
                sum[i+j] += sum2/10;
                i--;
            }
            j--;
        }
        String ans = "";
        for (i=0;i<sum.length;i++){
            ans = ans + (char) (sum[i] + '0');
        }
        if (ans.charAt(0) == '0'){
            return ans.substring(1,ans.length());
        }
        return ans;
    }
}
