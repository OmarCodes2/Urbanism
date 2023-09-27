package IslandGenerator.CityGenerator;

import IslandGenerator.model.Tiles.Tile;
import graph.Edge;
import graph.Graph;
import graph.GraphImpl;
import graph.Node;
import graph.WeightedEdge;

import java.util.HashMap;
import java.util.List;

public class IslandGraphBuilder {
    public static Graph buildGraphFromIsland(List<Tile> tiles) {
        Graph graph = new GraphImpl();
        HashMap<Integer, Node> map = new HashMap<>();

        for (Tile tile : tiles) {
            if (!tile.getType().equals("ocean")){
                int idx = tile.getPolygon().getCentroidIdx();
                Node node = new Node(idx, "test", idx);
                map.put(tile.getId(), node);
                graph.addNode(node);
            }
        }

        for (Tile tile : tiles) {
            if (!tile.getType().equals("ocean")){
                List<Integer> neighbours = tile.getPolygon().getNeighborIdxsList();
                for (Integer idx : neighbours){
                    if(map.containsKey(idx)){
                        Node sourceNode = map.get(tile.getId());
                        Node targetNode = map.get(idx);

                        Edge edge = new WeightedEdge(sourceNode, targetNode, 1);
                        graph.addEdge(edge);
                    }
                }
            }
        }
        return graph;
    }
}