/**
 * Given an array of strings, group anagrams together.
 * Example:
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * Note:
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */
 
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        String[] sorted = new String[strs.length];
        HashMap<String, List> hashMap= new HashMap<>();
        
        for (int i=0; i<strs.length; i++){
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            sorted[i] = new String(charArray);
            if (hashMap.get(sorted[i]) == null){
                hashMap.put(sorted[i], new ArrayList<String>());
            }
            hashMap.get(sorted[i]).add(strs[i]);
        }
        
        for (List<String> list: hashMap.values()){
            res.add(list);
        }
        
        return res;        
    }
}
