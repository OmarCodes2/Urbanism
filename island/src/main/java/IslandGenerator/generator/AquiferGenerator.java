package IslandGenerator.generator;

import java.util.List;
import java.util.Random;

import IslandGenerator.model.Tiles.Tile;
import IslandGenerator.model.Tiles.TileTypes.AquiferTile;

public class AquiferGenerator {
    public static List<Tile> addAquifers(List<Tile> tile_list, int num_aquifers){

        Random rand = new Random();

        int aquifCount = 0;

        int maxAquif = rand.nextInt(num_aquifers+1);

        while(aquifCount < maxAquif){
            int randomIndex = rand.nextInt(tile_list.size());

            Tile selectedTile = tile_list.get(randomIndex);

            if (selectedTile.getType().equals("land")) {
                selectedTile =  new AquiferTile(selectedTile.getPolygon(),selectedTile.getId());
                tile_list.add(randomIndex, selectedTile);
                tile_list.remove(randomIndex + 1);
                aquifCount++;
            }

        }

        return tile_list;
    }

    public static List<Tile> addAquifers(List<Tile> tiles, String aquifer_seed){
        String[]  aquifer_ranges = aquifer_seed.split("\\,");



        for(int i = 0; i < aquifer_ranges.length; i++){
            int selected_index = Integer.parseInt( aquifer_ranges[i]);

           Tile selectedTile = tiles.get(selected_index);

           if(selectedTile.getType().equals("land")){
                selectedTile =  new  AquiferTile(selectedTile.getPolygon(),selectedTile.getId());
                tiles.add(selected_index, selectedTile);
                tiles.remove(selected_index + 1);
            }

           else{
            System.out.println("Polygon isn't a land tile, cannot make an aquifer here");
            }

        }


        return tiles;
    }
}
