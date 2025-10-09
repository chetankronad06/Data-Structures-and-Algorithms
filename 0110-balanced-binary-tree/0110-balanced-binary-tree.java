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
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int temp=0;
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        temp = leftDepth-rightDepth;
        if (Math.abs(leftDepth - rightDepth) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
         
        
    }

    public int getDepth(TreeNode root){
        if(root == null) return 0;
        int leftHeight = getDepth(root.left);
        int rightHeight = getDepth(root.right);
        return Math.max(leftHeight,rightHeight) + 1;
    }
}