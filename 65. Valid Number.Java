/**
 * Validate if a given string is numeric.

 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true

 * Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.

 * Update (2015-02-10):
 * The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button to reset your code definition.
 */
 
class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0){
            return false;
        }
        boolean dot = false, exp = false, num = false;
        int i = 0, len = s.length()-1;
        if (s.charAt(i) == '+' || s.charAt(i) == '-' ){
            s=s.substring(1,len+1);
            len = len-1;
        }
        for (i=0; i<=len; i++){
            if (s.charAt(i) == '.'){
                if (dot || len == 0 || exp ){
                    return false;
                }
                dot = true;
            }
            else if (s.charAt(i) == 'e'){
                if (i != len && (s.charAt(i+1) == '+' || s.charAt(i+1) == '-')){
                    i += 1;
                }
                if (exp || i == len || i == 0 || !num){
                    return false;
                }
                exp = true;
            }
            else if(Character.isDigit(s.charAt(i))){
                num = true;
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
