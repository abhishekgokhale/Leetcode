class Solution {
    public int equalPairs(int[][] grid) {
        Map<List<Integer>, Integer> counts = new HashMap<>();
        for(int i = 0; i < grid.length; i++){
            List<Integer> row = new ArrayList<Integer>();
            for(int j = 0; j < grid[i].length; j++)
                row.add(grid[i][j]);
            counts.put(row, counts.getOrDefault(row, 0) + 1);
        }
        int ans = 0;
        for(int i = 0; i < grid.length; i++){
            List<Integer> row = new ArrayList<Integer>();
            for(int j = 0; j < grid[i].length; j++)
                row.add(grid[j][i]);
            if(counts.containsKey(row))
                ans += counts.get(row);
        }
        
        return ans;
    }
}