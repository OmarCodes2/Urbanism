package IslandGenerator.model.Elevation.ElevationProfiles;

import IslandGenerator.model.Elevation.elevation;
import IslandGenerator.model.Shapes.Shape;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Vertex;

public class Volcano extends elevation{
    //radius of island is 500
    //getDistance will have a max distance of 500
    //centre's elevation
    int max_elev = 800;

    @Override
    public int ElevationatDistance(Vertex centroid,Shape island_shape) {
        
        int distance = island_shape.getDistance(centroid);

        return this.max_elev - distance;
    }
}
