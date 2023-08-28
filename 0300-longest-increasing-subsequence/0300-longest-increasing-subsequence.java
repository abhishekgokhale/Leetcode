class Solution {
    HashMap<Integer, Integer> memo = new HashMap<>();
    int[] nums;
    
    public int lengthOfLIS(int[] nums) {
        this.nums = nums;
        int ans = 0;
        for(int i = 0; i < nums.length; i++)
            ans = Math.max(ans, recurse(i));
        return ans;
    }
    
    private int recurse(int i){
        if(i >= nums.length)
            return 0;
        if(memo.containsKey(i))
            return memo.get(i);
        
        int ans = 1;
        for(int j = i+1; j < nums.length; j++){
            if(nums[j] > nums[i])
                ans = Math.max(ans, 1 + recurse(j));
        }
        memo.put(i, ans);
        return ans;
    }
}