import java.util.*;
class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max_profit =0;
        int today_profit = 0;
        for(int i =0;i<prices.length;i++){
            today_profit = prices[i]-min;
            if(today_profit>max_profit){
                max_profit = today_profit;
            }
            if(min>prices[i]){
                min = prices[i];
            }
        }
        return max_profit;
        
    }
}