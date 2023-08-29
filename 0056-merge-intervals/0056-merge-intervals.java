class Solution {
    public int[][] merge(int[][] intervals) {
        // Collections.sort(intervals, (a, b) -> a[0] - b[0]);
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        ArrayList<int[]> ans = new ArrayList<>();
        
        for(int i = 0; i < intervals.length; i++){
            if(ans.isEmpty() || ans.get(ans.size() - 1)[1] < intervals[i][0])
                ans.add(intervals[i]);
            else{
                int[] last = ans.get(ans.size() - 1);
                if(last[1] >= intervals[i][0]){
                    last[1] = Math.max(last[1], intervals[i][1]);
                    ans.remove(ans.size() - 1);
                    ans.add(last);
                }
            }
        }
        int[][] res = new int[ans.size()][2];
        for(int i = 0; i < ans.size(); i++){
            res[i] = ans.get(i);
        }
        return res;
    }
}