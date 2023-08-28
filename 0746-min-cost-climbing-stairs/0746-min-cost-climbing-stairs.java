class Solution {
    int[] cost;
    int[] memo;
    public int minCostClimbingStairs(int[] cost) {
        this.cost = cost;
        this.memo = new int[cost.length];
        for(int i = 0; i < cost.length; i++)
            memo[i] = -1;
        return Math.min(recurse(0), recurse(1));
    }
    
    private int recurse(int i){
        if(i >= cost.length)
            return 0;
        
        if(memo[i] != -1)
            return memo[i];
        
        memo[i] = Math.min(cost[i] + recurse(i+1), cost[i] + recurse(i+2));
        return memo[i];
    }
}