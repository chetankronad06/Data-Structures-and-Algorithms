class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(0,target,candidates,ans,list);
        return ans;
    }

    public void helper(int index , int target, int[] candidates, List<List<Integer>> ans,List<Integer> list ) {
        if(target==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] > target) break;
            list.add(candidates[i]);
            helper(i + 1, target - candidates[i], candidates, ans, list);
            list.remove(list.size() - 1);
        }

    }
}