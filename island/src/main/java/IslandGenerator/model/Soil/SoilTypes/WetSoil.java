package IslandGenerator.model.Soil.SoilTypes;

import java.util.List;

import IslandGenerator.model.Soil.Soil;
import IslandGenerator.model.Tiles.Tile;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Vertex;

public class WetSoil extends Soil {
    //larger the absorption value the lower the humidity of the land tiles
    public WetSoil(){
        super("wet",1.9);
    }



}
