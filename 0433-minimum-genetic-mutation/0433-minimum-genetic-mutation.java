class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<String> queue = new LinkedList<>();
        HashSet<String> seen = new HashSet<>();
        
        queue.add(startGene);
        seen.add(startGene);
        int steps = 0;
        while(!queue.isEmpty()){
            int levelLen = queue.size();
            for(int ind = 0; ind < levelLen; ind++){
                String node = queue.remove();
                if(node.equals(endGene))
                    return steps;
                for(int i = 0; i < node.length(); i++){
                    for(char c: new char[]{'A', 'G', 'C', 'T'}){
                        String newNode = node.substring(0, i) + c + node.substring(i + 1);
                        if(!seen.contains(newNode) && Arrays.asList(bank).contains(newNode)){
                            seen.add(newNode);
                            queue.add(newNode);
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}