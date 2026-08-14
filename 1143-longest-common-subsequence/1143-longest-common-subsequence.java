class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int l = text1.length();
        int m = text2.length();
        int[][] dp = new int[l][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(l - 1, m - 1, text1, text2, dp);
    }

    public int helper(int index1, int index2, String text1, String text2, int[][] dp) {
        if (index1 < 0 || index2 < 0) {
            return 0;
        }
        if (dp[index1][index2] != -1) {
            return dp[index1][index2];
        }
        if (text1.charAt(index1) == text2.charAt(index2)) {
            return dp[index1][index2] = 1 + helper(index1 - 1, index2 - 1, text1, text2, dp);
        }
        return dp[index1][index2] = 0
                + Math.max(helper(index1, index2 - 1, text1, text2, dp), helper(index1 - 1, index2, text1, text2, dp));
    }

}