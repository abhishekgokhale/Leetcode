class Solution {
    List<List<Integer>> triangle;
    HashMap<String, Integer> memo = new HashMap<>();
    
    public int minimumTotal(List<List<Integer>> triangle) {
        this.triangle = triangle;
        // this.memo = new int[][];
        int i = triangle.size() - 1;
        List<Integer> lastRow = triangle.get(i);
        for(int j = 0; j < lastRow.size(); j++){
            String key = i + "," + j;
            memo.put(key, lastRow.get(j));
        }
        return recurse(0, 0);
    }
    
    private int recurse(int i, int j){
        if(i >= triangle.size() || j >= triangle.get(i).size())
            return 0;
        String key = i + "," + j;
        if(memo.containsKey(key))
            return memo.get(key);
        
        int ans = Math.min(triangle.get(i).get(j) + recurse(i+1, j), triangle.get(i).get(j) + recurse(i+1, j+1));
        memo.put(key, ans);
        return ans;
    }
}