class Solution {
    HashMap<String, Integer> memo = new HashMap<>();
    String[] dictionary;
    
    public int minExtraChar(String s, String[] dictionary) {
        this.dictionary = dictionary;
        for(String str: dictionary){
            if(s.equals(str))
                return 0;
            memo.put(str, 0);
        }
        return recurse(s);
    }
    
    private int recurse(String s){
        if(s.equals(""))
            return 0;
        if(memo.containsKey(s))
            return memo.get(s);
        
        int ans = 1 + recurse(s.substring(1));
        boolean flag = false;
        for(String str: dictionary){
            if(s.startsWith(str)){
                ans = Math.min(ans, recurse(s.substring(str.length())));
                flag = true;
            }
        }
        // if(!flag)
        //     ans = 1 + recurse(s.substring(1));
        
        memo.put(s, ans);
        return ans;
    }
}

// meaencgpgvsckjrqafkxgyzbe