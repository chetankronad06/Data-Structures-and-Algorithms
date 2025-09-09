class Solution {
    public void solve(List<List<Integer>> res , List<Integer> temp, int i ,int[] nums ){
        if(i>= nums.length){
            List<Integer> copy = new ArrayList<>();
            for(int num: temp){
                copy.add(num);
            }
            res.add(copy);
            return;
        }

        //exclude
        solve(res,temp,i+1,nums);

        //include
        temp.add(nums[i]);
        solve(res,temp,i+1,nums);
        temp.remove(temp.size()-1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        solve(res,temp,0,nums);
        return res;
    }
}