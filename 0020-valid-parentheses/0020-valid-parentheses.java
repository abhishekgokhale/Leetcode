class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> maps = new HashMap<>();
        maps.put(')', '(');
        maps.put(']', '[');
        maps.put('}', '{');
        
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(char c: chars){
            if(c == '(' || c == '[' || c == '{')
                stack.add(c);
            else{
                if(stack.isEmpty()) return false;
                if(maps.get(c) != stack.pop()) return false;
            }
        }
        return stack.isEmpty();
    }
}