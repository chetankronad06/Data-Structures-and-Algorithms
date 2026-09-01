class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k - 1);
    }

    public int helper(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int sumCount = 0;
        int sum = 0;
        while (right < nums.length) {
            sum += (nums[right]%2) ;
            while (sum > k) {
                sum = sum - (nums[left]%2);
                left++;
            }
            sumCount += (right - left + 1);
            right++;
        }
        return sumCount;
    }
}