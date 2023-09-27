package pathfinder;

import graph.Node;
import java.util.List;

public interface PathFinder {
    List<Node> findPath(Node source, Node destination);
}
