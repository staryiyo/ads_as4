# Assignment 4: Graph Traversal and Representation System

## Project Overview
In this project I implemented a graph structure and two traversal algorithms: BFS and DFS.
A graph is a set of vertices (nodes) connected by edges (lines).
The goal was to build the graph using an adjacency list and compare
how BFS and DFS behave on different graph sizes.

---

## Class Descriptions

### Vertex
Represents a single node in the graph. Each vertex has a unique id number.

<img width="556" height="534" alt="image" src="https://github.com/user-attachments/assets/e27ab9b3-cfb1-4180-ac7e-30a675d1a2cc" />


### Edge
Represents a connection between two vertices. It stores the source vertex
and the destination vertex.

<img width="647" height="634" alt="image" src="https://github.com/user-attachments/assets/833214bb-9528-4248-ae73-18a5cb9042e5" />


### Graph
The main class that holds the graph structure. It uses an adjacency list —
a map where each vertex stores a list of its neighbors. This is more efficient
than a matrix for sparse graphs because it only stores existing connections.

<img width="968" height="872" alt="image" src="https://github.com/user-attachments/assets/8e64a882-5730-4240-96af-faad36293707" />
<img width="1156" height="884" alt="image" src="https://github.com/user-attachments/assets/d4a71147-4043-4637-8f9c-aa723664055e" />
<img width="912" height="386" alt="image" src="https://github.com/user-attachments/assets/0c55dbf2-560f-4299-a9f3-306e2501a591" />


### Experiment
Handles performance testing. It builds graphs of different sizes,
runs BFS and DFS on each, and measures execution time using nanoTime().

<img width="1151" height="879" alt="image" src="https://github.com/user-attachments/assets/3a4eb038-0f17-468c-a54e-442200333d80" />
<img width="1156" height="866" alt="image" src="https://github.com/user-attachments/assets/77c1c397-af86-48dc-87f6-d7bfa408ea16" />


---

## Algorithm Descriptions

### BFS (Breadth-First Search)
BFS starts from a given vertex and visits all its neighbors first.
Then it visits the neighbors of those neighbors, and so on.
It uses a queue to keep track of which vertex to visit next.
This means it explores the graph level by level, like circles on water.

Use cases: finding the shortest path, exploring nearby nodes first.
Time complexity: O(V + E) where V is vertices and E is edges.

### DFS (Depth-First Search)
DFS starts from a given vertex and goes as deep as possible along one path.
When it reaches a dead end, it goes back and tries the next path.
It uses recursion to go deeper into the graph.

Use cases: detecting cycles, exploring all possible paths, maze solving.
Time complexity: O(V + E)

---

## Experimental Results

<img width="1712" height="792" alt="image" src="https://github.com/user-attachments/assets/3b91314b-50b1-4976-b39e-16b6fee5acea" />
<img width="1743" height="567" alt="image" src="https://github.com/user-attachments/assets/cf07d699-322e-41e1-a6a2-f9514d239d37" />


All times are in nanoseconds (ns).

**Small graph (10 vertices)**
BFS time: 240600 ns
DFS time: 226400 ns

**Medium graph (30 vertices)**
BFS time: 770900 ns
DFS time: 813100 ns

**Large graph (100 vertices)**
BFS time: 2689700 ns
DFS time: 2806200 ns

---

## Analysis

**How does graph size affect performance?**
Both BFS and DFS got slower as the graph size increased.
From 10 to 100 vertices, BFS went from 240600 ns to 2689700 ns,
which is about 11 times slower. This matches O(V + E) complexity —
more vertices and edges means more work.

**Which traversal was faster?**
The results were very close. On small and large graphs BFS was slightly faster,
on medium graphs DFS was slightly faster. In general they perform similarly
because both have the same O(V + E) complexity.

**Do results match expected complexity?**
Yes. Both algorithms grow roughly proportional to the number of vertices and edges,
which matches the expected O(V + E) behavior.

**How does graph structure affect traversal order?**
In the demo graph with branching edges, BFS and DFS gave completely different orders.
BFS visited: 0 1 2 3 4 5 6 7 8 9 — level by level.
DFS visited: 0 1 3 7 4 8 2 5 9 6 — going deep into each branch first.
In the experiment graphs the structure was more like a chain,
so both algorithms produced the same order.

**When is BFS preferred over DFS?**
BFS is better when you need to find the shortest path or explore
the closest vertices first. DFS is better when you need to explore
all possible paths or check if a path exists at all.

**What are the limitations of DFS?**
DFS can go very deep into one path before exploring others.
On very large graphs this can cause a stack overflow due to deep recursion.
It also does not guarantee finding the shortest path.

---

## Reflection
This assignment helped me understand how graphs work and why
the way we traverse them matters. Before this I thought BFS and DFS
would perform very differently, but in practice their execution times
were very close because they both visit every vertex and edge once.

The most interesting part was seeing how the traversal order changes
depending on the graph structure. In the demo graph DFS went deep
into branches while BFS stayed level by level. This made the difference
between the two algorithms much clearer than just reading about them.
