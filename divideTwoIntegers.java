class Solution {
    public int divide(int dividend, int divisor) {
        int[] values = new int[2];
        values[0] = 0;   /// count
        values[1] = 0;  //// temp
        boolean flag = false, flag2=false;
        if (dividend < 0){
            if (dividend == Integer.MIN_VALUE){
                dividend = dividend + 1;
                if (divisor == 1){
                    flag2 = true;
                }
            }
            flag = !flag;
            dividend = -dividend;
        }
        if (divisor < 0){
            flag = !flag;
            divisor = -divisor;
        }
        
        while(dividend - values[1] >= 0){
            //System.out.println("\nIteration");
            dividend = dividend - values[1];
            values = recurse(dividend, divisor, values);
            //System.out.println("values[1]: "+values[1]);
            //System.out.println("values[0]: "+values[0]);
        }
        if (flag == true){
            values[0] = 2-values[0];
        }
        if (flag2 == true){
            return values[0]-2;
        }
        return values[0]-1;
    }
    
    public int[] recurse(int dividend, int divisor, int[] values){
        int temp = divisor;
        int count = 1;
        while(((temp+temp) <= dividend) && dividend > 0 && divisor > 0 && (temp+temp)>0){
            temp = temp + temp;
            if (count == 0){
                count = count+1;
                continue;
            }
            count = count + count;
        }
        values[1] = temp;
        values[0] = values[0] + count;
        //System.out.println("temp: " + temp);
        //System.out.println("count: " + count);
        return values;
    }
}
