class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return root;
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
}
// O(N), O(N)
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            int size = que.size();
            while(size -- != 0){
                TreeNode cur = que.poll();
                TreeNode temp = cur.left;
                cur.left = cur.right;
                cur.right = temp;
                if(cur.left != null) que.offer(cur.left);
                if(cur.right != null) que.offer(cur.right);
            }
        }
        return root;
    }
}

//O(N), O(N)
