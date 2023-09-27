package IslandGenerator.generator;

import IslandGenerator.model.Elevation.elevation;
import IslandGenerator.model.Elevation.ElevationProfiles.Valley;
import IslandGenerator.model.Elevation.ElevationProfiles.Volcano;

public class ElevationProfileGenerator {
    public static elevation createElevationProfile(String elevationprofile) {
        elevation elevation_prof;
        switch (elevationprofile) {
            case "volcano":
                elevation_prof =  new Volcano();
                break;
                
            case "valley":
                elevation_prof = new Valley();
                break;
                
            default:
                elevation_prof = new Volcano();
                break;
        }
        return elevation_prof;
    }

    public static elevation createElevationProfile(int num){
        elevation elevation_prof;
        switch (num) {
            case 0:
                elevation_prof =  new Volcano();
                break;
                
            case 1:
                elevation_prof = new Valley();
                break;
                
            default:
                elevation_prof = new Volcano();
                break;
        }
        return elevation_prof;
    }
}
