package graph;

import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;

public class GraphImpl implements Graph {
    private Set<Node> nodes = new HashSet<>();
    private Set<Edge> edges = new HashSet<>();

    @Override
    public void addNode(Node node) {
        nodes.add(node);
    }

    @Override
    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    @Override
    public Set<Node> getNodes() {
        return nodes;
    }

    @Override
    public Set<Edge> getEdges() {
        return edges;
    }

    @Override
    public Set<Edge> getAdjacentEdges(Node node) {
        return edges.stream()
                .filter(edge -> edge.getSource().equals(node) || edge.getDestination().equals(node))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Node> getAdjacentNodes(Node node) {
        return getAdjacentEdges(node).stream().map(Edge::getDestination).collect(Collectors.toSet());
    }
  
}