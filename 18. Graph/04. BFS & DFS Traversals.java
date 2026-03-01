// 1. Breadth-First Search (BFS)
// Best for: Finding the shortest path in an unweighted graph.
public void bfs(int startNode, List<List<Integer>> adj) {
    boolean[] visited = new boolean[adj.size()];
    Queue<Integer> queue = new LinkedList<>();

    visited[startNode] = true;
    queue.add(startNode);

    System.out.print("BFS Traversal: ");

    while (!queue.isEmpty()) {
        int currentNode = queue.poll();
        System.out.print(currentNode + " ");

        // Visit all neighbors of the current node
        for (int neighbor : adj.get(currentNode)) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                queue.add(neighbor);
            }
        }
    }
    System.out.println();
}
-------------------------------------------------------------------------------
// 2. Depth-First Search (DFS)
// Best for: Finding connected components, topological sorting, and solving puzzles.
public void dfs(int startNode, List<List<Integer>> adj) {
    boolean[] visited = new boolean[adj.size()];
    dfsRecursive(startNode, adj, visited);
}

private void dfsRecursive(int currentNode, List<List<Integer>> adj, boolean[] visited) {
    visited[currentNode] = true;
    System.out.print(currentNode + " ");

    for (int neighbor : adj.get(currentNode)) {
        if (!visited[neighbor]) {
            dfsRecursive(neighbor, adj, visited);
        }
    }
}
