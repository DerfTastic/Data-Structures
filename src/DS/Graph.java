package DS;

public class Graph <E> {

    public Vertex<E>[] V;
    public boolean[][] A; // Adjacency Matrix
    public int length; // size n

    /** @param n Number of vertices */
    public Graph(int n) {
        this.length = n;
        V = new Vertex[n];
        A = new boolean[n][n];
    }

    public Graph(E[] vLabels) {
        this.length = vLabels.length;
        V = new Vertex[vLabels.length];
        for (int i = 0; i < vLabels.length; i++) {
            V[i] = new Vertex(vLabels[i]);
        }
        A = new boolean[vLabels.length][vLabels.length];
    }

    public void DepthFirstSearch(Vertex v) {
        v.wasVisited = true;
        // --- Pseudo: ---
        // while there is an unvisited vertex u adjacent to v
        // DFS(u);

        // Test if there is an unvisited vertex u adjacent to v
    }

    public void printAdjMat() {
        // Print top header
        print("\t");
        for (Vertex<E> lab : V)
            print(lab.label + "\t");
        print("\n");

        // Print table with labels on right
        for (int i = 0; i < this.A.length; i++) {
            print(V[i].label + "\t");
            for (int j = 0; j < this.A[0].length; j++) {
                print((A[i][j] ? 1 : 0) + "\t");
            }
            print("\n");
        }
    }

    public void link(int ai, int bi) {
        this.A[ai][bi] = true;
        this.A[bi][ai] = true;
    }

    public boolean isLinked(int ai, int bi) {
        return this.A[ai][bi];
    }

    public void print(Object s) { System.out.print(s); }

}