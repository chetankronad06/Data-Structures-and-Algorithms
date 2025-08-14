class Solution {
    public int reverse(int x) {
        int  str =0;
        while (x != 0) {
            int rem = x % 10;
            if(str<Integer.MIN_VALUE/10 || str > Integer.MAX_VALUE/10){
            return 0;
        }
            x = x / 10;
            str = str * 10 + rem;
        }
        return str;
        
    }
}