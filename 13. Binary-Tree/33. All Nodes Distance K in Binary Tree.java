class Solution {
    Map<TreeNode, List<TreeNode>> graph = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        buildGraph(root, null);
        List<Integer> result = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        visited.add(target);

        while (!queue.isEmpty()) {
            if (k==0) {
                for (TreeNode node : queue) result.add(node.val);
                return result;
            }
            int size = queue.size();
            while (size-->0) {
                TreeNode node = queue.poll();
                for (TreeNode neighbor : graph.get(node)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
            --k;
        }

        return result;
    }

    private void buildGraph(TreeNode node, TreeNode parent) {
        if (node == null) return;
        graph.putIfAbsent(node, new ArrayList<>());
        if (parent != null) {
            graph.get(node).add(parent);
            graph.get(parent).add(node);
        }
        buildGraph(node.left, node);
        buildGraph(node.right, node);
    }
}
