class Solution {
    public int trap(int[] height) {
        int [] leftMax = new int[height.length];
        int [] rightMax = new int[height.length];
        int [] min = new int[height.length];
        int [] canOccupy = new int[height.length];
        int leftMaxVal = height[0];
        int rightMaxVal = height[height.length-1];
        int res = 0;
        for(int i =0;i<height.length;i++){
            if(height[i]<=leftMaxVal){
                leftMax[i] = leftMaxVal;
            }
            else{
                leftMaxVal = height[i];
                leftMax[i] = leftMaxVal;
            }
        }
        for(int i =height.length-1;i>=0;i--){
            if(height[i]<=rightMaxVal){
                rightMax[i] = rightMaxVal;
            }
            else{
                rightMaxVal = height[i];
                rightMax[i] = rightMaxVal;
            }
        }
        for(int i =0;i<leftMax.length;i++){
                if(leftMax[i]<rightMax[i]){
                    min[i] = leftMax[i];
                }
                else{
                    min[i] = rightMax[i];
                }
        }
        for(int i =0;i<height.length;i++){
                canOccupy[i] = min[i]-height[i];
        }

        for(int i =0;i<canOccupy.length;i++){
            res+=canOccupy[i];
        }


        return res;
        
        
    }
}