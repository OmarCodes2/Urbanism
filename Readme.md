# Mesh Generator

  - Author: Omar Bakr

## How to install?

```
mosser@azrael A2 % mvn install
```

It creates two jars:

  1. `generator/generator.jar` to generate meshes
  2. `visualizer/visualizer.jar` to visualize such meshes as SVG files

## Examples of execution

### Generating a mesh, grid or irregular

```
mosser@azrael A2 % java -jar generator/generator.jar -k grid -h 1080 -w 1920 -p 1000 -s 20 -o img/grid.mesh
mosser@azrael A2 % java -jar generator/generator.jar -k grid -h 1080 -w 1920 -p 1000 -s 20 -o img/irregular.mesh
mosser@azrael A2 % java -jar generator/generator.jar -k irregular -h 1080 -w 1920 -p 1000 -s 20 -o img/input.mesh

```

One can run the generator with `-help` as option to see the different command line arguments that are available

### Visualizing a mesh, (regular or debug mode)

```
mosser@azrael A2 % java -jar visualizer/visualizer.jar -i img/grid.mesh -o img/grid.svg          
mosser@azrael A2 % java -jar visualizer/visualizer.jar -i img/grid.mesh -o img/grid_debug.svg -x
mosser@azrael A2 % java -jar visualizer/visualizer.jar -i img/irregular.mesh -o img/irregular.svg   
mosser@azrael A2 % java -jar visualizer/visualizer.jar -i img/irregular.mesh -o img/irregular_debug.svg -x
```

### Generating an island

```
mosser@azrael A2 % java -jar island/island.jar -i img/input.mesh -o img/lagoon.mesh -shape square -cities 10

Utilizing Seed CLI:
Seed Structure: (#1.#2.#3.#4.#5.#6.#7) where arguments are separated by periods. 

#1 : (SHAPE OF ISLAND) 0 - Square, 1 - Circle
#2 : (ELEVATION PROFILE) 0 - Volcano, 1 - Valley
#3 : (LAKES) Tile indexes are separated by commas. Only Land Tiles will be modified to generate a Lake Tile.
#4 : (Aqufiers) *SEE LAKES* NOTE: Aqufiers can re-rendered over a Lake Tile, meaning the Lake Tile will be overwritten to form an Aquifer Tile
#5 : (SOIL PROFILE) 0 - Wet, 1 - Dry
#6 : (BIOMES) 0 - MESA, 1 - ARCTIC
#7 : (CITIES) int > 0. Input an integer greater than 0, if the cities parameter is not passed in it will automatically assume 5

java -jar island/island.jar -i img/input.mesh -o img/lagoon.mesh -seed 0.0.123,111,40.123.0.1 -cities 10


```

One can run the generator with `-help` as option to see the different command line arguments that are available
Note: PDF versions of the SVG files were created with `rsvg-convert`.

### Product Backlog
| Id | Feature title | Who? | Start | End | Status |
|:--:|---------------|------|-------|-----|--------|
| F01 (Graph ADT) | Create a Graph ADT that can represent Nodes and Edges| Omar | 2023-04-06 | 2023-04-06 | D |
| F02 (Node and Edge Attributes) | Allow the ability to hold attributes within Nodes and Edges | Omar | 2023-04-06 | 2023-04-06 | D |
| F03 (Pathfinding Interface) | Define a public contract/interface for finding a path between two nodes | Omar | 2023-04-06 | 2023-04-06 | D|
| F04 (Pathfinder Algorithm) |Implement a pathfinder algorithm to find a shortest path between two nodes | Omar | 2023-04-06 |2023-04-06 | D |
| F05 (Generate Graph) |Generate a graph that corresponds with the island | Omar | 2023-04-12 |2023-04-12 | D |
| F06 (Generate Cities) |Generate cities and ensure they are added to the mesh that is outputted while ensuring a star city is chosen | Omar | 2023-04-12 |2023-04-12 | D |
| F07 (Connect to star city) |Connect all cities to the star city | Omar | 2023-04-12 |2023-04-12 | D |
| F08 (Visualize Path) |Visualize the Roads to the cities | Omar | 2023-04-12 |2023-04-12 | D |
| F09 (Visualize Nodes) |Visualize the cities when visualizer is called and ensure the star city has a unique color| Omar | 2023-04-12 |2023-04-12 | D |
| F010 (CLI) |Allow the user to choose no of cities from CLI | Omar | 2023-04-12 |2023-04-12 | D |



