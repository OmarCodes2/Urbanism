package IslandGenerator.generator;

import java.util.List;
import java.util.Random;

import IslandGenerator.model.Tiles.Tile;
import IslandGenerator.model.Tiles.TileTypes.LakeTile;

public class LakeGenerator {
    public static int generate_lakes(String num_lakes){
        int number_lakes;
        
        number_lakes = Integer.parseInt(num_lakes);

        return number_lakes;
    }


    public static List<Tile> addLakes(List<Tile> tile_list,int number_lakes){
       
        Random rand = new Random();
        int lakeCount = 0;
        int maxLakes = rand.nextInt(number_lakes+1); // select a random number of lakes less than number_lakes
        
        while (lakeCount < maxLakes) {
            int randomIndex = rand.nextInt(tile_list.size());
            Tile selectedTile = tile_list.get(randomIndex);
            if (selectedTile.getType().equals("land")) {
                selectedTile =  new LakeTile(selectedTile.getPolygon(),selectedTile.getId(),selectedTile.getElevation());
                tile_list.add(randomIndex, selectedTile);
                tile_list.remove(randomIndex + 1);
                lakeCount++;
            }
        }
        return tile_list;

    }

    public static List<Tile> addLakes(List<Tile> tiles, String lake_seed){
        String[] lake_ranges = lake_seed.split("\\,");



        for(int i = 0; i < lake_ranges.length; i++){
            int selected_index = Integer.parseInt(lake_ranges[i]);
            
           Tile selectedTile = tiles.get(selected_index);

           if(selectedTile.getType().equals("land")){
           selectedTile =  new LakeTile(selectedTile.getPolygon(),selectedTile.getId(),selectedTile.getElevation());
           tiles.add(selected_index, selectedTile);
           tiles.remove(selected_index + 1);
            }

            else{
                System.out.println("Polygon isn't a land tile, cannot make a lake here");
            }

        }


        return tiles;
    }
}
