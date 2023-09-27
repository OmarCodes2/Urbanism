// package pathfinder;

// import graph.Graph;
// import graph.GraphImpl;
// import graph.Node;
// import graph.WeightedEdge;
// import org.junit.jupiter.api.BeforeAll;
// import org.junit.jupiter.api.Test;

// import java.util.Arrays;
// import java.util.List;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNull;

// public class DijkstraPathFinderTest {
//     private static Graph graph;
//     private static Node nodeA;
//     private static Node nodeB;
//     private static Node nodeC;
//     private static Node nodeD;
//     private static DijkstraPathFinder pathFinder;

//     @BeforeAll
//     public static void init() {
//         graph = new GraphImpl();
//         nodeA = new Node(1, "Node A", 100.0);
//         nodeB = new Node(2, "Node B", 200.0);
//         nodeC = new Node(3, "Node C", 300.0);
//         nodeD = new Node(4, "Node D", 400.0);

//         graph.addNode(nodeA);
//         graph.addNode(nodeB);
//         graph.addNode(nodeC);
//         graph.addNode(nodeD);

//         graph.addEdge(new WeightedEdge(nodeA, nodeB, 1));
//         graph.addEdge(new WeightedEdge(nodeB, nodeC, 2));
//         graph.addEdge(new WeightedEdge(nodeC, nodeA, 3));
//         graph.addEdge(new WeightedEdge(nodeA, nodeD, 4));

//         pathFinder = new DijkstraPathFinder(graph);
//     }


//     @Test
//     public void testFindPathBoundary() {
//         List<Node> path = pathFinder.findPath(nodeA, nodeA);
//         assertEquals(1, path.size());
//         assertEquals(nodeA, path.get(0));
//     }

//     @Test
//     public void testFindPathInverse() {
//         List<Node> path1 = pathFinder.findPath(nodeA, nodeC);
//         List<Node> path2 = pathFinder.findPath(nodeC, nodeA);
//         assertEquals(path1.size(), path2.size());
//     }


//     @Test
//     public void testFindPathCrossCheck() {
//         List<Node> path = pathFinder.findPath(nodeA, nodeD);
//         List<Node> expectedPath = Arrays.asList(nodeA, nodeD);
//         assertEquals(expectedPath, path);
//     }
//     @Test
//     public void testFindPathError() {
//         Node nonExistentNode = new Node(5, "Node E", 500.0);
//         assertNull(pathFinder.findPath(nodeA, nonExistentNode));
//     }

//     @Test
//     public void testFindPathConformance() {
//         List<Node> path = pathFinder.findPath(nodeA, nodeC);
//         List<Node> expectedPath = Arrays.asList(nodeA, nodeB, nodeC);
//         assertEquals(expectedPath, path);
//     }


//     @Test
//     public void testFindPathExistence() {
//         List<Node> path = pathFinder.findPath(nodeA, nodeD);
//         assertEquals(nodeA, path.get(0));
//         assertEquals(nodeD, path.get(path.size() - 1));
//     }
// }