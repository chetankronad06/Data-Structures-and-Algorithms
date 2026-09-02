class Solution {
    public String minWindow(String s, String t) {
        int startIndex = 0;
        int minLength = Integer.MAX_VALUE;
        int count = 0;
        int[] hash = new int[256];
        Arrays.fill(hash, 0);
        for (int j = 0; j < t.length(); j++) {
            hash[t.charAt(j)]++;
        }
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            if (hash[s.charAt(right)] > 0)
                count++;
            hash[s.charAt(right)]--;
            while (count == t.length()) {
                int length = right - left + 1;
                if (length < minLength) {
                    minLength = length;
                    startIndex = left;
                }
                hash[s.charAt(left)]++;
                if (hash[s.charAt(left)]>0)
                    count--;
                left++;
            }
            right++;
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(startIndex, startIndex + minLength);
    }
}