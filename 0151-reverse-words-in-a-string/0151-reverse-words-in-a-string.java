class Solution {
    public String reverseWords(String s) {
        s = s.strip();
        String[] splits = s.split(" ");
        StringBuilder ans = new StringBuilder();
        for(int i = splits.length - 1; i >=0; i--){
            if(!splits[i].equals("")) {
                ans.append(splits[i]);
                if(i > 0)
                    ans.append(" ");
            }
        }
        return ans.toString();
    }
}