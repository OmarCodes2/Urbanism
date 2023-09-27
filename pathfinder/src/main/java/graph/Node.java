package graph;

public class Node {
    private int id;
    private String name;
    private double elevation;

    public Node (int id, String name, double elevation ){
        this.id = id;
        this.name = name;
        this.elevation = elevation;
    }
    public int getId(){
        return this.id;
    }
}
