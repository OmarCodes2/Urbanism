package graph;

public class WeightedEdge implements Edge {
    private Node source;
    private Node destination;
    private double weight;

    public WeightedEdge(Node source, Node destination, double weight) {
        if (source == null || destination == null) {
            throw new IllegalArgumentException("Source and destination nodes cannot be null.");
        }
        if (weight < 0) {
            throw new IllegalArgumentException("Weight cannot be negative.");
        }
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public Node getSource() {
        return source;
    }

    @Override
    public Node getDestination() {
        return destination;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}