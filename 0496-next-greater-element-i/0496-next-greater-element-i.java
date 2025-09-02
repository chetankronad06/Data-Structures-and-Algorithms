class Solution {
    // public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    //     // int[] res = new int[nums1.length];
        
    //     // for(int i = 0; i < nums1.length; i++) {
    //     //     int index = -1;
    //     //     for(int j = 0; j < nums2.length; j++) {
    //     //         if(nums2[j] == nums1[i]) {
    //     //             index = j;
    //     //             break;
    //     //         }
    //     //     }
    //     //     int nextGreater = -1;
    //     //     for(int k = index + 1; k < nums2.length; k++) {
    //     //         if(nums2[k] > nums2[index]) {
    //     //             nextGreater = nums2[k];
    //     //             break;
    //     //         }
    //     //     }
            
    //     //     res[i] = nextGreater;
    //     // }
        
    //     // return res;

        
    // }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums1.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        int idx =0;
        for(int j=nums2.length-1;j>=0;j--){
            while(!stack.isEmpty() && stack.peek() <= nums2[j]){
                stack.pop();
            }
            if(stack.empty()){
                map.put(nums2[j],-1);
            }
            else{
                map.put(nums2[j],stack.peek());
            }
            stack.push(nums2[j]);
        }

        for(int i =0;i<nums1.length;i++){
            if(map.containsKey(nums1[i])){
                res[idx++]=map.get(nums1[i]);
            }
        }
        return res;
        

    }

}
