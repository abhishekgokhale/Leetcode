class Node{
    String symbol;
    double value;
    
    Node(String symbol, double value){
        this.symbol = symbol;
        this.value = value;
    }
}

class Solution {
    HashMap<String, ArrayList<Node>> graph = new HashMap<>();
    HashSet<String> symbols = new HashSet<>();
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        for(int i = 0; i < equations.size(); i++){
            List<String> currEq = equations.get(i);
            if(!graph.containsKey(currEq.get(0)))
                graph.put(currEq.get(0), new ArrayList<>());
            graph.get(currEq.get(0)).add(new Node(currEq.get(1), values[i]));
            
            if(!graph.containsKey(currEq.get(1)))
                graph.put(currEq.get(1), new ArrayList<>());
            graph.get(currEq.get(1)).add(new Node(currEq.get(0), (1/values[i])));
            
            if(!symbols.contains(currEq.get(0)))
                symbols.add(currEq.get(0));
            if(!symbols.contains(currEq.get(1)))
                symbols.add(currEq.get(1));
        }
        // System.out.println(graph.entrySet());
        double[] ans = new double[queries.size()];
        
        for(int i = 0; i < queries.size(); i++){
            if(!symbols.contains(queries.get(i).get(0)) || !symbols.contains(queries.get(i).get(1)))
                ans[i] = -1.0;
            else
                ans[i] = bfs(queries.get(i));
        }
        
        return ans;
    }
    
    class State{
        String key;
        double ans;
        State(String key, double ans){
            this.key = key;
            this.ans = ans;
        }
    }
    
    private double bfs(List<String> query){
        
        String src = query.get(0), des = query.get(1);
        HashSet<String> seen = new HashSet<>();
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(src, 1.0));
        seen.add(src);
        
        while(!queue.isEmpty()){
            State state = queue.remove();
            if(state.key.equals(des))
                return state.ans;
            for(Node nei: graph.get(state.key)){
                if(!seen.contains(nei.symbol)){
                    seen.add(nei.symbol);
                    queue.add(new State(nei.symbol, state.ans*nei.value));
                }
            }
        }
        return -1.0;
        
    }
    
}