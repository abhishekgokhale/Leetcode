class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        queue = collections.deque()
        ans = []
        for i in range(len(nums)):
            while queue and queue[-1][0] < nums[i]:
                queue.pop()
            queue.append((nums[i], i))
            while queue and queue[0][1] <= i - k:
                queue.popleft()
            if k-1 <= i < len(nums):
                ans.append(queue[0][0])
            # print("i = ", i, queue)
            
        return ans