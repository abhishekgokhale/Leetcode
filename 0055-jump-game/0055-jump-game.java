class Solution {
    Map<Integer, Boolean> memo = new HashMap<>();
    int[] nums;
    
    public boolean canJump(int[] nums) {
        this.nums = nums;
        return recurse(0);
    }
    private boolean recurse(int i){
        if(i == nums.length - 1)
            return true;
        if(i >= nums.length)
            return false;
        if(memo.containsKey(i))
            return memo.get(i);
        
        boolean ans = false;
        for(int jump = 1; jump <= Math.min(nums[i], nums.length - 1); jump++)
            if(recurse(i + jump)){
                ans = true;
                break;
            }
        
        memo.put(i, ans);
        return ans;
    }
}