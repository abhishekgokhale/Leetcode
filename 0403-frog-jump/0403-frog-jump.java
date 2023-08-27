class Solution {
    HashMap<String, Boolean> memo = new HashMap<>();
    int[] stones;
    
    public boolean canCross(int[] stones) {
        this.stones = stones;
        return recurse(0, 1);
    }
    
    private int findJumpIndex(int i, int stone){
        int low = i + 1, high = stones.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(stones[mid] < stone)
                low = mid + 1;
            else if(stones[mid] > stone)
                high = mid - 1;
            else
                return mid;
        }
        return -1;
    }
    
    private boolean recurse(int i, int k){
        if(i == stones.length - 1)
            return true;
        
        String key = Integer.toString(i) + Integer.toString(k);
        boolean ans = false;
        if(memo.containsKey(key))
            return memo.get(key);
        
        if(i == 0){
            if(stones[i+1] - 1 != stones[i]){
                // memo.put(key, false);
                return false;
            }
            ans = recurse(1, 1);
        }
        else {
            int[] jumps = {k-1, k, k+1};
            for(int jump: jumps){
                if(jump > 0){
                    int ind = findJumpIndex(i, stones[i] + jump);
                    if(ind != -1){
                        ans |= recurse(ind, jump);
                    }
                }
            }
        }
        memo.put(key, ans);
        return ans;
    }
}