class Solution {
    List<Integer> res = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        dfs(root);
        return res;
    }

    private void dfs(Node node) {
        if (node == null) return;
        res.add(node.val);                
        for (Node child : node.children) { 
            dfs(child);
        }
    }
}
