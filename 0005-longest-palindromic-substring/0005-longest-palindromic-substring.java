class Solution {
    public String longestPalindrome(String s) {
        int ansStart = 0, ansEnd = 0;
        for(int i = 0; i < s.length() - 1; i++){
            for(int end: new int[]{i, i + 1}){
                int start = i;
                if(s.charAt(start) == s.charAt(end)){
                    while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
                        start--;
                        end++;
                    }
                    start++;
                    end--;
                    // System.out.println("start = " + start + ", end = " + end);
                    if(ansEnd - ansStart + 1 < end - start + 1){
                        ansStart = start;
                        ansEnd = end;
                    }
                }
            }
        }
        return s.substring(ansStart, ansEnd + 1);
    }
}