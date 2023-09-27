package IslandGenerator.CityGenerator;

import ca.mcmaster.cas.se2aa4.a2.io.Structs.Mesh;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Property;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Segment;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Vertex;
import graph.Graph;
import graph.Node;
import pathfinder.DijkstraPathFinder;
import pathfinder.PathFinder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class MeshUtil {
    public static Mesh.Builder updateMeshWithCities(Mesh.Builder mesh, Graph graph, List<Node> cities) {
        List<Vertex> vertices = mesh.getVerticesList();
        Random random = new Random();
        int randomIndex = random.nextInt(cities.size());
        Node starCity = cities.get(randomIndex);

        cities.remove(randomIndex);
        Property color = Property.newBuilder().setKey("rgb_color").setValue("0,0,255").build();
        ArrayList<Vertex> citiesVertices = new ArrayList<>();
        double x1 = vertices.get(starCity.getId()).getX();
        double y1 = vertices.get(starCity.getId()).getY();
        citiesVertices.add(Vertex.newBuilder().setX((double) x1).setY((double) y1).addProperties(color).build());

        color = Property.newBuilder().setKey("rgb_color").setValue("225,0,0").build();
        Set<Segment> segments = new HashSet<>();
        PathFinder shortestPath = new DijkstraPathFinder(graph);
        for (Node city : cities) {
            List<Node> path = shortestPath.findPath(starCity, city);
            double x = vertices.get(city.getId()).getX();
            double y = vertices.get(city.getId()).getY();

            if (path != null) {
                citiesVertices.add(Vertex.newBuilder().setX((double) x).setY((double) y).addProperties(color).build());

                for (int i = 1; i < path.size(); i++) {
                    int node1 = path.get(i).getId();
                    int node2 = path.get(i - 1).getId();

                    segments.add(Segment.newBuilder().setV1Idx(node1).setV2Idx(node2).addProperties(color).build());
                }
            }
        }
        mesh.addAllSegments(segments);
        mesh.addAllVertices(citiesVertices);

        return mesh;
    }
}
