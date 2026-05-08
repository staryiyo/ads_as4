public class Main {
    public static void main(String[] args) {

        Experiment experiment = new Experiment();

        System.out.println("===== DEMO (Small Graph) =====");
        Graph small = new Graph();
        for (int i = 0; i < 10; i++) {
            small.addVertex(new Vertex(i));
        }
        small.addEdge(0, 1);
        small.addEdge(0, 2);
        small.addEdge(1, 3);
        small.addEdge(1, 4);
        small.addEdge(2, 5);
        small.addEdge(2, 6);
        small.addEdge(3, 7);
        small.addEdge(4, 8);
        small.addEdge(5, 9);

        small.printGraph();
        System.out.println();
        experiment.runTraversals(small);

        System.out.println();
        System.out.println("===== EXPERIMENT RESULTS =====");
        System.out.println();
        experiment.runMultipleTests();
    }
}