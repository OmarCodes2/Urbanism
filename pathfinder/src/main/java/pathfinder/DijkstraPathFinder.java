package pathfinder;

import graph.Node;
import graph.Edge;
import graph.Graph;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Comparator;

public class DijkstraPathFinder implements PathFinder {
    private Graph graph;

    public DijkstraPathFinder(Graph graph) {
        this.graph = graph;
    }

    @Override
    public List<Node> findPath(Node source, Node destination) {
        Map<Node, Node> previousNodes = new HashMap<>();
        Map<Node, Double> distances = new HashMap<>();
        Set<Node> visited = new HashSet<>();
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));

        for (Node node : graph.getNodes()) {
            distances.put(node, Double.MAX_VALUE);
        }
        distances.put(source, 0.0);
        queue.add(source);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if (currentNode.equals(destination)) {
                break;
            }

            if (!visited.contains(currentNode)) {
                visited.add(currentNode);

                for (Edge edge : graph.getAdjacentEdges(currentNode)) {
                    Node neighbor = edge.getDestination();
                    double newDistance = distances.get(currentNode) + edge.getWeight();

                    if (newDistance < distances.get(neighbor)) {
                        distances.put(neighbor, newDistance);
                        previousNodes.put(neighbor, currentNode);
                        queue.add(neighbor);
                    }
                }
            }
        }

        if (!previousNodes.containsKey(destination)) {
            return null; // No path found
        }

        List<Node> path = new ArrayList<>();
        Node currentNode = destination;
        while (currentNode != null) {
            path.add(0, currentNode);
            currentNode = previousNodes.get(currentNode);
        }

        return path;
    }
}