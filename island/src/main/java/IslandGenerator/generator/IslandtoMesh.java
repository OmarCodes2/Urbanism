package IslandGenerator.generator;

import IslandGenerator.CityGenerator.CityGraphBridge;
import IslandGenerator.model.Island;
import IslandGenerator.model.MapTypes.Map;
import IslandGenerator.model.MapTypes.MapTypes.DefaultMap;
import IslandGenerator.model.MapTypes.MapTypes.ElevationMap;
import IslandGenerator.model.MapTypes.MapTypes.HeatMap;
import IslandGenerator.model.MapTypes.MapTypes.ResourceMap;
import IslandGenerator.model.Tiles.Tile;
import ca.mcmaster.cas.se2aa4.a2.io.Structs;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Mesh;


public class IslandtoMesh {
    public static Mesh.Builder generateMesh(Island island,String map_type, String num_cities) {
        Map map;
        
        switch (map_type) {
            case "heat":
                    map = new HeatMap();
                    break;
            case "elevation":
                    map = new ElevationMap();
                    break;
            case "resource":
                    map = new ResourceMap();
                    break;
            default:
                    map = new DefaultMap();
                    break;
        }

        Mesh.Builder mesh = map.generate_mesh(island);
        mesh = CityGraphBridge.generateCity(island, mesh, num_cities);

        return mesh;
    }
        

}