class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        for(int j=heights.length-1;j>=0;j--){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[j]){
                stack.pop();
            }
            if(stack.empty()){
                // map.put(nums2[j],-1);
                right[j] = heights.length;
            }
            else{
                // map.put(nums2[j],stack.peek());
                right[j] = stack.peek();
            }
            stack.push(j);
        }
        while(!stack.empty()){
            stack.pop();
        }
        for(int j=0;j<heights.length;j++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[j]){
                stack.pop();
            }
            if(stack.empty()){
                // map.put(nums2[j],-1);
                left[j] = -1;
            }
            else{
                // map.put(nums2[j],stack.peek());
                left[j] = stack.peek();
            }
            stack.push(j);
        }

        int res = 0;
        for(int i=0;i<heights.length;i++){
            int width = right[i]-left[i]-1;
            int cuurArea = heights[i] * width;
            res = Math.max(res,cuurArea);
        }
        return res;
    }
}