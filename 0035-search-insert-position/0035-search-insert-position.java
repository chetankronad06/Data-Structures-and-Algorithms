class Solution {
    public int searchInsert(int[] nums, int target) {
        int i=0;
        while(i<nums.length){
            if(nums[i]>=target){
                return i;
            }
            else{
                i++;
            }
        }
        if(i==nums.length){
            return nums.length;
        }else{
            return 0;
        }
    }
}
