package IslandGenerator.model.Tiles.TileTypes;

import IslandGenerator.model.Tiles.Tile;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Polygon;

public class LandTile extends Tile {

    public LandTile(Polygon polygon,int id, int elevation) {
        super(polygon, "79,121,66",id,elevation,0);
    }

    @Override
    public String getType() {
        return "land";
    }    

}
