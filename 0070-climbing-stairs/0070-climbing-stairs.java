class Solution {
    int[] memo;
    int n;
    
    public int climbStairs(int n) {
        this.n = n;
        this.memo = new int[n+1];
        return recurse(0);
    }
    
    private int recurse(int i){
        if(i > n)
            return 0;
        if(i == n)
            return 1;
        if(memo[i] != 0)
            return memo[i];
        
        memo[i] = recurse(i+1) + recurse(i+2);
        return memo[i];
    }
}