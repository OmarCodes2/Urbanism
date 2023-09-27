// package IslandGenerator.CityGenerator;

// import ca.mcmaster.cas.se2aa4.a2.io.Structs.Mesh;
// import ca.mcmaster.cas.se2aa4.a2.io.Structs.Vertex;
// import graph.Graph;
// import graph.GraphImpl;
// import graph.Node;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;

// import java.util.List;

// import static org.junit.jupiter.api.Assertions.*;

// public class CityPlacerTest {
//     private Graph graph;
//     private Mesh.Builder mesh;

//     @BeforeEach
//     public void setUp() {
//         // Create a simple graph with 10 nodes
//         graph = new GraphImpl();
//         for (int i = 0; i < 10; i++) {
//             graph.addNode(new Node(i, "test", i));
//         }
    
//         // Create an empty mesh builder with 10 vertices
//         mesh = Mesh.newBuilder();
//         for (int i = 0; i < 10; i++) {
//             mesh.addVertices(Vertex.newBuilder().setX(i * 10).setY(i * 10).build());
//         }
//     }

//     @Test
//     public void testCitiesPlaced() {
//         CityPlacer cityPlacer = new CityPlacer(graph, mesh);
//         List<Node> cities = cityPlacer.getCities();

//         // There should be 5 cities placed
//         assertEquals(5, cities.size());

//         // Check if all the placed cities are part of the graph
//         for (Node city : cities) {
//             assertTrue(graph.getNodes().contains(city));
//         }
//     }

//     @Test
//     public void testMeshUpdated() {
//         CityPlacer cityPlacer = new CityPlacer(graph, mesh);
//         Mesh.Builder cityMesh = cityPlacer.getMesh();
//         List<Node> cities = cityPlacer.getCities();
    
//         // Check if the city mesh has the correct number of vertices
//         assertEquals(cities.size(), cityMesh.getVerticesList().size());
//     }
// }