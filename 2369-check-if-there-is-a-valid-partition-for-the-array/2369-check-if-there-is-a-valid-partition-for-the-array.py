class Solution:
    def validPartition(self, nums: List[int]) -> bool:
        memo = {-1: True}
        def rec(i):
            if i in memo:
                return memo[i]
            
            ans = False
            if i > 0 and nums[i] == nums[i-1]:
                ans = ans or rec(i - 2)
            if i > 1 and nums[i] == nums[i-1] == nums[i-2]:
                ans = ans or rec(i - 3)
            if i > 1 and nums[i] == nums[i-1] + 1 == nums[i-2] + 2:
                ans = ans or rec(i - 3)
            memo[i] = ans
            return ans
        return rec(len(nums) - 1)