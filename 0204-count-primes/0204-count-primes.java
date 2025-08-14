class Solution {
public int countPrimes(int n) {
        int count=0;
        Boolean[] arr = new Boolean[n+1];
        Arrays.fill(arr,true);
        for(int i = 2; i< n; i++) {
            if(arr[i]) {
                count++;
                for(int j = 2*i; j < n; j += i) {
                    arr[j] = false;
                }
            }
        }
        return count;
    }
}

