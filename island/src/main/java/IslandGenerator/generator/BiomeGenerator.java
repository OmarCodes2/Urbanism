package IslandGenerator.generator;

import IslandGenerator.model.Biomes.Biome;
import IslandGenerator.model.Biomes.BiomeTypes.Arctic;
import IslandGenerator.model.Biomes.BiomeTypes.Mesa;

public class BiomeGenerator {
   public static Biome generateBiome(String biome_type){
    Biome biome;
    switch (biome_type) {
        case "mesa":
            
            biome = new Mesa();
            break;
        case "arctic":
            biome = new Arctic();
            break;
        default:
            biome = new Mesa();
            break;
    }

    return biome;
   }

   public static Biome generateBiome(int biome_type){
    Biome biome;
    switch (biome_type) {
        case 0:
            biome = new Mesa();
            break;
        case 1:
            biome = new Arctic();
            break;
        default:
            biome = new Mesa();
            break;
    }

    return biome;
   }
}
