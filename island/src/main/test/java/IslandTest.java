import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

import IslandGenerator.calculators.DistanceCalculator;
import IslandGenerator.generator.AquiferGenerator;
import IslandGenerator.generator.ElevationProfileGenerator;
import IslandGenerator.generator.IslandGenerator;
import IslandGenerator.generator.LakeGenerator;
import IslandGenerator.generator.ShapeGenerator;
import IslandGenerator.generator.SoilGenerator;
import IslandGenerator.model.Elevation.ElevationProfiles.Valley;
import IslandGenerator.model.Elevation.ElevationProfiles.Volcano;
import IslandGenerator.model.Shapes.ShapeTypes.Circle;
import IslandGenerator.model.Shapes.ShapeTypes.Square;
import IslandGenerator.model.Soil.SoilTypes.WetSoil;
import IslandGenerator.model.Tiles.Tile;
import IslandGenerator.model.Tiles.TileTypes.AquiferTile;
import IslandGenerator.model.Tiles.TileTypes.LakeTile;
import IslandGenerator.model.Tiles.TileTypes.LandTile;
import IslandGenerator.model.Tiles.TileTypes.OceanTile;
import ca.mcmaster.cas.se2aa4.a2.io.Structs;

public class IslandTest {
    @Test
    public void TestDistanceCalc(){
        Structs.Vertex centroid1 = Structs.Vertex.newBuilder().setX(0).setY(0).build();
        Structs.Vertex centroid2 = Structs.Vertex.newBuilder().setX(1).setY(0).build();
        int distance = DistanceCalculator(centroid1,centroid2);
        int expected_distance = 1;

        assertEquals(expected_distance, distance, 0.0001);

    }


    @Test
    void testGetSeed() {
        // Create test data
        Square square = new Square(800);
        Valley valley = new Valley();
        List<Tile> tiles = new ArrayList<>();

        tiles.add(new LakeTile(null, 0, 0));
        tiles.add(new AquiferTile(null, 1));

        WetSoil wetSoil = new WetSoil();
        Arctic arctic = new Arctic();

        String seed = IslandGenerator.getSeed(square, valley, tiles, wetSoil, arctic);

        String expected_seed = "0.1.0.1.0.1";

        assertEquals(expected_seed,seed);
    }

    @Test
    void testElevationGen(){
        elevation elevation_prof = ElevationProfileGenerator.createElevationProfile("volcano");

        assertTrue(elevation_prof instanceof Volcano);
    }

    @Test
    void testShapeGen(){
        Shape shape = ShapeGenerator.createShape("circle");

        assertTrue(shape instanceof Circle);
    }

    @Test
    void testSoilGen(){
        Soil soil = SoilGenerator.generateSoil("wet");

        assertTrue(soil instanceof WetSoil);
    }

    @Test 
    void testAquiferGen(){
        List<Tile> tiles = new ArrayList<>();
        Structs.Polygon polygon = Structs.Polygon.newBuilder().build();

        tiles.add(new LandTile(polygon,0,500));
        tiles.add(new OceanTile(polygon,1));
        tiles.add(new LandTile(polygon, 2, 245));
        tiles.add(new OceanTile(polygon, 3));
        tiles = AquiferGenerator.addAquifers(tiles, 20);

        int aquifer_tiles = 0;

        for(Tile tile : tiles){
            if(tile instanceof AquiferTile){
                aquifer_tiles += 1;
            }
        }

        assertTrue(aquifer_tiles <= 20);
        
    }

    @Test
    void testLakeGen(){
        List<Tile> tiles = new ArrayList<>();
        Structs.Polygon polygon = Structs.Polygon.newBuilder().build();

        tiles.add(new LandTile(polygon,0,500));
        tiles.add(new OceanTile(polygon,1));
        tiles.add(new LandTile(polygon, 2, 245));
        tiles.add(new OceanTile(polygon, 3));
        tiles = LakeGenerator.addLakes(tiles, 20);

        int lake_tiles = 0;

        for(Tile tile : tiles){
            if(tile instanceof LakeTile){
                lake_tiles += 1;
            }
        }

        assertTrue(lake_tiles <= 20);
    }


    //test calculators

    // @Test 
    // void testHumidityCalc(){
    //     List<Tile> tile_list = new ArrayList<>();
    //     Structs.Polygon.Builder polygon = new Structs.Polygon.newBuilder();
    
    //     Soil soil_type = WetSoil();



    //     Tile tile = new Tile();
    //     tile_list.add();
    //     double humidity = calculateSurroundHumidity(Tile tile, List<Tile> tile_list,List<Structs.Vertex> vertice_list, Soil soil_type);
    // }
}
