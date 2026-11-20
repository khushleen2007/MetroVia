package StandardMap;

import java.util.HashMap;
import java.util.Map;

// Helper class to - Displays stations, neighbours, adjacency list and a text map.
public class StandardMapUI {
    StandardGraph graph = new StandardGraph();
    public void displayStations(){
        System.out.println("\n -------- List of stations and neighbours --------");
        for (Map.Entry<String, HashMap<String, Double>> station : graph.map.entrySet()) {
            System.out.println("Station Name: " + station.getKey() + ": ");
            for(Map.Entry<String, Double> n : station.getValue().entrySet()){
                System.out.println("\t" + n.getKey() + ": " + n.getValue() + "km");
            }
        }
    }

    public void displayAdjacencyList(){
        System.out.println("\n -------- List of stations in Adjacency List --------");
        for(Map.Entry<String, HashMap<String, Double>> station : graph.map.entrySet()){
            System.out.print(station.getKey() + " -> ");
            for(Map.Entry<String, Double> neighbor : station.getValue().entrySet()){
                System.out.print(neighbor.getKey() + " - " + neighbor.getValue() + "km   ");
            }
            System.out.println();
        }
    }
    
    // Disadvantage [If the original map changes, This wont be accurate to show the Network]
    // Because of which automatic generation is used
    public void displayMap(){
        System.out.println("\n    -------------------- Graphical representaion -------------------");
    System.out.println("""

     [Uran] ---- 7 ---- [Kharghar] ---- 12 ---- [Seawoods]      [Chembur]
                        /       |              /    |           / 
                   3  /         |            /      |         / 
                    /          5|       13 /        | 6     / 15
                  /             |        /          |     /
                /               |      /            |   /
     [Khandeshwar] ---- 4 ---- [Belapur]          [Nerul]

    """);
    }
}
