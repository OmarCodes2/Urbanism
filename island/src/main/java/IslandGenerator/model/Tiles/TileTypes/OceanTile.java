package IslandGenerator.model.Tiles.TileTypes;

import IslandGenerator.model.Tiles.Tile;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Polygon;

public class OceanTile extends Tile {

    public OceanTile(Polygon polygon,int id) {
        super(polygon, 25+","+25+","+112,id,0,0);
    
    }

    @Override
    public String getType() {
        return "ocean";
    }
    
}
