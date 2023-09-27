package IslandGenerator.model.Tiles.TileTypes;

import IslandGenerator.model.Tiles.Tile;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Polygon;

public class BeachTile extends Tile {
    public BeachTile(Polygon polygon,int id, int elevation) {
        super(polygon, "255,255,220",id,elevation,0);
    }

    @Override
    public String getType() {
        return "beach";
    }
}