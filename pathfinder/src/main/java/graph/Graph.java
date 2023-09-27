package graph;

import java.util.Set;

public interface Graph {
    void addNode(Node node);
    void addEdge(Edge edge);

    Set<Node> getNodes();
    Set<Edge> getEdges();
    
    Set<Edge> getAdjacentEdges(Node node);
    Set<Node> getAdjacentNodes(Node node);
}