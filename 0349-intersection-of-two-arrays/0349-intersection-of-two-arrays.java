class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> result = new HashSet<>();
        for(int i=0 ; i< nums1.length ; i++){
            for(int j=0; j < nums2.length ; j++){
                if(nums1[i] == nums2[j]){
                    result.add(nums1[i]);
                    break;
                }
            }
        }
        int[] output = new int[result.size()];
        int index = 0;
        for (int num : result) {
            output[index++] = num;
        }
        return output;
    
    }
        
}
