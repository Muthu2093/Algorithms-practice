class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0){
            return result;
        }
        
        Map<Character, List<Character>> map = new HashMap<>();
        map.put('2', Arrays.asList('a','b','c'));
        map.put('3', Arrays.asList('d','e','f'));
        map.put('4', Arrays.asList('g','h','i'));
        map.put('5', Arrays.asList('j','k','l'));
        map.put('6', Arrays.asList('m','n','o'));
        map.put('7', Arrays.asList('p','q','r','s'));
        map.put('8', Arrays.asList('t','u','v'));
        map.put('9', Arrays.asList('w','x','y','z'));
        
        recursive(digits.toCharArray(), new String(), result, 0, map);
        
        return result;
    }
    
    public void recursive(char[] c, String str, List<String> result, int index, Map<Character, List<Character>> map){
        if (index == c.length-1){
            for (Character ch: map.get(c[index])){
                result.add(str + ch);
            }
            return;
        }
        
        for(Character ch:map.get(c[index])){
            recursive(c, str + ch, result, index+1, map);
        }
    }
}
