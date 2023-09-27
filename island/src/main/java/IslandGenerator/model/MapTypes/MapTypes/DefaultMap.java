package IslandGenerator.model.MapTypes.MapTypes;



import IslandGenerator.model.MapTypes.Map;
import IslandGenerator.model.Island;
import IslandGenerator.model.Tiles.Tile;
import ca.mcmaster.cas.se2aa4.a2.io.Structs;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Mesh.Builder;


public class DefaultMap extends Map{

    @Override
    public Builder generate_mesh(Island island) {
      
        Structs.Mesh islandMesh = island.getMesh();
        Structs.Mesh.Builder mesh = Structs.Mesh.newBuilder();
        
        mesh.addAllVertices(islandMesh.getVerticesList());
        mesh.addAllSegments(islandMesh.getSegmentsList());

        for (Tile tile: island.getTiles()){
            Structs.Polygon.Builder newPolygon = Structs.Polygon.newBuilder(tile.getPolygon());
            String color = tile.getColor();

            

            Structs.Property property = Structs.Property.newBuilder().setKey("rgb_color").setValue(color).build(); 
            newPolygon.addProperties(property);

            mesh.addPolygons(newPolygon);

        }
        return mesh;
    }
    
}
