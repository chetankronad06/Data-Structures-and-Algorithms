class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > temp.get(temp.size() - 1)) {
                temp.add(nums[i]);
            }
            else {
                int ind = lowerBound(temp, nums[i]);
                temp.set(ind, nums[i]);
            }
        }
        return temp.size();
    }

    public int lowerBound(ArrayList<Integer> temp, int target) {
        int low = 0;
        int high = temp.size() - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(temp.get(mid) >= target) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }
}