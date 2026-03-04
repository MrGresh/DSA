// 1-based Indexing
public class AdjacencyMatrix {
    private int[][] matrix;
    private int numVertices;

    public AdjacencyMatrix(int numVertices) {
        this.numVertices = numVertices;
        matrix = new int[numVertices+1][numVertices+1];
    }

    public void addEdge(int i, int j, int w) {
        // Note : If graph is not weight then we will store 1 as edge weight
        matrix[i][j] = w;
        matrix[j][i] = w; // Remove this for directed graphs
    }

    public void printGraph() {
        for (int i = 0; i <= numVertices; i++) {
            for (int j = 0; j <= numVertices; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        AdjacencyMatrix g = new AdjacencyMatrix(4);
        g.addEdge(0, 1, 7);
        g.addEdge(0, 2, 4);
        g.addEdge(1, 2, 9);
        g.addEdge(2, 3, 7);
        g.printGraph();
    }
}
----------------------------------------------------------------------------------------
Best for: Dense graphs or when you need to quickly check if an edge exists O(1).
Downside: Uses O(V^2) space regardless of how many edges exist.
