package IslandGenerator.model.Shapes.ShapeTypes;


import IslandGenerator.model.Shapes.Shape;
import ca.mcmaster.cas.se2aa4.a2.io.Structs;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Vertex;

//make lagoon a shape

public class Circle extends Shape {
    public int radius;

    public Circle(int radius) {
        this.radius = radius;
    }


    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public int getDimension(){
        return(this.radius);
    }

    @Override
    public int getDistance(Structs.Vertex centroid) {
        int center_x = 1920/2;
        int center_y = 1080/2;

        int distance = (int)Math.sqrt((center_x - centroid.getX())*(center_x - centroid.getX()) + (center_y - centroid.getY())*(center_y - centroid.getY()));

        return distance;
    }
    //for now the center point will be a hard coded value 1920/2 = center_x and 1080/2 = center_y
    @Override
    public boolean inside(Structs.Vertex centroid){


        int center_x = 1920/2;
        int center_y = 1080/2;

        int distance = (int)Math.sqrt((center_x - centroid.getX())*(center_x - centroid.getX()) + (center_y - centroid.getY())*(center_y - centroid.getY()));
       
        if(distance < this.radius){
            return true;
        }

        return false;
    }
    // boolean function, inside takes in vertex, returns true or false if vertex is in the island
}
