/ **
  * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

  * Example 1:

  * Input: "babad"
  * Output: "bab"
  * Note: "aba" is also a valid answer.
  * Example 2:

  * Input: "cbbd"
  * Output: "bb"
*/

class Solution {
    
    public String longestPalindrome(String s) {
        int ind1 = 0, ind2=0;
        if (s.length()==1){
            System.out.println("1st place");
            return s;
        }
        if (s.length()==0){
            String a = "";
            System.out.println("2nd place");
            return a;
        }
        if (s.length()==2){
            if (isPalindrome(s)==true){
                return s;
            }
            else{
                String longestPalindrome = s.substring(0,1);
                return longestPalindrome;
            }
        }
        String longestPalindrome = s.substring(0,1);
        int max = 1;
        for (int i=1 ; i<s.length()-1;i++,ind1=0,ind2=0){
            for (int j=1; (i-j>=-1) && (i+j<s.length()); j++){
                System.out.println("i:"+i);
                System.out.println("j:"+j);
                if (i-j>=0){
                    if(isPalindrome(s.substring(i-j,i+j+1)) == false && ind1==0){
                        ind1 = 1;
                    }
                    else if((2*j + 1)>max && ind1==0){
                        longestPalindrome = s.substring(i-j,i+j+1);
                        System.out.println("i:"+i+" j:"+j+" substring:"+ s.substring(i-j,i+j+1));
                        max = longestPalindrome.length();
                    }
                }
                if (i+j < s.length() && ind2 == 0){
                    if(isPalindrome(s.substring(i-j+1,i+j+1)) == false){
                        ind2 =1;
                    }
                    else if((2*j)>max){
                        longestPalindrome = s.substring(i-j+1,i+j+1);
                        //System.out.println("i:"+i+" j:"+j+" substring:"+ longestPalindrome);
                        max = longestPalindrome.length();
                    }
                }
                if (i == 1 && j == 1){
                    if(isPalindrome(s.substring(i-j,i+j-1+1)) == true){
                        if((2*j)>max){
                            longestPalindrome = s.substring(i-j,i+j-1+1);
                            //System.out.println("i:"+i+" j:"+j+" substring:"+ longestPalindrome);
                            max = longestPalindrome.length();
                        }
                    }
                }
                
            }
        }
        return longestPalindrome;
    }
    
    public boolean isPalindrome(String str){
        for (int i=0,j=str.length()-1;i<str.length()/2;i++,j--){
            if(str.charAt(i)!=str.charAt(j)){
                System.out.println("False:");
                System.out.println(str);
                return false;
            }
        }
        return true;
    }
}
