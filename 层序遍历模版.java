class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) return result;
        else levelHelper(root, 1);
        return result;
    }
    private void levelHelper(TreeNode root, int depth){
        if(depth > result.size()){
            result.add(new ArrayList<>());
        }
        result.get(depth - 1).add(root.val);
        if(root.left != null) levelHelper(root.left, depth + 1);
        if(root.right != null) levelHelper(root.right, depth + 1);
    }
}

//recursion O(N), O(N)

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = que.size();
            while(size != 0){
                TreeNode cur = que.poll();
                level.add(cur.val);
                if(cur.left != null) que.offer(cur.left);
                if(cur.right != null) que.offer(cur.right);
                size --;
            }
            result.add(level);
        }
        return result;
    }
}

//Iterative O(N), O(N)
