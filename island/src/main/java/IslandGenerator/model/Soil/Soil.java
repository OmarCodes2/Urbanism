package IslandGenerator.model.Soil;

import java.util.List;

import IslandGenerator.model.Tiles.Tile;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Vertex;

public abstract class Soil {
    String soil_type;
    double absorption_multiplier;

    public Soil(String soil_type, double absorption_multiplier){
        this.soil_type = soil_type;
        this.absorption_multiplier = absorption_multiplier;
    }

    public String getType(){
        return this.soil_type;
    }

    public double getAbsorption(){
        return this.absorption_multiplier;
    }
}
