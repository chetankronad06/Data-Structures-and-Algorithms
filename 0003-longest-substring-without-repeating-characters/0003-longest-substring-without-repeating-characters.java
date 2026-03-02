class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] hash = new int[256];
        Arrays.fill(hash, -1);

        int l = 0, maxLen = 0;

        for (int r = 0; r < n; r++) {
            int c = s.charAt(r);
            if (hash[c] >= l) {
                l = hash[c] + 1;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            hash[c] = r;
        }
        return maxLen;
    }
}