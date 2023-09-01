class Solution {
    HashMap<Pair<Integer, Integer>, Integer> memo = new HashMap<>();
    int[][] grid;
    
    public int minPathSum(int[][] grid) {
        this.grid = grid;
        int m = grid.length - 1;
        int n = grid[0].length - 1;
        memo.put(new Pair(0, 0), grid[0][0]);
        int ans = recurse(m, n);
        // System.out.println(memo.entrySet());
        return ans;
    }
    
    private int recurse(int i, int j){
        if(i < 0 || j < 0)
            return Integer.MAX_VALUE;
        
        Pair key = new Pair(i, j);
        if(memo.containsKey(key))
            return memo.get(key);
        
        int ans = grid[i][j] + Math.min(recurse(i-1, j), recurse(i, j-1));
        memo.put(key, ans);
        return ans;
    }
}