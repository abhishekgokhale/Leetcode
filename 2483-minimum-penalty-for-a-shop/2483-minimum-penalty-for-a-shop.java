class Solution {
    public int bestClosingTime(String customers) {
        int ys = 0;
        char[] chars = customers.toCharArray();
        for(int i = 0; i< chars.length; i++)
            if(chars[i] == 'Y')
                ys += 1;
        
        int ans = 0, minPenalty = ys, nsSeen = 0, penalty;
        for(int i = 0; i <= chars.length; i++){
            penalty = ys + nsSeen;
            if(penalty < minPenalty){
                ans = i;
                minPenalty = penalty;
            }
            if(i < chars.length){
                if(chars[i] == 'Y')
                    ys -= 1;
                else
                    nsSeen += 1;
            }
        }
        return ans;
    }
}