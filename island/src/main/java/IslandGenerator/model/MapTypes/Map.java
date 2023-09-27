package IslandGenerator.model.MapTypes;

import IslandGenerator.model.Island;
import ca.mcmaster.cas.se2aa4.a2.io.Structs;

public abstract class Map {
   public abstract Structs.Mesh.Builder generate_mesh(Island island);
}
