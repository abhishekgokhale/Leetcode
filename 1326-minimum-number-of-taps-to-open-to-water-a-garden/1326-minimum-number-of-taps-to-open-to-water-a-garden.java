class Solution {
    public int minTaps(int n, int[] ranges) {
        
        int[] maxReach = new int[n+1];
        
        for(int i = 0; i < ranges.length; i++){
            int start = Math.max(0, i - ranges[i]);
            int end = Math.min(n, i + ranges[i]);
            maxReach[start] = Math.max(maxReach[start], end);
        }
        int ans = 0;
        int curr = 0;
        int next = 0;
        for(int i = 0; i <= n; i++){
            if(i > next)
                return -1;
            
            if(i > curr){
                ans++;
                curr = next;
            }
            next = Math.max(next, maxReach[i]);
        }
        return ans;
    }
}