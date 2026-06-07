/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder string = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node == null){
                string.append("n ");
                continue;
            }
            string.append(node.val+" ");
            queue.offer(node.left);
            queue.offer(node.right);

        }

        return string.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "") return null;
        Queue<TreeNode> queue = new LinkedList<>();
        String[] values = data.split(" ");
        if(values[0].equals("n"))return null;
        TreeNode treeRoot = new TreeNode(Integer.parseInt(values[0]));
        queue.offer(treeRoot);
        for(int i=1;i<values.length;i++){
            TreeNode node = queue.poll();
            if(!values[i].equals("n")){
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                node.left = left;
                queue.offer(left);
            }
            if(!values[++i].equals("n")){
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                node.right = right;
                queue.offer(right);
            }
        }
        return treeRoot;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));