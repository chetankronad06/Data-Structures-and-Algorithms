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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        TreeNode root = buildTreeHelper(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
        return root;
    }

    public TreeNode buildTreeHelper(int[] preorder,int ps,int pe,int[] inorder,int is,int ie, HashMap<Integer,Integer> map){
        if(ps>pe || is>ie) return null;
        TreeNode root = new TreeNode(preorder[ps]);
        int idx = map.get(root.val);
        int numsLeft = idx-is;
        root.left = buildTreeHelper(preorder,ps+1,ps+numsLeft,inorder,is,idx-1,map);
        root.right = buildTreeHelper(preorder,ps+numsLeft+1,pe,inorder,idx+1,ie,map);
        return root;
    }
}