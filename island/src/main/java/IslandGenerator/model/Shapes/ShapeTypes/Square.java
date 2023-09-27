package IslandGenerator.model.Shapes.ShapeTypes;

import IslandGenerator.model.Shapes.Shape;
import ca.mcmaster.cas.se2aa4.a2.io.Structs;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Vertex;

public class Square extends Shape {
    public int side_length;

    public Square(int side_length) {
        this.side_length = side_length;
    }


    public void setRadius(int side_length1) {
        this.side_length = side_length1;
    }

    @Override
    public int getDimension(){
        return(this.side_length);
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

        int dx = Math.abs((int) centroid.getX() - center_x);
        int dy = Math.abs((int) centroid.getY() - center_y);

        if(dx > this.side_length/2 || dy > this.side_length/2){
            return false;
        }
        
        if(dx + dy <= this.side_length){
            return true;
        }

        return false;
    }
}