package IslandGenerator.model.MapTypes.MapTypes;


import IslandGenerator.model.Island;
import IslandGenerator.model.MapTypes.Map;
import IslandGenerator.model.Tiles.Tile;
import ca.mcmaster.cas.se2aa4.a2.io.Structs;

public class ElevationMap extends Map {
   
    @Override
    public Structs.Mesh.Builder generate_mesh(Island island) {
        Structs.Mesh islandMesh = island.getMesh();
        Structs.Mesh.Builder mesh = Structs.Mesh.newBuilder();
        
        mesh.addAllVertices(islandMesh.getVerticesList());
        mesh.addAllSegments(islandMesh.getSegmentsList());

        for (Tile tile : island.getTiles()) {
            Structs.Polygon.Builder newPolygon = Structs.Polygon.newBuilder(tile.getPolygon());

            int alpha = (int) (tile.getElevation()/3); 
            alpha = Math.min(Math.max(alpha, 0), 255);

            String rgbaColorString = String.format("%d,%d,%d,%d", 46,139,87,alpha);
            Structs.Property property = Structs.Property.newBuilder().setKey("rgb_color").setValue(rgbaColorString).build();
            newPolygon.addProperties(property);
            
            mesh.addPolygons(newPolygon);
        } 
        return mesh;   
    }
}
