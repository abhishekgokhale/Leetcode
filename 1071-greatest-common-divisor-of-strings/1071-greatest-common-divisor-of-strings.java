class Solution {
    public int gcd(int len1, int len2) {
        if(len2 == 0)
            return len1;
        return gcd(len2, len1 % len2);
    }
    public String gcdOfStrings(String str1, String str2) {
        String test1 = (new StringBuilder(str1)).append(new StringBuilder(str2)).toString();
        String test2 = (new StringBuilder(str2)).append(new StringBuilder(str1)).toString();
        if(!test1.equals(test2))
            return "";
        int gcdLens = this.gcd(str1.length(), str2.length());
        // System.out.println(gcdLens);
        return str1.substring(0, gcdLens);
    }
}