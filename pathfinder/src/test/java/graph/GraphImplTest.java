// package graph;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;

// import java.util.Set;

// import static org.junit.jupiter.api.Assertions.*;

// class GraphImplTest {
//     private GraphImpl graph;
//     private Node node1, node2, node3, node4;
//     private Edge edge1, edge2, edge3;

//     @BeforeEach
//     void setUp() {
//         graph = new GraphImpl();
//         node1 = new Node(1, "A", 1.0);
//         node2 = new Node(2, "B", 2.0);
//         node3 = new Node(3, "C", 3.0);
//         node4 = new Node(4, "D", 4.0);

//         edge1 = new WeightedEdge(node1, node2, 5.0);
//         edge2 = new WeightedEdge(node1, node3, 6.0);
//         edge3 = new WeightedEdge(node2, node3, 7.0);
//     }

//     @Test
//     void testAddAndGetNodesAndEdges() {
//         graph.addNode(node1);
//         graph.addNode(node2);
//         graph.addNode(node3);

//         assertEquals(3, graph.getNodes().size());
//         assertTrue(graph.getNodes().containsAll(Set.of(node1, node2, node3)));

//         graph.addEdge(edge1);
//         graph.addEdge(edge2);
//         graph.addEdge(edge3);

//         assertEquals(3, graph.getEdges().size());
//         assertTrue(graph.getEdges().containsAll(Set.of(edge1, edge2, edge3)));
//     }

//     @Test
//     void testBoundaryConditions() {
//         graph.addNode(node1);
//         graph.addNode(node1);

//         assertEquals(1, graph.getNodes().size());

//         graph.addEdge(edge1);
//         graph.addEdge(edge1);

//         assertEquals(1, graph.getEdges().size());

//         assertTrue(graph.getAdjacentEdges(node4).isEmpty());
//         assertTrue(graph.getAdjacentNodes(node4).isEmpty());
//     }

//     @Test
//     void testInverseRelationships() {
//         graph.addNode(node1);
//         graph.addNode(node2);
//         graph.addNode(node3);
    
//         graph.addEdge(edge1);
//         graph.addEdge(edge2);
//         graph.addEdge(edge3);
    
//         assertTrue(graph.getAdjacentNodes(node1).contains(node2));
//         assertTrue(graph.getAdjacentNodes(node1).contains(node3));
    
//         graph.getNodes().remove(node2);
    
//         assertFalse(graph.getAdjacentNodes(node1).contains(node2));
//         graph.getEdges().removeIf(edge -> edge.getSource().equals(node2) || edge.getDestination().equals(node2));
//         assertFalse(graph.getEdges().contains(edge1));
//     }

//     @Test
//     void testCrossCheckResults() {
//         graph.addNode(node1);
//         graph.addNode(node2);
//         graph.addNode(node3);

//         graph.addEdge(edge1);
//         graph.addEdge(edge2);
//         graph.addEdge(edge3);

//         assertEquals(graph.getAdjacentNodes(node1).size(), graph.getAdjacentEdges(node1).size());
//     }

//     @Test
//     void testErrorConditions() {
//         assertThrows(IllegalArgumentException.class, () -> graph.addNode(null));
//         assertThrows(IllegalArgumentException.class, () -> graph.addEdge(null));
//         assertThrows(IllegalArgumentException.class, () -> graph.getAdjacentEdges(null));
//         assertThrows(IllegalArgumentException.class, () -> graph.getAdjacentNodes(null));
//     }

// }