package IslandGenerator.model;
import java.util.List;

import IslandGenerator.model.Tiles.Tile;
public class River {
   private List<Integer> path;
   private int width;

   public River(int width, Tile startTile){
    this.width = width;
    this.path.add(startTile.getId());
   }
   public void addToPath(Tile addTile){
    path.add(addTile.getId());
   }
   public int getWidth(){
    return this.width;
   }
   public List<Integer> insideOfPath(Tile tile) {
    int index = path.indexOf(tile.getId());
    if (index >= 0) {
        return path.subList(index, path.size());
    } else {
        return null;
    }
}

}
