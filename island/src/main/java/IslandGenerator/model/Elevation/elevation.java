package IslandGenerator.model.Elevation;

import IslandGenerator.model.Shapes.Shape;
import ca.mcmaster.cas.se2aa4.a2.io.Structs;

public abstract class elevation {
    public abstract int ElevationatDistance(Structs.Vertex centroid,Shape island_shape);
}
