class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> remove = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        char[] chars = s.toCharArray();
        
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == '(')
                stack.add(i);
            else if(chars[i] == ')'){
                if(stack.isEmpty())
                    remove.add(i);
                else
                    stack.pop();
            }
        }
        while(!stack.isEmpty())
            remove.add(stack.pop());
        
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < chars.length; i++){
            if(!remove.contains(i))
                ans.append(chars[i]);
        }
        return ans.toString();
    }
}