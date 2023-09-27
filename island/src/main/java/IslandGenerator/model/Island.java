package IslandGenerator.model;

import java.util.List;

import IslandGenerator.generator.IslandGenerator;

import IslandGenerator.model.Tiles.Tile;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Mesh;

public class Island {
    private List<Tile> tiles;
    private List<River> rivers;
    private Mesh islandMesh;



    public Island(Mesh mesh) {
        this.islandMesh = mesh;
    }
    public Mesh getMesh(){
        return this.islandMesh;
    }

    public void setRivers(List<River> rivers){
        this.rivers = rivers;
    }
    public List<River> getRivers(){
        return this.rivers;
    }
    public void setTiles(List<Tile> tiles){
        this.tiles = tiles;
    }
    public List<Tile> getTiles(){
        return this.tiles;
    }
}
