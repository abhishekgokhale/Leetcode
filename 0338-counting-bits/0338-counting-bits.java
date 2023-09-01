class Solution {
    public int[] countBits(int n) {
        if(n == 0)
            return new int[1];
        int[] dp = new int[n+1];
        dp[1] = 1;
        
        for(int i = 2; i <= n; i++)
            dp[i] = dp[i/2] + i % 2;
        
        return dp;
    }
}