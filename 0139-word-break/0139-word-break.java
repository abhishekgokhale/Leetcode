class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String, Boolean> memo = new HashMap<>();
        for(String word: wordDict)
            memo.put(word, true);
        
        return recurse(s, wordDict, memo);
    }
    
    private boolean recurse(String subs, List<String> wordDict, HashMap<String, Boolean> memo){
        if(subs.equals("") || subs == null)
            return false;
        if(memo.containsKey(subs))
            return memo.get(subs);
        
        boolean ans = false;
        for(String word: wordDict){
            if(subs.startsWith(word)){
                ans = ans || recurse(subs.substring(word.length()), wordDict, memo);
            }
        }
        memo.put(subs, ans);
        return memo.get(subs);
    }
}