package PersonalizedMap;

import java.util.HashMap;
import java.util.Map;

// Helper class to - Displays stations, neighbours, adjacency list and a text map.
public class PersonalizedMapUI {
    PersonalizedGraph graph = new PersonalizedGraph();
    public void displayAdjacencyList(){
        System.out.println("\n -------- List of stations in Adjacency List --------");
        for(Map.Entry<String, HashMap<String, Double>> station : graph.personalizedMap.entrySet()){
            System.out.print(station.getKey() + " -> ");
            for(Map.Entry<String, Double> neighbor : station.getValue().entrySet()){
                System.out.print(neighbor.getKey() + " - " + neighbor.getValue() + "km   ");
            }
            System.out.println();
        }
    }
    public void displayStations(){
        System.out.println("\n -------- List of stations and neighbours --------");
        for (Map.Entry<String, HashMap<String, Double>> station : graph.personalizedMap.entrySet()) {
            System.out.println("Station Name: " + station.getKey() + ": ");
            for(Map.Entry<String, Double> n : station.getValue().entrySet()){
                System.out.println("\t" + n.getKey() + ": " + n.getValue() + "km");
            }
        }
    }
}
