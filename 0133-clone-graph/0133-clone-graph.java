/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Integer, Node> nodes = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        if(node == null)
            return node;
        Queue<Node> queue = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        
        nodes.put(node.val, new Node(node.val));
        queue.add(node);
        seen.add(node.val);
        
        while(!queue.isEmpty()){
            Node curr = queue.remove();
            Node newNode = nodes.get(curr.val);
            seen.add(curr.val);
            for(Node nei: curr.neighbors){
                if(!seen.contains(nei.val)){
                    if(!nodes.containsKey(nei.val)){
                        nodes.put(nei.val, new Node(nei.val));
                    }
                    Node newNei = nodes.get(nei.val);
                    newNode.neighbors.add(newNei);
                    newNei.neighbors.add(newNode);
                    queue.add(nei);
                }
            }
            // System.out.println(queue);
        }
        // System.out.println(nodes.entrySet());
        return nodes.get(1);
    }
}