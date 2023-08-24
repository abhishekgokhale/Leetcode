class Solution {
    public int longestOnes(int[] nums, int k) {
        int ans = 0;
        int left = 0, right = 0;
        
        while(right < nums.length){
            // while(k > 0){
            //     if(right < nums.length){
            //         if(nums[right] == 1)
            //             right++;
            //         else{
            //             k -= 1
            //         }
            //     }
            // }
            
            while(right < nums.length && (nums[right] == 1 || k > 0)){
                if(nums[right] == 0)
                    k--;
                right++;
                ans = Math.max(ans, right - left);
                // System.out.println(right + ", " + left);
            }
            while(right < nums.length && left <= right && nums[left] != 0)
                left += 1;
            left += 1;
            k++;
        }
        
        return ans;
    }
}