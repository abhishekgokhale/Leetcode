class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        StringBuilder ans = new StringBuilder();
        for(char c: chars){
            if(c == '*')
                stack.pop();
            else
                stack.add(c);
        }
        while(!stack.empty())
            ans.append(stack.pop());
        return ans.reverse().toString();
    }
}