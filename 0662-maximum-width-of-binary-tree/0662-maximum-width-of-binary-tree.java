/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 class Pair{
    TreeNode node;
    int idx;
    public Pair(TreeNode node,int idx){
        this.node = node;
        this.idx = idx;
    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<Pair> queue = new LinkedList<>();
        int max_width = 0;
        queue.offer(new Pair(root,0));
        while(!queue.isEmpty()){
            int size = queue.size();
            int min = queue.peek().idx;
            int first = 0, last = 0;
            for(int i=0;i<size;i++){
                int curr_idx = queue.peek().idx - min;
                TreeNode node = queue.peek().node;
                queue.poll();
                if(i==0) first = curr_idx;
                if(i==size-1) last = curr_idx;
                if(node.left!=null){
                    queue.offer(new Pair(node.left,curr_idx*2));
                }
                if(node.right!=null){
                    queue.offer(new Pair(node.right,curr_idx*2+1));
                }
            }
            max_width = Math.max(max_width,last-first+1);

        }

        return max_width;
        
    }
}