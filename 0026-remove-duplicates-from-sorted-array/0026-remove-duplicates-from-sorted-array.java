class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0; // points to last unique element
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) { 
                i++;               // move unique pointer
                nums[i] = nums[j]; // place unique element
            }
        }
        return i + 1; // length = index + 1
    }
}
