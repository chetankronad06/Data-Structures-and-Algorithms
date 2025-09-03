class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack  = new Stack<>();
        int[] res = new int[nums.length];
        for(int j=2*nums.length-1;j>=0;j--){
            while(!stack.isEmpty() && stack.peek() <= nums[j%nums.length]){
                stack.pop();
            }
            if(stack.empty()){
                res[j%nums.length] = -1;
            }
            else{
                res[j%nums.length]=stack.peek();
            }
            stack.push(nums[j%nums.length]);
        }
        return res;
    }
}