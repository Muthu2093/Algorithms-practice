class Solution {
    public int divide(int dividend, int divisor) {
        int i=0;
        if (dividend <0 && divisor>0){
            while(dividend<0){
                dividend=dividend+divisor;
            i=i+1;
            }
            return -i;
        }
        if (dividend >0 && divisor<0){
            while(dividend>0){
                dividend=dividend+divisor;
            i=i+1;
            }
            return -i;
        }
        
        while(dividend>=divisor){
            dividend=dividend-divisor;
            i=i+1;
        }
        return i;
        
    }
}