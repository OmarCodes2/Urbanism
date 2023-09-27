package graph;

public interface Edge {
    Node getSource();
    Node getDestination();
    double getWeight();
}
