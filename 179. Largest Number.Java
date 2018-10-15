/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * Example 1:
 * Input: [10,2]
 * Output: "210"
 * Example 2:
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
 
class Solution {
    
    List<Integer> list;
    
    public String largestNumber(int[] nums) {
        String result = "";
        
        String[] num = new String[nums.length];
        for (int i=0; i<nums.length; i++){
            num[i] = String.valueOf(nums[i]);
        }
        
        Comparator c1 = new Comparator<String>(){
            @Override
            public int compare(String i, String j){
                String a = i+j;
                String b = j+i;
                
                return b.compareTo(a);
            }
        };
        
        Arrays.sort(num, c1);
        
        for (int i=0; i<num.length; i++){
            result = result + num[i];
        }
        while(result.length() > 1 && result.charAt(0) == '0'){
            result = result.substring(1, result.length());
        }
        
        return result;
    }
}
