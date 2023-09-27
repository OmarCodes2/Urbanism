package IslandGenerator.calculators;

import java.util.List;

import IslandGenerator.model.Soil.Soil;
import IslandGenerator.model.Tiles.Tile;
import ca.mcmaster.cas.se2aa4.a2.io.Structs;

public class HumidityCalculator {
    public static void calculateSurroundHumidity(Tile tile, List<Tile> tile_list,List<Structs.Vertex> vertice_list, Soil soil_type){
        for(Tile land_tile : tile_list){
            if(land_tile.getType().equals("land") || land_tile.getType().equals("beach")){
                int distance = DistanceCalculator.calculateDistance(vertice_list.get(tile.getPolygon().getCentroidIdx()), vertice_list.get(land_tile.getPolygon().getCentroidIdx()));
                double humidity = ((tile.getHumidity()/distance)/soil_type.getAbsorption())*100;
                land_tile.addHumidity(humidity);
            }
        }
    }
}
