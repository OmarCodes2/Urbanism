package IslandGenerator.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.sound.sampled.SourceDataLine;

import IslandGenerator.model.Island;
import IslandGenerator.model.Biomes.Biome;
import IslandGenerator.model.Biomes.BiomeTypes.Arctic;
import IslandGenerator.model.Biomes.BiomeTypes.Mesa;
import IslandGenerator.model.Elevation.elevation;
import IslandGenerator.model.Elevation.ElevationProfiles.Valley;
import IslandGenerator.model.Elevation.ElevationProfiles.Volcano;
import IslandGenerator.model.Shapes.Shape;
import IslandGenerator.model.Shapes.ShapeTypes.Circle;
import IslandGenerator.model.Shapes.ShapeTypes.Square;
import IslandGenerator.model.Soil.Soil;
import IslandGenerator.model.Soil.SoilTypes.DrySoil;
import IslandGenerator.model.Soil.SoilTypes.WetSoil;
import IslandGenerator.model.Tiles.Tile;
import IslandGenerator.model.Tiles.TileTypes.AquiferTile;
import IslandGenerator.model.Tiles.TileTypes.BeachTile;
import IslandGenerator.model.Tiles.TileTypes.LakeTile;
import IslandGenerator.model.Tiles.TileTypes.OceanTile;
import IslandGenerator.calculators.HumidityCalculator;
import IslandGenerator.calculators.TileTypeCalculator;
import IslandGenerator.generator.ShapeGenerator;
import ca.mcmaster.cas.se2aa4.a2.io.Structs;

public class IslandGenerator {


    public static Island generateIsland(String shape, Structs.Mesh mesh, String elevation_profile,String num_lakes,String num_aquifers,String soil_type,String biome_type){

        
        Shape island_shape = ShapeGenerator.createShape(shape);
        elevation elev_prof = ElevationProfileGenerator.createElevationProfile(elevation_profile);
        Biome biome_prof = BiomeGenerator.generateBiome(biome_type);
        int number_lakes = LakeGenerator.generate_lakes(num_lakes);
        int number_aquifers = LakeGenerator.generate_lakes(num_aquifers);
        Soil soil = SoilGenerator.generateSoil(soil_type);

        Island island = new Island(mesh);

        List<Tile> tileList = new ArrayList<Tile>();

        List<Structs.Vertex> vertices = new ArrayList<Structs.Vertex>(mesh.getVerticesList());
        List<Structs.Polygon> polygons = mesh.getPolygonsList();
        int polygon_index = 0;

        for(Structs.Polygon poly : polygons){

            int index = poly.getCentroidIdx();
            Structs.Vertex centroid = vertices.get(index);

            //create tile with tile id, and polygon assigned to tile
            Tile newTile = TileTypeCalculator.calculateType(poly, centroid, island_shape, polygon_index, elev_prof.ElevationatDistance(centroid, island_shape));
            tileList.add(newTile);

            polygon_index += 1;
        }

        tileList = SandGenerator.addSand(tileList);
        tileList = LakeGenerator.addLakes(tileList, number_lakes);
        tileList = AquiferGenerator.addAquifers(tileList, number_aquifers);
        tileList = addHumidity(tileList, vertices,soil);

        double min_humid = findMinHumidity(tileList);
        double max_humid = findMaxHumidity(tileList);

        int min_elev = findMinElevation(tileList);
        int max_elev = findMaxElevation(tileList);

        tileList = biome_prof.defineBiomes(tileList,min_humid,max_humid,min_elev,max_elev);
        
        island.setTiles(tileList);

        getSeed(island_shape, elev_prof, tileList, soil, biome_prof);

        return island;

    }

    public static Island generateIsland(String seed,Structs.Mesh mesh){
        Island island = new Island(mesh);

        String[] split_seed = seed.split("\\.");
        
        // shape of the island is the first input, 0 for circle, 1 for valley, shape is the next input 0 for circle 1 for square
        //lakes; 5-9 means tiles 56789 are lakes 56 78 and 9
        //aquifers; same as lakes
        //rivers not completed
        //soil either 0 or 1 same as lakes

        int shape_num = Integer.parseInt(split_seed[0]);
        int elevation_num = Integer.parseInt(split_seed[1]);
        
        String lakes = split_seed[2];
        String aquifers = split_seed[3];
        // String rivers = split_seed[4];
        int soil_num = Integer.parseInt(split_seed[4]);
        int biome_prof_num = Integer.parseInt(split_seed[5]);


        Shape island_shape = ShapeGenerator.createShape(shape_num);
        elevation elevation_profile = ElevationProfileGenerator.createElevationProfile(elevation_num);
        Soil soil = SoilGenerator.generateSoil(soil_num);
        Biome biome_prof = BiomeGenerator.generateBiome(biome_prof_num);

        List<Tile> tileList = new ArrayList<Tile>();

        List<Structs.Vertex> vertices = new ArrayList<Structs.Vertex>(mesh.getVerticesList());
        List<Structs.Polygon> polygons = mesh.getPolygonsList();
        int polygon_index = 0;

        for(Structs.Polygon poly : polygons){

            int index = poly.getCentroidIdx();
            Structs.Vertex centroid = vertices.get(index);

            //create tile with tile id, and polygon assigned to tile
            Tile newTile = TileTypeCalculator.calculateType(poly, centroid, island_shape, polygon_index, elevation_profile.ElevationatDistance(centroid, island_shape));
            tileList.add(newTile);

            polygon_index += 1;
        }

        
        tileList = SandGenerator.addSand(tileList);

        tileList = LakeGenerator.addLakes(tileList,lakes);
        tileList = AquiferGenerator.addAquifers(tileList, aquifers);


        tileList = addHumidity(tileList, vertices,soil);

        double min_humid = findMinHumidity(tileList);
        double max_humid = findMaxHumidity(tileList);

        int min_elev = findMinElevation(tileList);
        int max_elev = findMaxElevation(tileList);

        tileList = biome_prof.defineBiomes(tileList,min_humid,max_humid,min_elev,max_elev);

        island.setTiles(tileList);
        return island;


    }


    public static double findMinHumidity(List<Tile> list_tiles){
        double min = 1000;
        for(Tile tile : list_tiles){
            if(tile.getHumidity() < min){
                min = tile.getHumidity();
            }
        } return min;
    }

    public static double findMaxHumidity(List<Tile> list_tiles){
        double max = 0;
        for(Tile tile: list_tiles){
            if(tile.getHumidity() > max){
                max = tile.getHumidity();
            }
        } return max;
    }

    public static int findMinElevation(List<Tile> list_tiles){
        int min = 2001;
        for(Tile tile : list_tiles){
            if(!(tile instanceof AquiferTile)){
                if(tile.getElevation() < min){
                    min = tile.getElevation();
                }
            }
        } return min;
    }

    public static int findMaxElevation(List<Tile> list_tiles){
        int max = 0;
        for(Tile tile: list_tiles){
            if(tile.getElevation() > max){
                max = tile.getElevation();
            }
        } return max;
    }






    

    //pass in river objects in here too
    public static List<Tile> addHumidity(List<Tile> tile_list, List<Structs.Vertex> vertice_list,Soil soil_type){
        for(Tile tile : tile_list){
            if( tile.getType().equals("lake") || tile.getType().equals("aquifer")){
                HumidityCalculator.calculateSurroundHumidity(tile, tile_list, vertice_list,soil_type);
            }
        }

        return tile_list;
    }


    private static void getSeed(Shape island_shape, elevation elev_prof, List<Tile> tiles, Soil soil_type, Biome biome_type){
        String seed = "";
        List<Integer> lake_ids = new ArrayList<>();
        List<Integer> aquifer_ids = new ArrayList<>();

        if (island_shape instanceof Square) {
            seed += "0.";
        } else if (island_shape instanceof Circle) {
            seed += "1.";
        }
        
        if (elev_prof instanceof Volcano) {
            seed += "0.";
        } else if (elev_prof instanceof Valley) {
            seed += "1.";
        }

        for(Tile tile: tiles){
            if(tile.getType().equals("lake")){
                lake_ids.add(tile.getId());
            }
            else if(tile.getType().equals("aquifer")){
                aquifer_ids.add(tile.getId());
            }
        }

        String lakeidString = lake_ids.stream().map(Object::toString).collect(Collectors.joining(","));
        String aquiferidString = aquifer_ids.stream().map(Object::toString).collect(Collectors.joining(","));
       
        seed += lakeidString + ".";
        seed += aquiferidString + ".";

        if(soil_type instanceof WetSoil){
            seed += "0.";
        }
        else if(soil_type instanceof DrySoil){
            seed += "1.";
        }

        if(biome_type instanceof Mesa){
            seed += "0";
        }

        else if(biome_type instanceof Arctic){
            seed += "1";
        }

        System.out.println("Seed Generated: " + seed);
        
    }

}
