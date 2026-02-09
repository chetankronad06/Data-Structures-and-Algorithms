class Solution {
    static final long MOD = 1_000_000_007L;

    private long modPow(long base, long exp) {
        long res = 1;
        base %= MOD;

        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }

    public int countGoodNumbers(long n) {
        long evenCount = (n + 1) / 2;  
        long oddCount  = n / 2;        
        long ans = (modPow(5, evenCount) * modPow(4, oddCount)) % MOD;
        return (int) ans;
    }
}
