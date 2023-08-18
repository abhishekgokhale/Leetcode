class Solution {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Set<Integer> seen = new HashSet<>();
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        for(int i = 0; i< rooms.size(); i++)
            graph.put(i, rooms.get(i));
            
        seen.add(0);
        dfs(0);
        // System.out.println(seen);
        // System.out.println(graph.entrySet());
        return seen.size() == rooms.size();
    }
    public void dfs(int node){
        for(int nei: graph.get(node)){
            if(!seen.contains(nei)){
                seen.add(nei);
                dfs(nei);
            }
        }
    }
    
}