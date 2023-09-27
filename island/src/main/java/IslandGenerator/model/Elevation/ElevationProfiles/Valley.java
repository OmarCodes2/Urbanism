package IslandGenerator.model.Elevation.ElevationProfiles;

import IslandGenerator.model.Elevation.elevation;
import IslandGenerator.model.Shapes.Shape;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Vertex;

public class Valley extends elevation{
    int min_elev = 10;
    
    @Override
    public int ElevationatDistance(Vertex centroid,Shape island_shape) {
        
        int distance = island_shape.getDistance(centroid);

        return distance + this.min_elev;
    }

}
