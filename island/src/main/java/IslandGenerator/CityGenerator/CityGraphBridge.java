package IslandGenerator.CityGenerator;

import java.util.List;

import IslandGenerator.model.Island;
import IslandGenerator.model.Tiles.Tile;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Mesh;
import graph.Graph;
import graph.Node;

public class CityGraphBridge {
    public static Mesh.Builder generateCity(Island island, Mesh.Builder mesh, String numCities) {
        List<Tile> tiles = island.getTiles();
        Graph graph = IslandGraphBuilder.buildGraphFromIsland(tiles);
        int noCities = Integer.parseInt(numCities);
        List<Node> cities = CityPlanner.selectCities(graph, noCities);

        return MeshUtil.updateMeshWithCities(mesh, graph, cities);
    }
}