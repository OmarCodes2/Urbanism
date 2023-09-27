package IslandGenerator.model.Biomes;

import java.util.List;

import IslandGenerator.model.Tiles.Tile;

public interface Biome {
    
    public List<Tile> defineBiomes(List<Tile> tiles, double min_humid, double max_humid, int min_elev, int max_elev);
    
}
