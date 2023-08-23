class State {
    int val;
    char c;
    State(int val, char c) {
        this.val = val;
        this.c = c;
    }
}

class Solution {
    public String reorganizeString(String s) {
        StringBuilder ans = new StringBuilder();
        Map<Character, Integer> counts = new HashMap<>();
        char[] chars = s.toCharArray();
        for(char c: chars){
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        int maxCount = Collections.max(counts.values());
        if(maxCount - 1 > s.length() - maxCount)
            return "";
        
        PriorityQueue<State> heap = new PriorityQueue<>((n1, n2) -> n2.val - n1.val);
        for(char key: counts.keySet()){
            heap.add(new State(counts.get(key), key));
        }
        State popped_2 = null;
        while(heap.size() > 0){
            State popped = heap.remove();
            ans.append(popped.c);
            if(heap.size() > 0)
                popped_2 = heap.remove();
            
            if(popped.val - 1 > 0){
                popped.val -= 1;
                heap.add(popped);
            }
            
            if(popped_2 != null){
                ans.append(popped_2.c);
                if(popped_2.val - 1 > 0){
                    popped_2.val -= 1;
                    heap.add(popped_2);
                }
            }
            popped_2 = null;
        }
        
        return ans.toString();
    }
}