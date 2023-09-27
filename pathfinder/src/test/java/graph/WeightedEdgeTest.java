// package graph;

// import org.junit.jupiter.api.BeforeAll;
// import org.junit.jupiter.api.Test;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertThrows;

// public class WeightedEdgeTest {
//     private static Node nodeA;
//     private static Node nodeB;

//     @BeforeAll
//     public static void init() {
//         nodeA = new Node(1, "Node A", 100.0);
//         nodeB = new Node(2, "Node B", 200.0);
//     }


//     @Test
//     public void testWeightedEdgeBoundary() {
//         WeightedEdge edge = new WeightedEdge(nodeA, nodeB, 0.0);
//         assertEquals(0.0, edge.getWeight());
//     }


//     @Test
//     public void testWeightedEdgeInverse() {
//         WeightedEdge edge1 = new WeightedEdge(nodeA, nodeB, 5.0);
//         WeightedEdge edge2 = new WeightedEdge(nodeB, nodeA, 5.0);
//         assertEquals(edge1.getWeight(), edge2.getWeight());
//     }


//     @Test
//     public void testWeightedEdgeCrossCheck() {
//         WeightedEdge edge = new WeightedEdge(nodeA, nodeB, 10.0);
//         assertEquals(nodeA, edge.getSource());
//         assertEquals(nodeB, edge.getDestination());
//     }

  
//     @Test
//     public void testWeightedEdgeError() {
//         assertThrows(IllegalArgumentException.class, () -> new WeightedEdge(null, nodeB, 5.0));
//     }

  
//     @Test
//     public void testWeightedEdgeConformance() {
//         WeightedEdge edge = new WeightedEdge(nodeA, nodeB, 3.5);
//         assertEquals(3.5, edge.getWeight());
//     }

    
//     @Test
//     public void testWeightedEdgeRange() {
//         assertThrows(IllegalArgumentException.class, () -> new WeightedEdge(nodeA, nodeB, -1.0));
//     }

  
//     @Test
//     public void testWeightedEdgeExistence() {
//         WeightedEdge edge = new WeightedEdge(nodeA, nodeB, 7.0);
//         assertEquals(nodeA, edge.getSource());
//         assertEquals(nodeB, edge.getDestination());
//     }

// }