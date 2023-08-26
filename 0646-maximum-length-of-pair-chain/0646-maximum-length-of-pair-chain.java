class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));
        HashMap<Integer, Integer> memo = new HashMap<>();
        int ans = 0;
        for(int i = 0; i < pairs.length; i++){
            ans = Math.max(ans, recurse(i, pairs, memo));
        }
        return ans;
    }
    
    private int recurse(int i, int[][] pairs, HashMap<Integer, Integer> memo){
        if(memo.containsKey(i))
            return memo.get(i);
        memo.put(i, 1);
        for(int j = i + 1; j < pairs.length; j++){
            if(pairs[i][1] < pairs[j][0])
                memo.put(i, Math.max(memo.get(i), 1 + recurse(j, pairs, memo)));
        }
        return memo.get(i);
    }
}