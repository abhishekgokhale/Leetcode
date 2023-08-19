class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        
        char[] chars = s.toCharArray();
        int ans = 0, curr = 0;
        for(int i = 0; i < k; i++){
            if(vowels.contains(chars[i]))
                curr += 1;
            ans = Math.max(ans, curr);
        }
        int left = 0, right = k;
        while(right < chars.length){
            if(vowels.contains(chars[left]))
                curr -= 1;
            left += 1;
            if(vowels.contains(chars[right]))
                curr += 1;
            right += 1;
            ans = Math.max(ans, curr);
        }
        return ans;
    }
}