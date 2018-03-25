class Solution {
    public boolean rotateString(String A, String B) {
        if (A.length()!=B.length()){
            return false;
        }
        int i,j, indicator;
        for (j=0;j<B.length();j++){
            if (A.charAt(0)==B.charAt(j)){
                break;
            }
        }
        indicator=j;
        for (i=0; i<A.length();i++,j++){
            if(j==A.length()){
                j=0;
            }
            //print(A.charAt(i));
            //print(B.charAt(j));
            if(A.charAt(i)!=B.charAt(j)){
                for (int a=indicator;a<B.length();a++){
                    if (A.charAt(0)==B.charAt(a)){
                        i=0;
                        j=a;
                        indicator=a;
                        break;
                    }
                }
                if (i!=0){
                    return false;
                }
            }
        }    
        return true;
    }
}
