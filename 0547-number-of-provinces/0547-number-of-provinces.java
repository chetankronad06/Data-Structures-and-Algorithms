class Solution {
    public int findCircleNum(int[][] isConnected) {
        int nodes = isConnected.length;
        boolean[] visited = new boolean[nodes];
        int components = 0;
        for (int i = 0; i < nodes; i++) {
            if (!visited[i]) {
                components++;
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                visited[i] = true;
                while (!q.isEmpty()) {
                    int node = q.poll();
                    for (int j=0;j<nodes;j++) {
                        if(isConnected[node][j]==1 && !visited[j]){
                            visited[j] = true;
                            q.offer(j);
                        }
                    }
                }
            }
        }
        return components;
        
    }
}