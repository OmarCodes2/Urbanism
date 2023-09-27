package IslandGenerator.calculators;

import ca.mcmaster.cas.se2aa4.a2.io.Structs;

public class DistanceCalculator {
    public static int calculateDistance(Structs.Vertex centroid1, Structs.Vertex centroid2){
        int dx = (int) (centroid1.getX() - centroid2.getX());

        int dy = (int) (centroid1.getY() - centroid2.getY());



        return (int) (Math.sqrt(dx * dx + dy * dy));
    }
}
