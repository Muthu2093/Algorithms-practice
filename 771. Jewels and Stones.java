class Solution {
    public int numJewelsInStones(String J, String S) {
        StringBuilder St = new StringBuilder(S);
        int count=0;
        for (int i=0;i<J.length();i++){
            for (int j=0;j<St.length();j++){//check string interation condition
                if(J.charAt(i)==St.charAt(j)){
                    count = count+1;
                    St.deleteCharAt(j);
                    j=j-1;
                }
            }
        }
        return count;
    }
}
