# Graph Library and Pathfinding Algorithms

## Author

Author: Omar Bakr

## Rationale

This project provides a simple, yet extensible graph library, with support for weighted edges and a flexible interface for implementing pathfinding algorithms. The primary goal of this project is to offer a modular and maintainable solution for working with graphs and finding the shortest paths between nodes. The library is designed to follow the SOLID principles, ensuring code quality and maintainability.

## Components

The project includes the following components:

- `Node`: Represents a single node in the graph, containing its id, name, and elevation.
- `Edge` (interface) and `WeightedEdge`: Represents an edge between two nodes in the graph. The `Edge` interface provides a contract for any edge implementation, while `WeightedEdge` is a specific implementation for edges with a weight (i.e., distance or cost).
- `Graph` (interface) and `GraphImpl`: Represents a graph containing nodes and edges. The `Graph` interface provides a contract for any graph implementation, while `GraphImpl` is a specific implementation that stores nodes and edges in a simple data structure (HashSet). The `Graph` interface also provides methods for adding nodes/edges and accessing adjacent nodes/edges, keeping the graph-related operations within this class.
- `PathFinder` (interface) and `DijkstraPathFinder`: Represents a pathfinding algorithm to find the shortest path between two nodes in a graph. The `PathFinder` interface provides a contract for any pathfinding algorithm implementation, while `DijkstraPathFinder` is a specific implementation that uses Dijkstra's algorithm.

## Extending the Library with a New Algorithm

To implement a new pathfinding algorithm, follow these steps:

1. Create a new class in the `pathfinder` package that implements the `PathFinder` interface.

```java
package pathfinder;

import graph.Node;
import java.util.List;

public class YourPathFinder implements PathFinder {
    @Override
    public List<Node> findPath(Node source, Node destination) {
        // Implement your algorithm here
    }
}
Implement the findPath method in your new class. This method should take two Node objects as input, source and destination, and return a List<Node> representing the shortest path between them. Make sure to use the Graph and Edge interfaces in your implementation to ensure compatibility with different graph and edge types.

Instantiate your pathfinding algorithm by passing a Graph object to your new class's constructor (if needed) and call the findPath method to find the shortest path between two nodes.

java

Graph graph = new GraphImpl();


YourPathFinder pathFinder = new YourPathFinder(graph);
List<Node> path = pathFinder.findPath(sourceNode, destinationNode);
By following these steps, you can easily extend the library with new pathfinding algorithms while maintaining compatibility with the existing Graph and Edge implementations.

### Product Backlog
| Id | Feature title | Who? | Start | End | Status |
|:--:|---------------|------|-------|-----|--------|
| F01 (Graph ADT) | Create a Graph ADT that can represent Nodes and Edges| Omar | 2023-04-06 | 2023-04-06 | D |
| F02 (Node and Edge Attributes) | Allow the ability to hold attributes within Nodes and Edges | Omar | 2023-04-06 | 2023-04-06 | D |
| F03 (Pathfinding Interface) | Define a public contract/interface for finding a path between two nodes | Omar | 2023-04-06 | 2023-04-06 | D|
| F04 (Pathfinder Algorithm) |Implement a pathfinder algorithm to find a shortest path between two nodes | Omar | 2023-04-06 |2023-04-06 | D |