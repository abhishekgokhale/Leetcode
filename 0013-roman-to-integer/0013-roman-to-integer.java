class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> maps = new HashMap<>();
        HashMap<Character, Character> subtractions = new HashMap<>();
        maps.put('I', 1);
        maps.put('V', 5);
        maps.put('X', 10);
        maps.put('L', 50);
        maps.put('C', 100);
        maps.put('D', 500);
        maps.put('M', 1000);
        subtractions.put('V', 'I');
        subtractions.put('X', 'I');
        subtractions.put('L', 'X');
        subtractions.put('C', 'X');
        subtractions.put('D', 'C');
        subtractions.put('M', 'C');
        
        char[] chars = s.toCharArray();
        int i = 0;
        int ans = 0;
        while(i < chars.length){
            ans += maps.get(chars[i]);
            if(i > 0)
                if(subtractions.containsKey(chars[i]) && chars[i-1] == subtractions.get(chars[i]))
                    ans += -2*maps.get(chars[i-1]);
            i++;
        }
        return ans;
    }
}