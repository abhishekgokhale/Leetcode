class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] i: flights)
            graph.computeIfAbsent(i[0], value -> new ArrayList<>()).add(new int[] {i[1], i[2]});
        
        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        heap.add(new int[]{0, src, 0});
        
        while(!heap.isEmpty()){
            int[] curr = heap.remove();
            int node = curr[1];
            
            if(curr[2] > stops[node] || curr[2] > k + 1)
                continue;
            
            stops[node] = curr[2];
            if(node == dst)
                return curr[0];
            
            if(!graph.containsKey(node))
                continue;
            for(int[] a: graph.get(node))
                heap.add(new int[] {curr[0] + a[1], a[0], curr[2] + 1});
            
        }
        return -1;
    }
}