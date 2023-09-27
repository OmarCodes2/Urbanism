package IslandGenerator.model.Biomes.BiomeTypes;

import java.util.List;

import IslandGenerator.model.Biomes.Biome;
import IslandGenerator.model.Tiles.Tile;
import IslandGenerator.model.Tiles.TileTypes.LandTile;

public class Arctic implements Biome {
    @Override
    public List<Tile> defineBiomes(List<Tile> tiles, double min_humid, double max_humid, int min_elev, int max_elev) {
            
        int period = (max_elev - min_elev) / 2;
        int period_humid = (int) ((max_humid - min_humid)) / 4;
    
        for (Tile tile : tiles) {
            if (tile instanceof LandTile) {
                int elevation = tile.getElevation();
                double humidity = tile.getHumidity();
                String color;
    
                // Determine the elevation range of the tile
                if (elevation < min_elev + period) {
                    // Tile is in the lowest elevation range
                    if (humidity < min_humid + period_humid) {
                        // Tile is in the lowest elevation and lowest humidity range
                        color =  "210,250,250";
                    } else if (humidity < min_humid + 2 * period_humid) {
                        // Tile is in the lowest elevation range and second-lowest humidity range
                        color =  "180,230,230";
                    } else if (humidity < min_humid + 3 * period_humid) {
                        // Tile is in the lowest elevation range and third-lowest humidity range
                        color =  "153,204,204";
                    } else {
                        // Tile is in the lowest elevation range and highest humidity range
                        color =  "128,179,179";
                    }
                } else {
                    // Tile is in the highest elevation range
                    if (humidity < min_humid + period_humid) {
                        // Tile is in the highest elevation range and lowest humidity range
                        color =  "240,255,255";
                    } else if (humidity < min_humid + 2 * period_humid) {
                        // Tile is in the highest elevation range and second-lowest humidity range
                        color =  "204,229,229";
                    } else if (humidity < min_humid + 3 * period_humid) {
                        // Tile is in the highest elevation range and third-lowest humidity range
                        color =  "179,204,204";
                    } else {
                        // Tile is in the highest elevation range and highest humidity range
                        color =  "153,179,179";
                    }
                }
                tile.setColor(color);
            }
        }
        return tiles;
    }
    
}
