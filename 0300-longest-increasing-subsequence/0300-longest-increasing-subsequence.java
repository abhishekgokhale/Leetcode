class Solution {
    HashMap<Integer, Integer> memo = new HashMap<>();
    public int lengthOfLIS(int[] nums) {
        int ans = 1;
        for(int i = 0; i < nums.length; i++){
            ans = Math.max(ans, recurse(i, nums));
        }
        return ans;
    }
    
    private int recurse(int i, int[] nums){
        if(i >= nums.length)
            return 0;
        if(memo.containsKey(i))
            return memo.get(i);
        
        // memo.put(i, 1);
        int ans = 1;
        for(int j = i + 1; j < nums.length; j++){
            if(nums[j] > nums[i]){
                ans = Math.max(ans, 1 + recurse(j, nums));
            }
        }
        memo.put(i, ans);
        return ans;
    }
}