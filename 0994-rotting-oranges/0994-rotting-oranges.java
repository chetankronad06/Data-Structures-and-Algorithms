class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q=new ArrayDeque<>();
        int r=grid.length;
        int c=grid[0].length;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==2) q.add(new Pair(i,j));
            }
        }
        if(r==1 && q.isEmpty()){
            for(int j=0;j<c;j++){
                if(grid[0][j]==1) return -1;
            }
            return 0;
        }
        int time=-1;

        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Pair curr=q.poll();
                int x=curr.i;
                int y=curr.j;

                //up
                if(x-1>=0 && grid[x-1][y]==1){
                    q.add(new Pair(x-1,y));
                    grid[x-1][y]=2;
                }
                //down
                if(x+1<r && grid[x+1][y]==1){
                    q.add(new Pair(x+1,y));
                    grid[x+1][y]=2;
                }
                //right
                if(y+1<c && grid[x][y+1]==1){
                    q.add(new Pair(x,y+1));
                    grid[x][y+1]=2;
                }
                //left
                if(y-1>=0 && grid[x][y-1]==1){
                    q.add(new Pair(x,y-1));
                    grid[x][y-1]=2;
                }
            }
            time++;
        }

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==1) return -1;
            }
        }

        return time;
    }


}

class Pair{
    int i;
    int j;
    public Pair(int i,int j){
        this.i=i;
        this.j=j;
    }
}