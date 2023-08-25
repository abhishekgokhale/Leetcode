class Solution {
    public String intToRoman(int num) {
        StringBuilder ans = new StringBuilder();
        Map<Integer, String> maps = new HashMap<>();
        int[] numbers = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int i = 0;
        while(num > 0){
            if(num >= numbers[i]){
                ans.append(romans[i]);
                num -= numbers[i];
            }
            else
                i++;
        }
        
        return ans.toString();
    }
}