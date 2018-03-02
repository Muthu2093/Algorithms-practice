class Solution {
    public int lengthOfLongestSubstring(String s) {
        String ch = "";
        int temp = 0;
        if (s.length()==1){
            return 1;
        }
        for (int i = 0;i < s.length();i++){
            if (ch == ""){
                ch = ch + s.charAt(i);
                continue;
            }
            for (int j=0;j < ch.length(); j++){
                if (s.charAt(i) == ch.charAt(j)){
                    if (temp == 0){
                        temp = ch.length();
                    }
                    else if (temp <= ch.length()){
                        temp = ch.length();
                    }
                    i=j;
                    ch = "";
                    break;
                }
            }
            if (ch != ""){
                ch = ch +s.charAt(i);
            }
            if (i==s.length()-1){
                if (temp <= ch.length()){
                    temp = ch.length();
                }
            }
        }
        System.out.println(temp);
        return temp;
    }
}