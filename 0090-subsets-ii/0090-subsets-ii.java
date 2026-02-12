class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		helper(0,nums,ans,list);
		return ans;
	}
	public static void helper(int index, int[] arr,List<List<Integer>> ans, List<Integer> list){
		ans.add(new ArrayList<>(list));
        for(int i=index; i<arr.length;i++){
            if(i>index && arr[i]== arr[i-1]) continue;
            list.add(arr[i]);
		    helper(i+1,arr,ans,list);
		    list.remove(list.size()-1);
        }
	}
}