// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int n = s.length();
//         int maxLength = 0;
//         int[] charIndex = new int[128];
//         Arrays.fill(charIndex, -1);
//         int left = 0;
        
//         for (int right = 0; right < n; right++) {
//             if (charIndex[s.charAt(right)] >= left) {
//                 left = charIndex[s.charAt(right)] + 1;
//             }
//             charIndex[s.charAt(right)] = right;
//             maxLength = Math.max(maxLength, right - left + 1);
//         }
        
//         return maxLength;
//     }
// }

// class Solution{
//     public int lengthOfLongestSubstring(String s) {
//         int[] hash = new int[256];
//         int maxLen = 0;
//         for(int i=0;i<s.length();i++){
//             for(int j=i;j<s.length();j++){
//                 if(hash[s.charAt(j)]==1) break;
//                 int len = j-i+1;
//                 maxLen = Math.max(maxLen,len);
//                 hash[s.charAt(j)]=1;
//             }
//         }
//         return maxLen;
//     }

// }


class Solution{
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int minLength = 0;
        int hash[] = new int[256];
        Arrays.fill(hash,-1);
        while(right < s.length()){
            if(hash[s.charAt(right)]!=-1 && hash[s.charAt(right)]>=left){
                left = hash[s.charAt(right)]+1;
            }
            minLength = Math.max(minLength,right-left+1);
            hash[s.charAt(right)]= right;
            right++;
        }
        return minLength;
    }
}