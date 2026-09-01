class Solution {
    public int numberOfSubstrings(String s) {
        int count = 0;
        int[] hash = new int[3];
        Arrays.fill(hash,-1);
        for(int i=0;i<s.length();i++){
            hash[s.charAt(i)-'a'] = i;
            int minIndex = Math.min(Math.min(hash[0],hash[1]),hash[2]);
            count = count + (minIndex+1);
        }

        return count;
        
    }
}