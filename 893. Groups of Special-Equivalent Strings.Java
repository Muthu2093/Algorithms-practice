/**
 * You are given an array A of strings.
 * Two strings S and T are special-equivalent if after any number of moves, S == T.
 * A move consists of choosing two indices i and j with i % 2 == j % 2, and swapping S[i] with S[j].
 * Now, a group of special-equivalent strings from A is a non-empty subset S of A such that any string not in S is not special-equivalent with any string in S.
 * Return the number of groups of special-equivalent strings from A.
 * Example 1:
 * Input: ["a","b","c","a","c","c"]
 * Output: 3
 * Explanation: 3 groups ["a","a"], ["b"], ["c","c","c"]
 * Example 2:
 * Input: ["aa","bb","ab","ba"]
 * Output: 4
 * Explanation: 4 groups ["aa"], ["bb"], ["ab"], ["ba"]
 * Example 3:
 * Input: ["abc","acb","bac","bca","cab","cba"]
 * Output: 3
 * Explanation: 3 groups ["abc","cba"], ["acb","bca"], ["bac","cab"]
 * Example 4:
 * Input: ["abcd","cdab","adcb","cbad"]
 * Output: 1
 * Explanation: 1 group ["abcd","cdab","adcb","cbad"]
 * Note:
 * 1 <= A.length <= 1000
 * 1 <= A[i].length <= 20
 * All A[i] have the same length.
 * All A[i] consist of only lowercase letters.
 */
 
class Solution {
    public int numSpecialEquivGroups(String[] A) {
        boolean flag = true;
        int totElems = A.length;
        int group = totElems;
        boolean[] visited = new boolean[totElems];
        int len = A[0].length();
        if(totElems < 2){
            return 1;
        }
        for(int i=0; i<totElems; i++){
            for (int j=i+1; j<totElems; j++){
                if (visited[i]){
                    continue;
                }
                char[] ch1 = new char[20];
                char[] ch2 = new char[20];
                int x=0;
                for (int idx=1; idx<len; idx+=2){
                    ch1[x] = A[i].charAt(idx);
                    ch2[x] = A[j].charAt(idx);
                    x++;
                }
                Arrays.sort(ch1);
                Arrays.sort(ch2);
                String s1 = new String(ch1);
                String s2 = new String(ch2);
                if (!s1.equals(s2)){
                    flag = false;
                }
                for (int idx=0; idx<len; idx+=2){
                    ch1[x] = A[i].charAt(idx);
                    ch2[x] = A[j].charAt(idx);
                    x++;
                }
                Arrays.sort(ch1);
                Arrays.sort(ch2);
                s1 = new String(ch1);
                s2 = new String(ch2);
                //System.out.println(flag);
                //System.out.println(A[i]+ ":" + s1);
                //System.out.println(A[j]+ ":" + s2);
                if (flag && s1.equals(s2)){
                    group -= 1;
                    visited[j] = true;
                }
                flag = true;
            }
        }
        return group;
    }
}
