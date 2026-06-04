class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Queue<TreeNode> q = new LinkedList<>();
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        q.offer(root);
        parent.put(root, null);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.left != null) {
                parent.put(node.left, node);
                q.offer(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                q.offer(node.right);
            }
        }
        nodesAtKDistance(target, k, parent);
        return result;
    }
    public void nodesAtKDistance(
            TreeNode target,
            int k,
            HashMap<TreeNode, TreeNode> parent) {
        Queue<TreeNode> q = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        q.offer(target);
        visited.add(target);
        int dist = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            if (dist == k) {
                while (!q.isEmpty()) {
                    result.add(q.poll().val);
                }
                return;
            }
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (parent.get(node) != null &&
                    !visited.contains(parent.get(node))) {
                    visited.add(parent.get(node));
                    q.offer(parent.get(node));
                }
                if (node.left != null &&
                    !visited.contains(node.left)) {
                    visited.add(node.left);
                    q.offer(node.left);
                }
                if (node.right != null &&
                    !visited.contains(node.right)) {

                    visited.add(node.right);
                    q.offer(node.right);
                }
            }

            dist++;
        }
    }
}