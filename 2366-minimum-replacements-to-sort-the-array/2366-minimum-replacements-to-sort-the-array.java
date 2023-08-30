class Solution {
    public long minimumReplacement(int[] nums) {
        long answer = 0;
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] > nums[i+1]){
                long numEle = (long) (nums[i+1] + nums[i] - 1) / nums[i + 1];
                answer += numEle - 1;
                nums[i] = nums[i] / (int) numEle;
            }
        }
        return answer;
    }
}