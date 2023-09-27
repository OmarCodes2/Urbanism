package IslandGenerator.model.Tiles.TileTypes;

import IslandGenerator.model.Tiles.Tile;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Polygon;

public class LakeTile extends Tile{
    public LakeTile(Polygon polygon,int id, int elevation) {
        super(polygon, "95,158,160",id,elevation,30);
    }

    @Override
    public String getType() {
        return "lake";
    }
}
