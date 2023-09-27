package IslandGenerator.calculators;

import IslandGenerator.model.Shapes.Shape;
import IslandGenerator.model.Tiles.Tile;
import IslandGenerator.model.Tiles.TileTypes.LandTile;
import IslandGenerator.model.Tiles.TileTypes.OceanTile;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Polygon;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Vertex;

public class TileTypeCalculator {
    public static Tile calculateType(Polygon polygon,Vertex centroid, Shape shape, int poly_id,int elevation){
        Tile tile;
        if(shape.inside(centroid)){
            tile = new LandTile(polygon,poly_id, elevation);

        } else {
            tile = new OceanTile(polygon,poly_id);
        }
        return tile;
    }
    //takes in a polygon and shape, and uses shape built in function to decide position
    //use a switch statement and create the corresponding tiletypes
}
