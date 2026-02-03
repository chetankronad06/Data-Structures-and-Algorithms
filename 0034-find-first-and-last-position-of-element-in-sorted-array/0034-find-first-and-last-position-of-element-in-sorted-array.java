class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = -1;
        int last = -1;
        int count =0;
        for(int i =0;i<nums.length;i++){
            if(nums[i]==target){
                count++;
                if(first ==-1){
                    first = i;
                }
                else{
                    last=i;
                }
                
            }
            
        }
        if(count==1){
            return new int[]{first, first};
        }
        return new int[]{first,last};
    }
}