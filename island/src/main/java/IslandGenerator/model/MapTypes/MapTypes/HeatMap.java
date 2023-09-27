package IslandGenerator.model.MapTypes.MapTypes;

import IslandGenerator.model.Island;
import IslandGenerator.model.MapTypes.Map;
import IslandGenerator.model.Tiles.Tile;
import ca.mcmaster.cas.se2aa4.a2.io.Structs;


public class HeatMap extends Map{

    @Override
    public Structs.Mesh.Builder generate_mesh(Island island) {
        Structs.Mesh islandMesh = island.getMesh();
        Structs.Mesh.Builder mesh = Structs.Mesh.newBuilder();
        
        mesh.addAllVertices(islandMesh.getVerticesList());
        mesh.addAllSegments(islandMesh.getSegmentsList());

        for (Tile tile : island.getTiles()) {
            Structs.Polygon.Builder newPolygon = Structs.Polygon.newBuilder(tile.getPolygon());

            int alpha = (int) (tile.getHumidity()/6); // adjust alpha based on humidity
            alpha = Math.min(Math.max(alpha, 0), 255); // clamp alpha value between 0 and 255
            
            String rgbaColorString = String.format("%d,%d,%d,%d", 0,0,128,alpha);
            Structs.Property property = Structs.Property.newBuilder().setKey("rgb_color").setValue(rgbaColorString).build();
            newPolygon.addProperties(property);
            
            mesh.addPolygons(newPolygon);
        } 
        return mesh;   
    }
    
}
