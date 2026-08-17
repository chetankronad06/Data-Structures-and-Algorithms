class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int i = 0;
        int j = i+k-1;
        int count = 0;
        while(j<arr.length){
            int sum = 0;
            for(int z=i;z<=j;z++){
                sum+=arr[z];
            }
            if(sum / (j-i+1) >= threshold){
                count++;
            }
            i++;
            j++;
        }

        return count;

    }
}