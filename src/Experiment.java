public class Experiment {

    private Graph graph;

    public void runTraversals(Graph g) {
        this.graph = g;
        g.bfs(0);
        g.dfs(0);
    }

    public void runMultipleTests() {
        int[] sizes = {10, 30, 100};
        String[] sizeNames = {"Small (10)", "Medium (30)", "Large (100)"};

        for (int s = 0; s < sizes.length; s++) {
            Graph g = buildGraph(sizes[s]);

            long start = System.nanoTime();
            g.bfs(0);
            long end = System.nanoTime();
            long bfsTime = end - start;

            start = System.nanoTime();
            g.dfs(0);
            end = System.nanoTime();
            long dfsTime = end - start;

            printResults(sizeNames[s], bfsTime, dfsTime);
        }
    }

    private Graph buildGraph(int size) {
        Graph g = new Graph();

        for (int i = 0; i < size; i++) {
            g.addVertex(new Vertex(i));
        }

        for (int i = 0; i < size - 1; i++) {
            g.addEdge(i, i + 1);
            if (i + 2 < size) {
                g.addEdge(i, i + 2);
            }
        }

        return g;
    }

    public void printResults(String sizeName, long bfsTime, long dfsTime) {
        System.out.println("--- " + sizeName + " ---");
        System.out.println("BFS time: " + bfsTime + " ns");
        System.out.println("DFS time: " + dfsTime + " ns");
        System.out.println();
    }
}