class Solution {
    public void solve(List<List<Integer>> res, List<Integer> temp, int[] nums, boolean[] used) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue; 
            
            temp.add(nums[i]);
            used[i] = true;
            
            solve(res, temp, nums, used);

            used[i] = false;
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        solve(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }
}
