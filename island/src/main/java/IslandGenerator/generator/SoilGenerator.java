package IslandGenerator.generator;

import IslandGenerator.model.Soil.Soil;
import IslandGenerator.model.Soil.SoilTypes.DrySoil;
import IslandGenerator.model.Soil.SoilTypes.WetSoil;

public class SoilGenerator {
    public static Soil generateSoil(String soiltype){
        Soil soil;
        switch (soiltype) {
            case "wet":
                soil =  new WetSoil();
                break;
            case "dry":
                soil =  new DrySoil();
                break;
            default:
                soil = new WetSoil();
                break;
        }
        return soil;
    }

    public static Soil generateSoil(int soiltype){
        Soil soil;
        switch (soiltype) {
            case 0:
                soil =  new WetSoil();
                break;
            case 1:
                soil =  new DrySoil();
                break;
            default:
                soil = new WetSoil();
                break;
        }
        return soil;
    }
}
