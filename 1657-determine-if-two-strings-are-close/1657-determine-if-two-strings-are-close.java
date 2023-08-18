class Solution {
    public boolean closeStrings(String word1, String word2) {
        Map<Character, Integer> counts1 = new HashMap<>();
        Map<Character, Integer> counts2 = new HashMap<>();
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        
        for(char c: chars1){
            counts1.put(c, counts1.getOrDefault(c, 0) + 1);
        }
        for(char c: chars2){
            counts2.put(c, counts2.getOrDefault(c, 0) + 1);
        }
        List<Integer> vals1 = new ArrayList<>(counts1.values());
        List<Integer> vals2 = new ArrayList<>(counts2.values());
        Collections.sort(vals1);
        Collections.sort(vals2);
        if(!(counts1.keySet().equals(counts2.keySet()) && vals1.equals(vals2)))
            return false;
        return true;
    }
}