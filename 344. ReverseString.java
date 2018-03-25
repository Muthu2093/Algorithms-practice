class Solution {
    ## Without using string builder - 475 / 476 test cases passed.
    public String reverseString(String s) {
        String St="";
        for (int i=s.length()-1;i>=0;i--){
            if (i==s.length()-1){
                St=Character.toString(s.charAt(i));
                continue;
            }
            St=St+s.charAt(i);
            // System.out.print("\n" + St);
        }
        return St;
    }
    
    ## Using StringBuilder - All test cases passed
    public String reverseStringStringBuilder(String s) {
        StringBuilder St= new StringBuilder(s);
        return St.reverse().toString();
    }
}
