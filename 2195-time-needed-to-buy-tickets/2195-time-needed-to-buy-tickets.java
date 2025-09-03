import java.util.*;

class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int res = 0;
        Queue<Integer> q = new ArrayDeque<>();

        // add all people to queue
        for (int i = 0; i < tickets.length; i++) {
            q.offer(i);
        }
        while (tickets[k] > 0) {
            int i = q.poll();       
            tickets[i]--;           
            res++;                  

            if (tickets[i] > 0) {   
                q.offer(i);
            }
            if (i == k && tickets[k] == 0) {
                return res;
            }
        }

        return res;
    }
}
