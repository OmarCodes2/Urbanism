import ca.mcmaster.cas.se2aa4.a2.io.MeshFactory;
import ca.mcmaster.cas.se2aa4.a2.io.Structs;
import IslandGenerator.configuration.*;
import IslandGenerator.generator.IslandGenerator;
import IslandGenerator.generator.IslandtoMesh;
import IslandGenerator.model.Island;

public class Main{

    public static void main(String[] args) throws Exception {
        Configuration config = new Configuration(args);
        Island island;
        // Structs.Mesh aMesh = new MeshFactory().read("img/input.mesh");
        Structs.Mesh aMesh = new MeshFactory().read(config.input());

     
        if(!(config.seed() == null)){
            island = IslandGenerator.generateIsland(config.seed(),aMesh);
        }

        else{

            island = IslandGenerator.generateIsland(config.shape(), aMesh,config.altitude(),config.lakes(),config.aquifers(),config.soil_type(), config.biome());
        //Island island = IslandGenerator.generateIsland("square", aMesh,"volcano","4","4");
        }
        
        Structs.Mesh.Builder islandMesh = IslandtoMesh.generateMesh(island,config.map(), config.cities());
        
        new MeshFactory().write(islandMesh.build(), config.output());
    }
    
  
    
}

