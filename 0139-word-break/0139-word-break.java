class Solution {
    HashMap<String, Boolean> memo = new HashMap<>();
    List<String> wordDict;
    
    public boolean wordBreak(String s, List<String> wordDict) {
        this.wordDict = wordDict;
        
        for(String word: wordDict)
            memo.put(word, true);
        return recurse(s);
    }
    
    private boolean recurse(String s){
        if(s == null)
            return true;
        if(memo.containsKey(s))
            return memo.get(s);
        
        boolean ans = false;
        for(String word: wordDict){
            if(s.startsWith(word))
                ans |= recurse(s.substring(word.length()));
        }
        memo.put(s, ans);
        return ans;
    }
}