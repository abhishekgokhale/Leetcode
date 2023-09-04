class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrack(new StringBuilder(), 0, 0, n);
        return ans;
    }
    
    public void backtrack(StringBuilder curr, int left, int right, int n){
        if(curr.length() == n*2){
            ans.add(curr.toString());
            return;
        }
        
        if(left < n){
            curr.append('(');
            backtrack(curr, left + 1, right, n);
            curr.deleteCharAt(curr.length() - 1);
        }
        if(left > right){
            curr.append(')');
            backtrack(curr, left, right + 1, n);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}