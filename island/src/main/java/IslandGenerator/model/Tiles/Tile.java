package IslandGenerator.model.Tiles;

import IslandGenerator.model.Elevation.elevation;
import IslandGenerator.model.Tiles.TileTypes.BeachTile;
import IslandGenerator.model.Tiles.TileTypes.LandTile;
import ca.mcmaster.cas.se2aa4.a2.io.Structs;

public abstract class Tile {
    // private double elevation;
    // private double humidity;
    // private double soilAbsorption;
    private Structs.Polygon polygon;
    protected String color;
    private int id;
    private int elevation;
    private double humidity;

    public Tile(Structs.Polygon polygon, String color, int id,int elevation, double humidity) {
        this.polygon = polygon;
        this.color = color;
        this.id = id;
        this.elevation = elevation;
        this.humidity = humidity;
    }

    public abstract String getType();
    
    public Structs.Polygon getPolygon(){
        return this.polygon;
    }
    public String getColor(){
        return this.color;
    }

    public int getElevation(){
        return this.elevation;
    }
    
    public int getId(){
        return this.id;
    }

    public void addHumidity(double humid) {
        if (this instanceof LandTile || this instanceof BeachTile) {
            this.humidity += humid;
        }
    }

    public double getHumidity(){
        return this.humidity;
    }

    public void setColor(String color){
        this.color = color;
    }
    // Getters and setters for elevation, humidity, and soilAbsorption
}