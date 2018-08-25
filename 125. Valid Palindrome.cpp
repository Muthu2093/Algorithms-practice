/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 * Example 1:
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * Example 2:
 * Input: "race a car"
 * Output: false
 */
 
class Solution {
public:
    bool isPalindrome(string s) {
        if (s.length() < 2){
            return true;
        }
        transform(s.begin(), s.end(), s.begin(), ::toupper);
        cout<<s<<endl;
        for (int i=0, j=s.length()-1; i<j; i++,j--){
            if(s[i] == ' ' || !isalnum(s[i])){
                j += 1;
                continue;
            }
            if(s[i] == ' ' || !isalnum(s[j])){
                i -= 1;
                continue;
            }
            if (s[i] != s[j]){
                //cout<<"i:" << i <<"j" << j<< endl;
                //cout<<s[i]<<s[j]<<endl;
                return false;
            }
        }
        return true;
    }
};
