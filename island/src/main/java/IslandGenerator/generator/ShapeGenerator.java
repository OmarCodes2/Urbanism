package IslandGenerator.generator;

import IslandGenerator.model.Shapes.Shape;
import IslandGenerator.model.Shapes.ShapeTypes.Circle;
import IslandGenerator.model.Shapes.ShapeTypes.Square;

public class ShapeGenerator {
    public static Shape createShape(String shapeType) {
        Shape shape;
        switch (shapeType) {
            case "square":
                shape = new Square(800);
                break;
            case "circle":
                shape =  new Circle(500);
                break;
            default:
                shape =  new Circle(500);
                break;
        }

        return shape;
    }

    public static Shape createShape(int num){
        Shape shape;
        switch (num) {
            case 0:
                shape = new Square(800);
                break;
            case 1:
                shape =  new Circle(500);
                break;
            default:
                shape =  new Circle(500);
                break;
        }

        return shape;
    }
}
