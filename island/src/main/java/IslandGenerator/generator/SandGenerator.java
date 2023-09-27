package IslandGenerator.generator;

import java.util.ArrayList;
import java.util.List;

import IslandGenerator.model.Tiles.Tile;
import IslandGenerator.model.Tiles.TileTypes.BeachTile;
import ca.mcmaster.cas.se2aa4.a2.io.Structs;

public class SandGenerator {
    public static List<Tile> addSand(List<Tile> tile_list){
        List<Tile> modified_tile_list = new ArrayList<>();
    
        for(Tile tile : tile_list){
            //if a tile is a land type
            if(tile.getType().equals("land")){
                Structs.Polygon polygon_tile = tile.getPolygon();
                List<Integer> neighbhours = polygon_tile.getNeighborIdxsList();
                boolean is_beach_tile = false;
    
                for(Integer i: neighbhours){
                    //get the corresponding tile id since every tile is mapped to a corresponding polygon id
                    //edit tile_list in place
                    if(tile_list.get(i).getType().equals("ocean")){
                        is_beach_tile = true;
                        break;
                    }
                }
    
                if(is_beach_tile){
                    modified_tile_list.add(new BeachTile(tile.getPolygon(),tile.getId(),tile.getElevation()));
                } else {
                    modified_tile_list.add(tile);
                }
            } else {
                modified_tile_list.add(tile);
            }
        }
    
        return modified_tile_list;
    }
}
