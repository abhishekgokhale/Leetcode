class Solution {
    HashMap<Integer, Integer> memo = new HashMap<>();
    int[] coins;
    
    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        for(int coin: coins)
            memo.put(coin, 1);
        return recurse(amount);
    }
    
    private int recurse(int amount){
        if(amount < 0)
            return -1;
        if(amount == 0)
            return 0;
        
        if(memo.containsKey(amount))
            return memo.get(amount);
        
        int ans = Integer.MAX_VALUE;
        for(int coin: coins){
            if(amount >= coin){
                int res = recurse(amount - coin);
                if(res >= 0)
                    ans = Math.min(ans, 1 + res);
            }
        }
        if(ans == Integer.MAX_VALUE){
            memo.put(amount, -1);
            return -1;
        }
        memo.put(amount, ans);
        return ans;
    }
}