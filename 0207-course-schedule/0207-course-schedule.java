class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        int[] inDegrees = new int[numCourses];
        for(int i = 0; i < numCourses; i++)
            graph.put(i, new ArrayList<Integer>());
        for(int[] prereq: prerequisites){
            graph.get(prereq[1]).add(prereq[0]);
            inDegrees[prereq[0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        for(int i = 0; i < numCourses; i++)
            if(inDegrees[i] == 0){
                queue.add(i);
                seen.add(i);
            }
        
        while(!queue.isEmpty()){
            int node = queue.remove();
            ArrayList<Integer> neis = graph.get(node);
            for(int i = 0; i < neis.size(); i++){
                if(!seen.contains(neis.get(i))){
                    inDegrees[neis.get(i)]--;
                    if(inDegrees[neis.get(i)] == 0){
                        queue.add(neis.get(i));
                        seen.add(neis.get(i));
                    }
                }
            }
        }
        return seen.size() == numCourses;
    }
}