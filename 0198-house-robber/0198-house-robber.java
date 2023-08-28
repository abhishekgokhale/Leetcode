class Solution {
    int[] memo;
    int[] nums;
    
    public int rob(int[] nums) {
        this.nums = nums;
        this.memo = new int[nums.length];
        for(int i = 0; i < nums.length; i++)
            memo[i] = -1;
        return recurse(0);
    }
    
    private int recurse(int i){
        if(i >= nums.length)
            return 0;
        if(memo[i] != -1)
            return memo[i];
        
        memo[i] = Math.max(nums[i] + recurse(i+2), recurse(i+1));
        return memo[i];
    }
}