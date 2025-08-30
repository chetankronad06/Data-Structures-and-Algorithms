class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[26];   
        int[] window = new int[26]; 
        int len1 = s1.length(), len2 = s2.length();

        if (len1 > len2) return false;
        for (char c : s1.toCharArray()) {
            freq[c - 'a']++;
        }
        for (int i = 0; i < len1; i++) {
            window[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(freq, window)) return true;
        for (int i = len1; i < len2; i++) {
            window[s2.charAt(i) - 'a']++;
            window[s2.charAt(i - len1) - 'a']--;
            if (Arrays.equals(freq, window)) return true;
        }

        return false;
    }
}
