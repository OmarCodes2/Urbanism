package IslandGenerator.model.Tiles.TileTypes;

import IslandGenerator.model.Tiles.Tile;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Polygon;

public class AquiferTile extends Tile {
    public AquiferTile(Polygon polygon,int id) {
        super(polygon, "173,216,230", id,0,20);
    }

    @Override
    public String getType() {
        return "aquifer";
    }
}
