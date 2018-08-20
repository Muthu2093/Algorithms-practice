/**
 * Given two strings representing two complex numbers.
 * You need to return a string representing their multiplication. Note i2 = -1 according to the definition.
 * Example 1:
 * Input: "1+1i", "1+1i"
 * Output: "0+2i"
 * Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
 * Example 2:
 * Input: "1+-1i", "1+-1i"
 * Output: "0+-2i"
 * Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
 * Note:
 * The input strings will not have extra blank.
 * The input strings will be given in the form of a+bi, where the integer a and b will both belong to the range of [-100, 100]. And the output should be also in this form.
 */
 
class Solution {
    public String complexNumberMultiply(String a, String b) {
        int[] nums = new int[4];
        int alen = a.length();
        int blen = b.length();
        for (int i=1; i<5; i++){
            if (a.charAt(i) == '+'){
                nums[0] = Integer.parseInt(a.substring(0,i));
                nums[1] = Integer.parseInt(a.substring(i+1,alen-1));
                break;
            }
        }
        for (int i=1; i<5; i++){
            if (b.charAt(i) == '+'){
                nums[2] = Integer.parseInt(b.substring(0,i));
                nums[3] = Integer.parseInt(b.substring(i+1,blen-1));
                break;
            }
        }
        //System.out.println(nums[0] + ":" + nums[1] + ":" + nums[2] + ":" + nums[3]);
        int sum[] = new int[2];
        sum[0] = nums[0]*nums[2] - (nums[1]*nums[3]);
        sum[1] = nums[0]*nums[3] + nums[1]*nums[2];
        String res = Integer.toString(sum[0]) + "+" + Integer.toString(sum[1]) + "i";
        return res;
    }
}
