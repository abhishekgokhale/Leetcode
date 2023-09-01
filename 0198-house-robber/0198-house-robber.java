class Solution {
    public int rob(int[] nums) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        return recurse(0, nums, memo);
    }
    
    private int recurse(int i, int[] nums, HashMap<Integer, Integer> memo){
        if(i >= nums.length) return 0;
        
        if(memo.containsKey(i)) return memo.get(i);
        
        int ans = Math.max(nums[i] + recurse(i+2, nums, memo), recurse(i+1, nums, memo));
        memo.put(i, ans);
        return ans;
    }
}