import java.util.*;

public class Graph {
    private Map<Integer, List<Integer>> adjList = new HashMap<>();
    private Map<Integer, Vertex> vertices = new HashMap<>();

    public void addVertex(Vertex v) {
        vertices.put(v.getId(), v);
        adjList.put(v.getId(), new ArrayList<>());
    }

    public void addEdge(int from, int to) {
        // ненаправленный граф — добавляем в обе стороны
        adjList.get(from).add(to);
        adjList.get(to).add(from);
    }

    public void printGraph() {
        System.out.println("Graph structure:");
        for (int id : adjList.keySet()) {
            System.out.println("Vertex " + id + " -> " + adjList.get(id));
        }
    }

    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        System.out.print("BFS: ");

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int neighbor : adjList.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        System.out.print("DFS: ");
        dfsHelper(start, visited);
        System.out.println();
    }

    private void dfsHelper(int current, Set<Integer> visited) {
        visited.add(current);
        System.out.print(current + " ");

        for (int neighbor : adjList.get(current)){
            if (!visited.contains(neighbor)){
                dfsHelper(neighbor, visited);
            }
        }
    }
}