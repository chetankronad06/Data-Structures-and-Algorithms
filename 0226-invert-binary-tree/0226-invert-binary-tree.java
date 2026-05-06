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
// class Solution {
//     public TreeNode invertTree(TreeNode root) {
//         if(root == null){
//             return root;
//         }
//         invertTree(root.left);
//         invertTree(root.right);
//         TreeNode curr = root.left;
//         root.left = root.right;
//         root.right = curr;
//         return root;
        
//     }
// }

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root; 
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i =0 ; i<size;i++){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
                TreeNode curr = node.left;
                node.left = node.right;
                node.right = curr;
            }
        }
        return root;
    }
}