package IslandGenerator.CityGenerator;

import graph.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import graph.Graph;

public class CityPlanner {
    public static List<Node> selectCities(Graph graph, int noCities) {
        List<Node> nodeList = new ArrayList<>(graph.getNodes());
        Collections.shuffle(nodeList);

        List<Node> cities = new ArrayList<>();

        for (int i = 0; i < noCities && i < nodeList.size(); i++) {
            cities.add(nodeList.get(i));
        }
        return cities;
    }
}