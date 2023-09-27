package IslandGenerator.model.Shapes;

import ca.mcmaster.cas.se2aa4.a2.io.Structs;

public abstract class Shape {
    public abstract int getDimension();
    public abstract int getDistance(Structs.Vertex centroid);
    public abstract boolean inside(Structs.Vertex centroid);
}
